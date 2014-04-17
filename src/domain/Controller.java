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
    private Object selectedObjectForEditing;

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
        result = dbFacade.checkUserLogin(Long.parseLong(username), password);
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

    public Room getRoomByRoomNrForEditing(int roomNumber)
    {
        return dbFacade.getRoomByRoomNumber(roomNumber);
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
        Object[][] resultToDisplay = new Object[searchResultList.size()][3];
        tableColumnNames = new String[]
        {
            "ID", "Clients IDs", "Rooms IDs"
        };
        int i = 0;
        Reservation reservation;
        for (Object o : searchResultList)
        {
            reservation = (Reservation) o;
            resultToDisplay[i][0] = reservation.getID() + "";
            resultToDisplay[i][1] = reservation.getClientsIDs();
            resultToDisplay[i][2] = reservation.getRoomsIDs();
            i++;
        }
        return resultToDisplay;
    }

    public Object[][] getAllFacilityReservations()
    {
        searchResultList = dbFacade.getAllFacilityReservations();
        searchResultType = "FacilityReservations";
        Object[][] resultToDisplay = new Object[searchResultList.size()][4];
        tableColumnNames = new String[]
        {
            "ID", "Facility title", "Client Name", "Client ID"
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
            "Employee ID", "First name", "Last name", "Position"
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
            resultToDisplay[i][1] = facility.getPrice();
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
        if (status)
        {
            newReservation = null;
        }
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

    public Object[][] dynamicSearch(String substring, String valueOfComboBox)
    {
        Object[][] resultToDisplay = null;
        ArrayList dynamicSearchResultList = new ArrayList();
        substring = substring.toLowerCase();
        switch (searchResultType)
        {
            case "Rooms":
            {
                if (valueOfComboBox.equals("Show all") || valueOfComboBox.equals("by availability"))
                {
                    for (Object o : searchResultList)
                    {
                        if (o.toString().toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
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
                } else if (valueOfComboBox.equals("by room number"))
                {
                    Room room;
                    for (Object o : searchResultList)
                    {
                        room = (Room) o;
                        if (Integer.toString(room.getRoomNumber()).contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];

                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        room = (Room) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = room.getRoomNumber() + "";
                        resultToDisplay[i][1] = room.getType();
                        resultToDisplay[i][2] = room.getCapacity() + "";
                        resultToDisplay[i][3] = room.getPricePerNight() + "";
                    }
                }
            }
            break;
            case "Clients":
            {
                Client client;
                if (valueOfComboBox.equals("Show all"))
                {
                    for (Object o : searchResultList)
                    {
                        if (o.toString().toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];

                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        client = (Client) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = client.getId();
                        resultToDisplay[i][1] = client.getFirstName();
                        resultToDisplay[i][2] = client.getLastName();
                        resultToDisplay[i][3] = client.getCountry();
                    }
                } else if (valueOfComboBox.equals("by client ID"))
                {
                    for (Object o : searchResultList)
                    {
                        client = (Client) o;
                        if (Long.toString(client.getId()).contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        client = (Client) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = client.getId();
                        resultToDisplay[i][1] = client.getFirstName();
                        resultToDisplay[i][2] = client.getLastName();
                        resultToDisplay[i][3] = client.getCountry();
                    }
                } else if (valueOfComboBox.equals("by client name"))
                {
                    String tempName, tempNameBackwards;
                    for (Object o : searchResultList)
                    {
                        client = (Client) o;
                        tempName = client.getFirstName().toLowerCase() + " " + client.getLastName().toLowerCase();
                        tempNameBackwards = client.getLastName().toLowerCase() + " " + client.getFirstName().toLowerCase();
                        if (tempName.contains(substring) || tempNameBackwards.contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }

                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        client = (Client) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = client.getId();
                        resultToDisplay[i][1] = client.getFirstName();
                        resultToDisplay[i][2] = client.getLastName();
                        resultToDisplay[i][3] = client.getCountry();
                    }
                }
            }
            break;
            case "Reservations":
            {
                Reservation reservation;
                if (valueOfComboBox.equals("Show all"))
                {
                    for (Object o : searchResultList)
                    {
                        if (o.toString().toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][3];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        reservation = (Reservation) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = reservation.getID();
                        resultToDisplay[i][1] = reservation.getClientsIDs();
                        resultToDisplay[i][2] = reservation.getRoomsIDs();
                    }

                } else if (valueOfComboBox.equals("by client ID"))
                {
                    for (Object o : searchResultList)
                    {
                        reservation = (Reservation) o;
                        if (reservation.getClientsIDs().toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][3];

                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        reservation = (Reservation) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = reservation.getID();
                        resultToDisplay[i][1] = reservation.getClientsIDs();
                        resultToDisplay[i][2] = reservation.getRoomsIDs();
                    }

                } else if (valueOfComboBox.equals("by room ID"))
                {
                    for (Object o : searchResultList)
                    {
                        reservation = (Reservation) o;
                        if (reservation.getRoomsIDs().toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][3];

                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        reservation = (Reservation) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = reservation.getID();
                        resultToDisplay[i][1] = reservation.getClientsIDs();
                        resultToDisplay[i][2] = reservation.getRoomsIDs();
                    }

                } else if (valueOfComboBox.equals("by reservation ID"))
                {
                    for (Object o : searchResultList)
                    {
                        reservation = (Reservation) o;
                        if (Integer.toString(reservation.getID()).toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][3];

                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        reservation = (Reservation) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = reservation.getID();
                        resultToDisplay[i][1] = reservation.getClientsIDs();
                        resultToDisplay[i][2] = reservation.getRoomsIDs();
                    }
                }
            }
            break;
            case "FacilityReservations":
            {
                FacilityReservation facilityRes;
                if (valueOfComboBox.equals("Show all"))
                {
                    for (Object o : searchResultList)
                    {
                        if (o.toString().toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        facilityRes = (FacilityReservation) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = facilityRes.getID();
                        resultToDisplay[i][1] = facilityRes.getFacilityTitle();
                        resultToDisplay[i][2] = facilityRes.getClientsName();
                        resultToDisplay[i][3] = facilityRes.getClientsID();
                    }
                } else if (valueOfComboBox.equals("by client ID"))
                {
                    for (Object o : searchResultList)
                    {
                        facilityRes = (FacilityReservation) o;
                        if (Long.toString(facilityRes.getClientsID()).toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        facilityRes = (FacilityReservation) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = facilityRes.getID();
                        resultToDisplay[i][1] = facilityRes.getFacilityTitle();
                        resultToDisplay[i][2] = facilityRes.getClientsName();
                        resultToDisplay[i][3] = facilityRes.getClientsID();
                    }
                } else if (valueOfComboBox.equals("by client name"))
                {
                    String clientName, clientNameBackwards;
                    for (Object o : searchResultList)
                    {
                        facilityRes = (FacilityReservation) o;
                        clientName = facilityRes.getClientFirstName() + " " + facilityRes.getClientLastName();
                        clientNameBackwards = facilityRes.getClientLastName() + " " + facilityRes.getClientFirstName();
                        if (clientName.toLowerCase().contains(substring) || clientNameBackwards.toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        facilityRes = (FacilityReservation) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = facilityRes.getID();
                        resultToDisplay[i][1] = facilityRes.getFacilityTitle();
                        resultToDisplay[i][2] = facilityRes.getClientsName();
                        resultToDisplay[i][3] = facilityRes.getClientsID();
                    }
                } else if (valueOfComboBox.equals("by reservation ID"))
                {
                    for (Object o : searchResultList)
                    {
                        facilityRes = (FacilityReservation) o;
                        if (Integer.toString(facilityRes.getID()).toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        facilityRes = (FacilityReservation) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = facilityRes.getID();
                        resultToDisplay[i][1] = facilityRes.getFacilityTitle();
                        resultToDisplay[i][2] = facilityRes.getClientsName();
                        resultToDisplay[i][3] = facilityRes.getClientsID();
                    }
                } else if (valueOfComboBox.equals("by facility title"))
                {
                    for (Object o : searchResultList)
                    {
                        facilityRes = (FacilityReservation) o;
                        if (facilityRes.getFacilityTitle().toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        facilityRes = (FacilityReservation) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = facilityRes.getID();
                        resultToDisplay[i][1] = facilityRes.getFacilityTitle();
                        resultToDisplay[i][2] = facilityRes.getClientsName();
                        resultToDisplay[i][3] = facilityRes.getClientsID();
                    }
                }
            }
            break;
            case "Employees":
            {
                Employee employee;

                if (valueOfComboBox.equals("Show all"))
                {
                    for (Object o : searchResultList)
                    {
                        if (o.toString().toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        employee = (Employee) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = employee.getId();
                        resultToDisplay[i][1] = employee.getFirstName();
                        resultToDisplay[i][2] = employee.getLastName();
                        resultToDisplay[i][3] = employee.getPosition();
                    }
                } else if (valueOfComboBox.equals("by employee ID"))
                {
                    for (Object o : searchResultList)
                    {
                        employee = (Employee) o;
                        if (Long.toString(employee.getId()).toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        employee = (Employee) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = employee.getId();
                        resultToDisplay[i][1] = employee.getFirstName();
                        resultToDisplay[i][2] = employee.getLastName();
                        resultToDisplay[i][3] = employee.getPosition();
                    }
                } else if (valueOfComboBox.equals("by employee name"))
                {
                    String employeeName, employeeNameBackwards;
                    for (Object o : searchResultList)
                    {
                        employee = (Employee) o;
                        employeeName = employee.getFirstName() + " " + employee.getLastName();
                        employeeNameBackwards = employee.getLastName() + " " + employee.getFirstName();
                        if (employeeName.toLowerCase().contains(substring) || employeeNameBackwards.toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        employee = (Employee) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = employee.getId();
                        resultToDisplay[i][1] = employee.getFirstName();
                        resultToDisplay[i][2] = employee.getLastName();
                        resultToDisplay[i][3] = employee.getPosition();
                    }
                } else if (valueOfComboBox.equals("by employee position"))
                {
                    for (Object o : searchResultList)
                    {
                        employee = (Employee) o;
                        if (employee.getPosition().toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][4];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        employee = (Employee) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = employee.getId();
                        resultToDisplay[i][1] = employee.getFirstName();
                        resultToDisplay[i][2] = employee.getLastName();
                        resultToDisplay[i][3] = employee.getPosition();
                    }
                }
            }
            break;
            case "RoomTypes":
            {
                Room roomType;
                if (valueOfComboBox.equals("Show all"))
                {
                    for (Object o : searchResultList)
                    {
                        if (o.toString().toLowerCase().contains(substring))
                        {
                            dynamicSearchResultList.add(o);
                        }
                    }
                    resultToDisplay = new Object[dynamicSearchResultList.size()][3];
                    for (int i = 0; i < dynamicSearchResultList.size(); i++)
                    {
                        roomType = (Room) dynamicSearchResultList.get(i);
                        resultToDisplay[i][0] = roomType.getType();
                        resultToDisplay[i][1] = roomType.getCapacity();
                        resultToDisplay[i][2] = roomType.getPricePerNight();
                    }
                }
            }
            break;
            case "Facilities":
            {
                Facility facilityList;
                for (Object o : searchResultList)
                {
                    if (o.toString().toLowerCase().contains(substring))
                    {
                        dynamicSearchResultList.add(o);
                    }
                }
                resultToDisplay = new Object[dynamicSearchResultList.size()][3];
                for (int i = 0; i < dynamicSearchResultList.size(); i++)
                {
                    facilityList = (Facility) dynamicSearchResultList.get(i);
                    resultToDisplay[i][0] = facilityList.getTitle();
                    resultToDisplay[i][1] = facilityList.getPrice();
                    resultToDisplay[i][2] = facilityList.getDescription();
                }
            }
            break;
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

    public void addClient(String firstName, String lastName, String personalID, String address, String country, String email, String travelAgency, String password, String telephoneNumber)
    {
        dbFacade.startBusinessProcess("Clients");
        dbFacade.addNewClient(new Client((long) dbFacade.getNextDataSeqNumber(), firstName, lastName, address, country, email, travelAgency, password, telephoneNumber, personalID, 1, 0));
    }

    public boolean saveAddedClients()
    {
        return dbFacade.commitBusinessProcess();
    }

    public ArrayList<String> getInformationAboutSelectedValueInTable(String identifier)
    {
        ArrayList<String> result = new ArrayList();
        switch (searchResultType)
        {
            case "Rooms":
            {
                Room temp = dbFacade.getRoomByRoomNumber(Integer.parseInt(identifier));
                selectedObjectForEditing = temp;
                result.add(Integer.toString(temp.getRoomNumber()));
                result.add(temp.getType());
                result.add(Integer.toString(temp.getCapacity()));
                result.add(Double.toString(temp.getPricePerNight()));
                return result;
            }

            case "Employees":
            {
                Employee temp = dbFacade.getEmployeeByID(Long.parseLong(identifier));
                selectedObjectForEditing = temp;
                result.add(Long.toString(temp.getId()));
                result.add(temp.getFirstName());
                result.add(temp.getLastName());
                result.add(temp.getAddress());
                result.add(temp.getCountry());
                result.add(temp.getEmail());
                result.add(temp.getPosition());
                result.add(temp.getPassword());
                result.add(temp.getTelephoneNumber());
                result.add(temp.getPersonalID());
                result.add(Double.toString(temp.getSalary()));
                return result;
            }

            case "Clients":
            {
                Client temp = dbFacade.getClientByID(Long.parseLong(identifier));
                selectedObjectForEditing = temp;
                result.add(Long.toString(temp.getId()));
                result.add(temp.getFirstName());
                result.add(temp.getLastName());
                result.add(temp.getAddress());
                result.add(temp.getCountry());
                result.add(temp.getEmail());
                result.add(temp.getTravelAgency());
                result.add(temp.getPassword());
                result.add(temp.getTelephoneNumber());
                result.add(temp.getPersonalID());
                result.add(Double.toString(temp.getIndividualExpenses()));
                return result;
            }

            case "Facilities":
            {
                Facility temp = dbFacade.getFacilityByName(identifier);
                selectedObjectForEditing = temp;
                result.add(temp.getTitle());
                result.add(Double.toString(temp.getPrice()));
                result.add(temp.getDescription());
                return result;
            }
            case "RoomTypes":
            {
                Room temp = dbFacade.getRoomTypeByType(identifier);
                selectedObjectForEditing = temp;
                result.add(temp.getType());
                result.add(Integer.toString(temp.getCapacity()));
                result.add(Double.toString(temp.getPricePerNight()));
                return result;
            }

        }
        return result;
    }

    // it has to be modified after the methods from unit of work and datamapper will be adapted to support deletion of primary keys, not objects
    public boolean delete(String pk)
    {
        dbFacade.startBusinessProcess(searchResultType);
        boolean status = true;
        switch (searchResultType)
        {
            case "Reservations":
            {
                Reservation reservation = dbFacade.getReservationByID(Integer.parseInt(pk));
                status = status && dbFacade.deleteReservation(reservation);
            }
            break;
            case "Clients":
            {
                Client client = dbFacade.getClientByID(Long.parseLong(pk));
                status = status && dbFacade.deleteClient(client);
            }
            break;
            case "Rooms":
            {
                Room room = dbFacade.getRoomByRoomNumber(Integer.parseInt(pk));
                status = status && dbFacade.deleteRoom(room);
            }
            break;
            case "Employees":
            {
                Employee emp = dbFacade.getEmployeeByID(Long.parseLong(pk));
                status = status && dbFacade.deleteEmployee(emp);
            }
            break;
            case "Facilities":
            {
                Facility fac = dbFacade.getFacilityByName(pk);
                status = status && dbFacade.deleteFacility(fac);
            }
            break;
            case "FacilityReservations":
            {
                FacilityReservation facR = dbFacade.getFacilityReservationByID(Integer.parseInt(pk));
                status = status && dbFacade.deleteFacilityResrvation(facR);
            }
            break;
            case "RoomTypes":
            {
                Room room = dbFacade.getRoomTypeByType(pk);
                status = status && dbFacade.deleteRoomType(room);
            }
            break;
            default:
            {
                return false;
            }
        }
        status = status && dbFacade.commitBusinessProcess();
        return status;
    }

    // needs to be modified for reservations & facility reservations
    public boolean update(String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, String p9, String p10, String p11)
    {
        dbFacade.startBusinessProcess(searchResultType);
        boolean status = true;
        switch (searchResultType)
        {
//            case "Reservations":
//            {
//                Reservation reservation = (Reservation) selectedObjectForEditing;
//                
//                status = status && dbFacade.updateReservation(reservation);
//            }
//            break;
            case "Clients":
            {
                Client client = (Client) selectedObjectForEditing;
                client.setFirstName(p2);
                client.setLastName(p3);
                client.setAddress(p4);
                client.setCountry(p5);
                client.setEmail(p6);
                client.setTravelAgency(p7);
                client.setPersonalID(p8);
                client.setTelephoneNumber(p9);
                client.setPassword(p10);
                status = status && dbFacade.updateClient(client);
            }
            break;
            case "Rooms":
            {
                Room room = (Room) selectedObjectForEditing;
                room.setRoomNumber(Integer.parseInt(p1));
                room.setType(p2);
                room.setCapacity(Integer.parseInt(p3));
                room.setPricePerNight(Double.parseDouble(p4));
                status = status && dbFacade.updateRoom(room);
            }
            break;
            case "Employees":
            {
                Employee emp = (Employee) selectedObjectForEditing;
                emp.setFirstName(p2);
                emp.setLastName(p3);
                emp.setAddress(p4);
                emp.setCountry(p5);
                emp.setEmail(p6);
                emp.setPosition(p7);
                emp.setTelephoneNumber(p8);
                emp.setPersonalID(p9);
                emp.setSalary(Double.parseDouble(p10));
                emp.setPassword(p11);
                status = status && dbFacade.updateEmployee(emp);
            }
            break;
            case "Facilities":
            {
                Facility fac = (Facility) selectedObjectForEditing;
                fac.setTitle(p1);
                fac.setPrice(Double.parseDouble(p2));
                fac.setDescription(p3);
                status = status && dbFacade.updateFacility(fac);
            }
            break;
//            case "FacilityReservations":
//            {
//                FacilityReservation facR = (FacilityReservation) selectedObjectForEditing;
//                
//                status = status && dbFacade.updateFacilityReservation(facR);
//            }
//            break;
            case "RoomTypes":
            {
                Room room = (Room) selectedObjectForEditing;
                room.setType(p1);
                room.setCapacity(Integer.parseInt(p2));
                room.setPricePerNight(Double.parseDouble(p3));
                status = status && dbFacade.updateRoomType(room);
            }
            break;

            default:
            {
                return false;
            }
        }
        status = status && dbFacade.commitBusinessProcess();
        return status;
    }
}
