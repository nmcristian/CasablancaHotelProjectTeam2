package domain;

import datasource.DBFacade;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Cristian
 */
public class Controller
{

    private boolean rememberPreferencesState;
    private String username, password, dbHost, dbUsername, dbPassword, userType, searchResultType;
    private DBFacade dbFacade;
    private String[] tableColumnNames;
    private static Controller instance;
    private Reservation newReservation;
    private ArrayList searchResultList;
    private Date lastSearchFrom, lastSearchTo;

    private Controller()
    {
        readPreferences();
        newReservation = null;
        searchResultList = new ArrayList();
    }

    public static Controller getInstance()
    {
        if (instance == null)
        {
            instance = new Controller();
        }
        return instance;
    }

    public boolean connect()
    {
        if (dbFacade == null)
        {
            dbFacade = DBFacade.getInstance();
        }
        return dbFacade.resetConnection(dbHost, dbUsername, dbPassword);
    }

    public boolean disconnect()
    {
        return dbFacade.closeConnection();
    }

    private boolean readPreferences()
    {
        Scanner lineScan;
        File fileEntry = new File("connection_settings.txt");
        try
        {
            lineScan = new Scanner(fileEntry);
            dbHost = lineScan.nextLine();
            dbUsername = lineScan.nextLine();
            dbPassword = lineScan.nextLine();
            rememberPreferencesState = (lineScan.nextLine().equals("true"));
            if (rememberPreferencesState)
            {
                username = lineScan.nextLine();
                password = lineScan.nextLine();
            }
        } catch (FileNotFoundException ex)
        {
            return false;
        }
        return true;
    }

    public boolean savePreferences()
    {
        FileWriter wordsOutput;
        File currentFileToSave = new File("connection_settings.txt");
        try
        {
            currentFileToSave.createNewFile();
            wordsOutput = new FileWriter(currentFileToSave);
            wordsOutput.write(dbHost + "\n");
            wordsOutput.write(dbUsername + "\n");
            wordsOutput.write(dbPassword + "\n");
            wordsOutput.write(rememberPreferencesState + "\n");
            if (rememberPreferencesState)
            {
                wordsOutput.write(username + "\n");
                wordsOutput.write(password + "\n");
            }
            wordsOutput.close();
        } catch (IOException ex)
        {
            return false;
        }
        return true;
    }

    public boolean getRememberPreferencesState()
    {
        return rememberPreferencesState;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setRememberPreferencesState(boolean state)
    {
        this.rememberPreferencesState = state;
    }

    public void setDbHost(String host)
    {
        this.dbHost = host;
    }

    public void setDbUsername(String username)
    {
        this.dbUsername = username;
    }

    public void setDbPassword(String password)
    {
        this.dbPassword = password;
    }

    public boolean checkUserLogin()
    {
        boolean result;
        result = dbFacade.checkUserLogin(username, password);
        userType = dbFacade.getUserType();
        return result;
    }

    //will be null if the user doesn't exist
    public String getUserType()
    {
        return userType;
    }

    public Object[][] getAllRooms()
    {
        searchResultList = dbFacade.getAllRooms();
        Room room;
        if (currentReservationCreationState())
        {
            for (int i = 0; i < searchResultList.size(); i++)
            {
                room = (Room) searchResultList.get(i);
                for (Room currentlyBeingReservedRoom : newReservation.getRooms())
                {
                    if (room.getRoomNumber() == currentlyBeingReservedRoom.getRoomNumber())
                    {
                        searchResultList.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }
        searchResultType = "Rooms";
        Object[][] resultToDisplay = new Object[searchResultList.size()][4];
        tableColumnNames = new String[]
        {
            "Room number", "Room type", "Capacity", "Price/night"
        };
        int i = 0;
        for (Object o : searchResultList)
        {
            room = (Room) o;
            resultToDisplay[i][0] = room.getRoomNumber() + "";
            resultToDisplay[i][1] = room.getType();
            resultToDisplay[i][2] = room.getCapacity() + "";
            resultToDisplay[i][3] = room.getPricePerNight() + "";
            i++;
        }
        return resultToDisplay;
    }

    public Object[][] getRoomByRoomNumber(int roomNumber)
    {
        Room room = dbFacade.getRoomByRoomNumber(roomNumber);
        searchResultList = new ArrayList();
        searchResultType = "Rooms";
        Object[][] resultToDisplay;
        tableColumnNames = new String[]
        {
            "Room number", "Room type", "Capacity", "Price/night"
        };
        if (room == null)
        {
            resultToDisplay = new Object[searchResultList.size()][4];
        } else
        {
            searchResultList.add(room);
            resultToDisplay = new Object[searchResultList.size()][4];
            resultToDisplay[0][0] = room.getRoomNumber() + "";
            resultToDisplay[0][1] = room.getType();
            resultToDisplay[0][2] = room.getCapacity() + "";
            resultToDisplay[0][3] = room.getPricePerNight() + "";
        }
        return resultToDisplay;
    }

    public Object[][] getAllClients()
    {
        searchResultList = dbFacade.getAllClients();
        Client client;
        if (currentReservationCreationState())
        {
            for (int i = 0; i < searchResultList.size(); i++)
            {
                client = (Client) searchResultList.get(i);
                for (Client currentlyBeingReservedClient : newReservation.getClients())
                {
                    if (client.getId() == currentlyBeingReservedClient.getId())
                    {
                        searchResultList.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }

        searchResultType = "Clients";
        Object[][] resultToDisplay = new Object[searchResultList.size()][4];
        tableColumnNames = new String[]
        {
            "Client ID", "First name", "Last name", "Country"
        };
        int i = 0;
        for (Object o : searchResultList)
        {
            client = (Client) o;
            resultToDisplay[i][0] = client.getId() + "";
            resultToDisplay[i][1] = client.getFirstName();
            resultToDisplay[i][2] = client.getLastName();
            resultToDisplay[i][3] = client.getCountry();
            i++;
        }
        return resultToDisplay;
    }

    public Object[][] getAllReservations()
    {
        searchResultList = dbFacade.getAllReservations();
        searchResultType = "Reservations";
        Object[][] resultToDisplay = new Object[searchResultList.size()][5];
        tableColumnNames = new String[]
        {
            "ID", "Total due", "Already paid", "Clients IDs", "Rooms IDs"
        };
        int i = 0;
        Reservation reservation;
        for (Object o : searchResultList)
        {
            reservation = (Reservation) o;
            resultToDisplay[i][0] = reservation.getID() + "";
            resultToDisplay[i][1] = reservation.getTotalDue() + "";
            resultToDisplay[i][2] = reservation.getAlreadyPaid() + "";
            resultToDisplay[i][3] = reservation.getClientsIDs();
            resultToDisplay[i][4] = reservation.getRoomsIDs();
            i++;
        }
        return resultToDisplay;
    }

    public Object[][] getAllFacilityReservations()
    {
        searchResultList = dbFacade.getAllFacilityReservations();
        searchResultType = "FacilityReservations";
        Object[][] resultToDisplay = new Object[searchResultList.size()][7];
        tableColumnNames = new String[]
        {
            "ID", "Facility title", "Client's Name", "Client's ID", "From", "To", "Price"
        };
        int i = 0;
        FacilityReservation facilityReservation;
        for (Object o : searchResultList)
        {
            facilityReservation = (FacilityReservation) o;
            resultToDisplay[i][0] = facilityReservation.getID() + "";
            resultToDisplay[i][1] = facilityReservation.getFacilityTitle();
            resultToDisplay[i][2] = facilityReservation.getClientsName();
            resultToDisplay[i][3] = facilityReservation.getClientsID() + "";
            resultToDisplay[i][4] = facilityReservation.getStartingDate();
            resultToDisplay[i][5] = facilityReservation.getEndingDate();
            resultToDisplay[i][6] = facilityReservation.getPrice() + "";
            i++;
        }
        return resultToDisplay;
    }

    public Object[][] getAllEmployees()
    {
        searchResultList = dbFacade.getAllEmployees();
        searchResultType = "Employees";
        Object[][] resultToDisplay = new Object[searchResultList.size()][4];
        tableColumnNames = new String[]
        {
            "Client ID", "First name", "Last name", "Position"
        };
        int i = 0;
        Employee employee;
        for (Object o : searchResultList)
        {
            employee = (Employee) o;
            resultToDisplay[i][0] = employee.getId() + "";
            resultToDisplay[i][1] = employee.getFirstName();
            resultToDisplay[i][2] = employee.getLastName();
            resultToDisplay[i][3] = employee.getPosition();
            i++;
        }
        return resultToDisplay;
    }

    public Object[][] getAllFacilities()
    {
        searchResultList = dbFacade.getAllFacilities();
        searchResultType = "Facilities";
        Object[][] resultToDisplay = new Object[searchResultList.size()][3];
        tableColumnNames = new String[]
        {
            "Title", "Price/h", "Description"
        };
        int i = 0;
        Facility facility;
        for (Object o : searchResultList)
        {
            facility = (Facility) o;
            resultToDisplay[i][0] = facility.getTitle();
            resultToDisplay[i][1] = facility.getPrice() + "";
            resultToDisplay[i][2] = facility.getDescription();
            i++;
        }
        return resultToDisplay;
    }

    public Object[][] getAllRoomTypes()
    {
        searchResultList = dbFacade.getAllRoomTypes();
        searchResultType = "RoomTypes";
        Object[][] resultToDisplay = new Object[searchResultList.size()][3];
        tableColumnNames = new String[]
        {
            "Type", "Capacity", "Price/night"
        };
        int i = 0;
        Room room;
        for (Object o : searchResultList)
        {
            room = (Room) o;
            resultToDisplay[i][0] = room.getType();
            resultToDisplay[i][1] = room.getCapacity() + "";
            resultToDisplay[i][2] = room.getPricePerNight() + "";
            i++;
        }
        return resultToDisplay;
    }

    public String[] getTableColumnNames()
    {
        return tableColumnNames;
    }

    public String getSearchResultType()
    {
        return searchResultType;
    }

    public int getSearchResultCount()
    {
        return searchResultList.size();
    }

    public void createNewReservation()
    {
        //initialize a new Reservations arraylist
        dbFacade.startBusinessProcess("Reservations");
        newReservation = new Reservation(dbFacade.getNextDataSeqNumber());
    }

    public boolean saveNewReservation()
    {
        boolean status;

        status = dbFacade.addNewReservation(newReservation);
        status = status && dbFacade.commitBusinessProcess();
        return status;
    }

    public void discardNewReservation()
    {
        newReservation = null;
        dbFacade.discardBusinessProcess();
    }

    public boolean currentReservationCreationState()
    {

        return newReservation != null;
    }

    public void addClientToReservation(long clientID)
    {
        newReservation.addClient(dbFacade.getClientByID(clientID));
        newReservation.calculatePricePerWholeStay();
    }

    public void addRoomToReservation(int roomNumber)
    {
        Room currentRoom;
        for (Object o : searchResultList)
        {
            currentRoom = (Room) o;
            if (currentRoom.getRoomNumber() == roomNumber)
            {
                newReservation.addRoom(currentRoom);
                newReservation.calculatePricePerWholeStay();
                break;
            }
        }
    }

    public double getNewReservationTotalPrice()
    {
        return newReservation.getTotalDue();
    }

    public double getNewReservationDeposit()
    {
        return newReservation.getTotalDue() / 2;
    }

    public void removeClientFromReservation(int index)
    {
        searchResultList = new ArrayList();
        newReservation.removeClient(index);
    }

    public void removeRoomFromReservation(int index)
    {
        searchResultList = new ArrayList();
        newReservation.removeRoom(index);
        newReservation.calculatePricePerWholeStay();
    }

    public Object[][] getClientsFromNewReservation()
    {
        Object[][] resultToDisplay = new Object[newReservation.getClients().size()][3];
        int i = 0;
        for (Client client : newReservation.getClients())
        {
            resultToDisplay[i][0] = client.getId() + "";
            resultToDisplay[i][1] = client.getFirstName();
            resultToDisplay[i][2] = client.getLastName();
            i++;
        }
        return resultToDisplay;
    }

    public Object[][] getRoomsFromNewReservation()
    {
        Object[][] resultToDisplay = new Object[newReservation.getRooms().size()][3];
        int i = 0;
        for (Room room : newReservation.getRooms())
        {
            resultToDisplay[i][0] = room.getRoomNumber() + "";
            resultToDisplay[i][1] = room.getType();
            resultToDisplay[i][2] = room.getPricePerNight() + "";
            i++;
        }
        return resultToDisplay;
    }

    public Object[][] getRoomsByAvailability(Date from, Date to)
    {
        this.lastSearchFrom = from;
        this.lastSearchTo = to;
        searchResultList = dbFacade.getRoomsByAvailability(from, to);
        Room room;
        if (currentReservationCreationState())
        {
            for (int i = 0; i < searchResultList.size(); i++)
            {
                room = (Room) searchResultList.get(i);
                for (Room currentlyBeingReservedRoom : newReservation.getRooms())
                {
                    if (room.getRoomNumber() == currentlyBeingReservedRoom.getRoomNumber())
                    {
                        searchResultList.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }

        searchResultType = "Rooms";
        Object[][] resultToDisplay = new Object[searchResultList.size()][4];
        tableColumnNames = new String[]
        {
            "Room number", "Room type", "Capacity", "Price/night"
        };
        int i = 0;
        for (Object o : searchResultList)
        {
            room = (Room) o;
            resultToDisplay[i][0] = room.getRoomNumber() + "";
            resultToDisplay[i][1] = room.getType();
            resultToDisplay[i][2] = room.getCapacity() + "";
            resultToDisplay[i][3] = room.getPricePerNight() + "";
            i++;
        }
        return resultToDisplay;
    }

    public Date getLastSearchFrom()
    {
        return lastSearchFrom;
    }

    public Date getLastSearchTo()
    {
        return lastSearchTo;
    }

    public Object[][] dynamicSearch(String substring)
    {
        Object[][] resultToDisplay = null;
        ArrayList dynamicSearchResultList = new ArrayList();
        for (Object o : searchResultList)
        {
            if (o.toString().contains(substring))
            {
                dynamicSearchResultList.add(o);
            }
        }

        switch (searchResultType)
        {
            case "Rooms":
            {
                resultToDisplay = new Object[dynamicSearchResultList.size()][4];
                Room room;
                for (int i = 0; i < dynamicSearchResultList.size(); i++)
                {
                    room = (Room) dynamicSearchResultList.get(i);
                    resultToDisplay[i][0] = room.getRoomNumber() + "";
                    resultToDisplay[i][1] = room.getType();
                    resultToDisplay[i][2] = room.getCapacity() + "";
                    resultToDisplay[i][3] = room.getPricePerNight() + "";
                }
                break;
            }
            
            default:
            {
                resultToDisplay = new Object[0][4];
            }
        }

        return resultToDisplay;
    }
    
    public ArrayList<Integer> getUnavailableRoomsNumbers()
    {
        return dbFacade.getUnavailableRoomsNumbers();
    }
}
