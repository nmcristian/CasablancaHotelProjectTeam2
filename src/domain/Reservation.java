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

    public Reservation(int id, double alreadyPaid, ArrayList<Client> clients, ArrayList<Room> rooms)
    {   //has to be changed, to save the totalDue also
        this.id = id;
        this.alreadyPaid = alreadyPaid;
        this.clients = clients;
        this.rooms = rooms;
        calculatePricePerWholeStay();
    }

    public Reservation(int id)
    {
        this.id = id;
        this.alreadyPaid = 0;
        this.clients = new ArrayList();
        this.rooms = new ArrayList();
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
        return result.substring(0, result.length() - 2);
    }

    public String getRoomsIDs()
    {
        String result = "";
            for (Room x : rooms)
            {
                result += x.getRoomNumber() + ", " ;
            }
        return result.substring(0, result.length() );
    }

    public void calculatePricePerWholeStay()
    {
        totalDue = 0;
        for (Room x : rooms)
        {
            totalDue += x.getPricePerWholeStay();
        }
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
        calculatePricePerWholeStay();
    }

    public void removeRoom(int index)
    {
        rooms.remove(index);
        calculatePricePerWholeStay();
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

    @Override
    public String toString()
    {
        return id + " " + getClientsIDs() + " " + getRoomsIDs();
    }
}
