package datasource;

import domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class DataMapper
{

    static boolean testRun = false;   // used to enable test output
    private String userType;
    private ArrayList<Integer> unavailableRoomsNumbers;
    Scanner scan = new Scanner(System.in);

    public boolean checkUserLogin(String username, String password, Connection connection)
    {
        userType = null;
        String sqlString1 = "SELECT POSITION, PASSWORD FROM EMPLOYEES "
                + "WHERE ID = ?";
        String sqlString2 = "SELECT PASSWORD FROM CLIENTS "
                + "WHERE ID = ?";
        PreparedStatement statement;
        try
        {
            statement = connection.prepareStatement(sqlString1);
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                userType = rs.getString(1);
                if (rs.getString(2).equals(password))
                {
                    return true;
                }
            } else
            {
                statement = connection.prepareStatement(sqlString2);
                statement.setString(1, username);

                rs = statement.executeQuery();
                if (rs.next())
                {
                    userType = "Client";
                    if (rs.getString(1).equals(password))
                    {
                        return true;
                    }
                }
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - checkUserLogin");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String getUserType()
    {
        return userType;
    }

    public ArrayList getAllRooms(Connection connection)
    {
        ArrayList result = new ArrayList<>();
        PreparedStatement statement;
        String sqlString = "SELECT R.ID, R.TYPE, RT.CAPACITY, RT.PRICE FROM ROOMS R "
                + "JOIN ROOM_TYPES RT ON R.TYPE = RT.TYPE "
                + "ORDER BY R.ID";

        try
        {
            statement = connection.prepareStatement(sqlString);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                result.add(new Room(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
            }

            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getAllRooms");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Room getRoomByRoomNumber(int roomNumber, Connection connection)
    {
        PreparedStatement statement;
        Room room = null;
        String sqlString = "SELECT R.ID, R.TYPE, RT.CAPACITY, RT.PRICE FROM ROOMS R "
                + "JOIN ROOM_TYPES RT ON R.TYPE = RT.TYPE "
                + "WHERE R.ID = ? ";

        try
        {
            statement = connection.prepareStatement(sqlString);
            statement.setInt(1, roomNumber);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                room = new Room(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getRoomsByReservationID");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return room;
    }

    public ArrayList getRoomsByReservationID(int reservationID, Connection connection)
    {
        ArrayList result = new ArrayList<>();
        PreparedStatement statement;
        String sqlString = "SELECT R.ID, R.TYPE, RT.CAPACITY, RT.PRICE, RR.STARTING_DATE, RR.ENDING_DATE FROM ROOMS R "
                + "JOIN ROOM_TYPES RT ON R.TYPE = RT.TYPE "
                + "JOIN ROOM_RESERVATIONS RR ON R.ID = RR.ROOM_ID "
                + "JOIN RESERVATIONS RSV ON RR.RES_ID = RSV.ID "
                + "WHERE RSV.ID = ? "
                + "ORDER BY R.ID ";

        try
        {
            statement = connection.prepareStatement(sqlString);
            statement.setInt(1, reservationID);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                result.add(new Room(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5), rs.getDate(6)));
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getRoomsByReservationID");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList getRoomsByAvailability(Date from, Date to, Connection connection)
    {
        ArrayList result = new ArrayList<>();
        PreparedStatement statement;
        String sqlString = "SELECT R.ID, R.TYPE, RT.CAPACITY, RT.PRICE FROM ROOMS R "
                + "JOIN ROOM_TYPES RT ON R.TYPE = RT.TYPE "
                + "WHERE ID NOT IN ( "
                + "SELECT RR.ROOM_ID FROM ROOM_RESERVATIONS RR "
                + "JOIN ROOMS R ON RR.ROOM_ID = R.ID "
                + "JOIN ROOM_TYPES RT ON R.TYPE = RT.TYPE "
                + "WHERE (STARTING_DATE < ? AND ENDING_DATE > ? "
                + "OR STARTING_DATE >= ? AND STARTING_DATE < ?)) "
                + "ORDER BY R.TYPE";

        try
        {
            statement = connection.prepareStatement(sqlString);
            statement.setDate(1, from);
            statement.setDate(2, from);
            statement.setDate(3, from);
            statement.setDate(4, to);
            ResultSet rs = statement.executeQuery();
            Room room;
            while (rs.next())
            {
                room = new Room(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), from, to);
                room.calculatePricePerWholeStay();
                result.add(room);
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getRoomsByReservationID");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public boolean confirmRoomAvailability(int roomNumber, Date from, Date to, Connection connection)
    {
        ArrayList result = new ArrayList<>();
        PreparedStatement statement;
        String sqlString = "SELECT R.ID, R.TYPE, RT.CAPACITY, RT.PRICE FROM ROOMS R "
                + "JOIN ROOM_TYPES RT ON R.TYPE = RT.TYPE "
                + "WHERE R.ID = ? AND R.ID NOT IN ( "
                + "SELECT RR.ROOM_ID FROM ROOM_RESERVATIONS RR "
                + "JOIN ROOMS R ON RR.ROOM_ID = R.ID "
                + "JOIN ROOM_TYPES RT ON R.TYPE = RT.TYPE "
                + "WHERE (STARTING_DATE < ? AND ENDING_DATE > ? "
                + "OR STARTING_DATE >= ? AND STARTING_DATE < ?)) ";

        try
        {
            statement = connection.prepareStatement(sqlString);
            statement.setInt(1, roomNumber);
            statement.setDate(2, from);
            statement.setDate(3, from);
            statement.setDate(4, from);
            statement.setDate(5, to);
            ResultSet rs = statement.executeQuery();
            Room room;
            while (rs.next())
            {
                room = new Room(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), from, to);
                room.calculatePricePerWholeStay();
                result.add(room);
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getRoomsByReservationID");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result.size() == 1;
    }

    public ArrayList getAllClients(Connection connection)
    {
        ArrayList result = new ArrayList<>();
        PreparedStatement statement;
        String sqlString = "SELECT ID, FIRST_NAME, LAST_NAME, COUNTRY FROM CLIENTS";

        try
        {
            statement = connection.prepareStatement(sqlString);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                result.add(new Client(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getAllClients");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList getClientsByReservationID(int reservationID, Connection connection)
    {
        ArrayList result = new ArrayList<>();
        PreparedStatement statement;
        String sqlString = "SELECT C.ID, C.FIRST_NAME, C.LAST_NAME, C.COUNTRY FROM CLIENTS C "
                + "JOIN CLIENTS_RESERVATIONS CR ON C.ID = CR.CLIENT_ID "
                + "JOIN RESERVATIONS R ON CR.RES_ID = R.ID "
                + "WHERE R.ID = ?";

        try
        {

            statement = connection.prepareStatement(sqlString);
            statement.setInt(1, reservationID);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                result.add(new Client(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getClientsByReservationID");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Client getClientByID(long clientID, Connection connection)
    {
        PreparedStatement statement;
        String sqlString = "SELECT ID, FIRST_NAME, LAST_NAME, COUNTRY FROM CLIENTS "
                + "WHERE ID = ?";

        try
        {
            statement = connection.prepareStatement(sqlString);
            statement.setLong(1, clientID);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                return new Client(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getAllClients");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList getAllReservations(Connection connection)
    {
        ArrayList result = new ArrayList<>();
        PreparedStatement statement;
        String sqlString = "SELECT ID, TOTAL_DUE, TOTAL_PAID FROM RESERVATIONS";

        try
        {
            statement = connection.prepareStatement(sqlString);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                result.add(new Reservation(rs.getInt(1), /*rs.getDouble(2),*/ rs.getDouble(3), getClientsByReservationID(rs.getInt(1), connection), getRoomsByReservationID(rs.getInt(1), connection)));
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getAllReservations");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList getAllFacilityReservations(Connection connection)
    {
        ArrayList result = new ArrayList<>();
        PreparedStatement statement;
        String sqlString = "SELECT FR. ID, C.ID, C.FIRST_NAME, C.LAST_NAME, C.COUNTRY, F.NAME, F.PRICE, F.DESCRIPTION, FR.STARTING_TIME, FR.ENDING_TIME FROM FACILITIES_RESERVATIONS FR "
                + "JOIN CLIENTS C ON FR.CLIENT_ID = C.ID "
                + "JOIN FACILITIES F ON FR.FACILITY_NAME = F.NAME";

        try
        {
            statement = connection.prepareStatement(sqlString);
            ResultSet rs = statement.executeQuery();

            Calendar d1;
            Calendar d2;
            Client c;
            Facility f;
            while (rs.next())
            {
                c = new Client(rs.getLong(2), rs.getString(3), rs.getString(4), rs.getString(5));
                f = new Facility(rs.getString(6), rs.getDouble(7), rs.getString(8));
                d1 = Calendar.getInstance();
                d1.setTime(rs.getDate(9));
                d2 = Calendar.getInstance();
                d2.setTime(rs.getDate(10));
                result.add(new FacilityReservation(rs.getInt(1), c, f, d1, d2));
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getAllFacilityReservations");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList getAllEmployees(Connection connection)
    {
        ArrayList result = new ArrayList<>();
        PreparedStatement statement;
        String sqlString = "SELECT ID, FIRST_NAME, LAST_NAME, POSITION FROM EMPLOYEES";

        try
        {
            statement = connection.prepareStatement(sqlString);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                result.add(new Employee(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getAllEmployees");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList getAllFacilities(Connection connection)
    {
        ArrayList result = new ArrayList<>();
        PreparedStatement statement;
        String sqlString = "SELECT NAME, PRICE, DESCRIPTION FROM FACILITIES";

        try
        {
            statement = connection.prepareStatement(sqlString);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                result.add(new Facility(rs.getString(1), rs.getDouble(2), rs.getString(3)));
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getAllFacilities");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList getAllRoomTypes(Connection connection)
    {
        ArrayList result = new ArrayList<>();
        PreparedStatement statement;
        String sqlString = "SELECT TYPE, CAPACITY, PRICE FROM ROOM_TYPES";

        try
        {
            statement = connection.prepareStatement(sqlString);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                result.add(new Room(rs.getString(1), rs.getInt(2), rs.getDouble(3)));
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - getAllRoomTypes");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // Retrieves the next unique order number from DB
    public int getNextDataSeqNumber(Connection connection)
    {
        int nextOrderNumber = 0;
        String SQLString = "SELECT ORDERSEQ.NEXTVAL FROM DUAL";
        PreparedStatement statement;
        try
        {
            statement = connection.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                nextOrderNumber = rs.getInt(1);
            }
        } catch (SQLException e)
        {
            System.out.println("Fail in DataMapper - getNextDataSeqNumber");
            System.out.println(e.getMessage());
        }
        return nextOrderNumber;
    }

    public boolean insertReservations(ArrayList reservations, Connection conn)
    {
        int rowsInserted = 0, totalToBeInserted = reservations.size();
        String sqlString0 = "SELECT * FROM ROOMS "
                + "WHERE ";

        for (Object o : reservations)
        {
            Reservation reservation = (Reservation) o;
            for (Room room : reservation.getRooms())
            {
                sqlString0 += "ID = " + room.getRoomNumber() + " OR ";
            }
        }
        sqlString0 = sqlString0.substring(0, sqlString0.length() - 3);
        sqlString0 += "FOR UPDATE";

        String sqlString1 = "INSERT INTO RESERVATIONS VALUES (?,?,?,?)";
        String sqlString2 = "INSERT INTO CLIENTS_RESERVATIONS VALUES (?, ?, ?)";
        String sqlString3 = "INSERT INTO ROOM_RESERVATIONS VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;

        try
        {
            statement = conn.prepareStatement(sqlString0);
            statement.executeQuery();

            System.out.println("write sth to continue");
            scan.next();

            for (Object o : reservations)
            {
                statement = conn.prepareStatement(sqlString1);
                Reservation reservation = (Reservation) o;
                totalToBeInserted += reservation.getClients().size();
                totalToBeInserted += reservation.getRooms().size();

                statement.setInt(1, reservation.getID());
                statement.setDouble(2, reservation.getTotalDue());
                statement.setDouble(3, reservation.getAlreadyPaid());
                statement.setInt(4, 1);
                rowsInserted += statement.executeUpdate();

                for (Client client : reservation.getClients())
                {
                    statement = conn.prepareStatement(sqlString2);
                    statement.setInt(1, reservation.getID());
                    statement.setLong(2, client.getId());
                    statement.setInt(3, 1);
                    rowsInserted += statement.executeUpdate();
                }
                
                unavailableRoomsNumbers = new ArrayList();
                for (Room room : reservation.getRooms())
                {
                    if (confirmRoomAvailability(room.getRoomNumber(), new java.sql.Date(room.getStartingDate().getTime()), new java.sql.Date(room.getEndingDate().getTime()), conn))
                    {
                        statement = conn.prepareStatement(sqlString3);
                        statement.setInt(1, reservation.getID());
                        statement.setInt(2, room.getRoomNumber());
                        statement.setDate(3, new java.sql.Date(room.getStartingDate().getTime()));
                        statement.setDate(4, new java.sql.Date(room.getEndingDate().getTime()));
                        statement.setInt(5, 1);
                        rowsInserted += statement.executeUpdate();
                    }
                    else
                    {
                        // here we save globally which rooms were with problems saving
                        unavailableRoomsNumbers.add(room.getRoomNumber());
                    }
                }
            }
            statement.close();
        } catch (SQLException ex)
        {
            System.out.println("Fail in DataMapper - insertReservations");
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (testRun)
        {
            System.out.println("insertOrders(): " + (rowsInserted == reservations.size())); // for test
        }

        return (rowsInserted == totalToBeInserted);
    }
    
    public ArrayList<Integer> getUnavailableRoomsNumbers()
    {
        return unavailableRoomsNumbers;
    }
}
