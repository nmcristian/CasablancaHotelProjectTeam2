package datasource;

import domain.Client;
import domain.Employee;
import domain.Facility;
import domain.FacilityReservation;
import domain.Reservation;
import domain.Room;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class DBFacade
{

    private DataMapper dataMapper;
    private Connection connection;
    private UnitOfWork unitOfWork;

    private static DBFacade instance;

    private DBFacade()
    {
        dataMapper = new DataMapper();
        unitOfWork = null;
    }

    public static DBFacade getInstance()
    {
        if (instance == null)
        {
            instance = new DBFacade();
        }
        return instance;
    }

    public boolean resetConnection(String dbHost, String dbUsername, String dbPassword)
    {
        connection = new DBConnector(dbHost, dbUsername, dbPassword).getConnection();
        try
        {
            connection.setAutoCommit(true);
            // termination by the garbage collector
        } catch (SQLException ex)
        {
            Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection != null;
    }

    public boolean closeConnection()
    {
        try
        {
            connection.close();
        } catch (SQLException ex)
        {
            Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean checkUserLogin(String username, String password)
    {
        return dataMapper.checkUserLogin(username, password, connection);
    }

    public String getUserType()
    {
        return dataMapper.getUserType();
    }

    public ArrayList getAllRooms()
    {
        return dataMapper.getAllRooms(connection);
    }

    public ArrayList getAllClients()
    {
        return dataMapper.getAllClients(connection);
    }

    public ArrayList getAllReservations()
    {
        return dataMapper.getAllReservations(connection);
    }
    
    public Reservation getReservationByID(int reservationID)
    {
        return dataMapper.getReservationByID(reservationID, connection);
    }

    public ArrayList getAllFacilityReservations()
    {
        return dataMapper.getAllFacilityReservations(connection);
    }
    
    public FacilityReservation getFacilityReservationByID(int id)
    {
        return dataMapper.getFacilityReservationByID(id, connection);
    }

    public ArrayList getAllEmployees()
    {
        return dataMapper.getAllEmployees(connection);
    }
    
     public Employee getEmployeeByID(int employeeID)
     {
         return dataMapper.getEmployeeByID(employeeID, connection);
     }

    public ArrayList getAllFacilities()
    {
        return dataMapper.getAllFacilities(connection);
    }
    
    public Facility getFacilityByName(String facilityName)
    {
        return dataMapper.getFacilityByName(facilityName, connection);
    }

    public ArrayList getAllRoomTypes()
    {
        return dataMapper.getAllRoomTypes(connection);
    }
    
    public Room getRoomTypeByType(String type)
    {
        return dataMapper.getRoomTypeByType(type, connection);
    }

    public Room getRoomByRoomNumber(int roomNumber)
    {
        return dataMapper.getRoomByRoomNumber(roomNumber, connection);
    }
    
    public ArrayList getRoomsByAvailability(Date from, Date to)
    {
        return dataMapper.getRoomsByAvailability(new java.sql.Date(from.getTime()), new java.sql.Date(to.getTime()), connection);
    }
    
    public Client getClientByID(long clientID)
    {
        return dataMapper.getClientByID(clientID, connection);
    }

    public int getNextDataSeqNumber()
    {
        return dataMapper.getNextDataSeqNumber(connection);
    }

    public boolean startBusinessProcess(String resultType)
    {
        if (unitOfWork == null)
        {
            unitOfWork = new UnitOfWork(resultType, dataMapper);
        }
        return true;
    }

    public boolean commitBusinessProcess()
    {
        if (unitOfWork.commit(connection))
        {
            unitOfWork = null;
            return true;
        } else
        {
            return false;
        }
    }

    public boolean discardBusinessProcess()
    {
        unitOfWork = null;
        return true;
    }

    public boolean addNewReservation(Reservation reservation)
    {
        return unitOfWork.add(reservation, connection);
    }
    
    public ArrayList<Integer> getUnavailableRoomsNumbers()
    {
        return dataMapper.getUnavailableRoomsNumbers();
    }
    public boolean addNewClient(Client client)
    {
        return unitOfWork.add(client, connection);
    }
}
