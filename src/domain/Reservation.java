package domain;

import java.util.ArrayList;

/**
 *
 * @author Cristian
 */
public class Reservation
{

    private int id, versionNumber;
    private double alreadyPaid, totalDue;
    private ArrayList<Client> clients;
    private ArrayList<Room> rooms;
    private boolean isNewReservation;

    public Reservation(int id, double totalDue, double alreadyPaid, ArrayList<Client> clients, ArrayList<Room> rooms, int versionNumber)
    {
        this.id = id;
        this.totalDue = totalDue;
        this.alreadyPaid = alreadyPaid;
        this.clients = clients;
        this.rooms = rooms;
        this.isNewReservation = false;
        this.versionNumber = versionNumber;
    }

    public Reservation(int id)
    {
        this.id = id;
        this.totalDue = 0;
        this.alreadyPaid = 0;
        this.clients = new ArrayList();
        this.rooms = new ArrayList();
        this.isNewReservation = true;
    }

    public int getID()
    {
        return id;
    }

    public double getAlreadyPaid()
    {
        return alreadyPaid;
    }

    public double getTotalDue()
    {
        return totalDue;
    }

    public String getClientsIDs()
    {
        String result = "";
        for (Client x : clients)
        {
            result += x.getId() + ", ";
        }
        if (clients.isEmpty())
        {
            return result;
        }
        return result.substring(0, result.length() - 2);
    }

    public String getRoomsIDs()
    {
        String result = "";
        for (Room x : rooms)
        {
            result += x.getRoomNumber() + ", ";
        }
        if (rooms.isEmpty())
        {
            return result;
        }
        return result.substring(0, result.length() - 2);
    }
    
    public int getTotalCapacity()
    {
        int result = 0;
        for (Room x : rooms)
        {
            result += x.getCapacity();
        }
        return result;
    }

    public void calculatePricePerWholeStay()
    {
        totalDue = 0;
        for (Room x : rooms)
        {
            totalDue += x.getPricePerWholeStay();
        }
    }

    public void confirmPayment(double amount)
    {
        alreadyPaid += amount;
    }
    
    public boolean addClient(Client client)
    {
        if (client == null)
        {
            return false;
        } else
        {
            clients.add(client);
            return true;
        }
    }

    public void addRoom(Room room)
    {
        rooms.add(room);
    }

    public void removeRoom(int index)
    {
        rooms.remove(index);
    }

    public void removeClient(int index)
    {
        clients.remove(index);
    }

    public ArrayList<Client> getClients()
    {
        return clients;
    }

    public ArrayList<Room> getRooms()
    {
        return rooms;
    }

    public boolean isNewReservation()
    {
        return isNewReservation;
    }

    public int getVersionNumber()
    {
        return versionNumber;
    }
    
    @Override
    public String toString()
    {
        return id + " " + getClientsIDs() + " " + getRoomsIDs();
    }
}
