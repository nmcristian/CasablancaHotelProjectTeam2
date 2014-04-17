package domain;

import java.util.Date;

/**
 *
 * @author Cristian
 */
public class Room
{

    private int roomNumber, capacity, versionNumber;
    private String type;
    private double pricePerNight;
    // next variables are to be used when the room is added into the arraylist of rooms for a reservation
    // so the pricePerNight = RoomType's pricePerNight * (endingDate - startingDate)
    private double pricePerWholeStay;
    private Date startingDate, endingDate;

    public Room(String type, int capacity, double pricePerNight)
    {
        this.type = type;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
    }
    
    public Room(int roomNumber, String type, int capacity, double pricePerNight)
    {
        this.roomNumber = roomNumber;
        this.type = type;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
    }
    
    public Room(int roomNumber, String type, int capacity, double pricePerNight, Date startingDate, Date endingDate)
    {
        this.roomNumber = roomNumber;
        this.type = type;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        calculatePricePerWholeStay();
    }

    public void setStartingDate(Date startingDate)
    {
        this.startingDate = startingDate;
    }

    public void setEndingDate(Date endingDate)
    {
        this.endingDate = endingDate;
    }

    public void setRoomNumber(int roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setPricePerNight(double pricePerNight)
    {
        this.pricePerNight = pricePerNight;
    }

    public int getVersionNumber()
    {
        return versionNumber;
    }

    public Date getStartingDate()
    {
        return startingDate;
    }

    public Date getEndingDate()
    {
        return endingDate;
    }

    public int getRoomNumber()
    {
        return roomNumber;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public String getType()
    {
        return type;
    }

    public double getPricePerNight()
    {
        return pricePerNight;
    }
    
    public double getPricePerWholeStay()
    {
        return pricePerWholeStay;
    }
    
    public void calculatePricePerWholeStay()
    {
        pricePerWholeStay = (endingDate.getTime() - startingDate.getTime())/ 86400000 * pricePerNight;
    }

    @Override
    public String toString()
    {
        return roomNumber + " " + type.toLowerCase() + " " + capacity + " " + pricePerNight;
    }
}
