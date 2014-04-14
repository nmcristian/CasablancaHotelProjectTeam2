package domain;

import java.util.Calendar;

/**
 *
 * @author Cristian
 */
public class FacilityReservation
{

    private Calendar startingDate, endingDate;
    private int id, versionNumber;
    private Client client;
    private Facility facility;

    public FacilityReservation(int id, Client client, Facility facility, Calendar startingDate, Calendar endingDate)
    {
        this.id = id;
        this.client = client;
        this.facility = facility;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public int getID()
    {
        return id;
    }
    
    public double getPrice()
    {
        return facility.getPrice() * (endingDate.getTimeInMillis() - startingDate.getTimeInMillis()) / 3600000;
    }

    public String getFacilityTitle()
    {
        return facility.getTitle();
    }

    public String getStartingDate()
    {
        String result = startingDate.getTime().toString();
        for (int i = result.length() - 1; i >= 0; i--)
        {
            if (result.charAt(i) == ':')
            {
                return result.substring(0, i);
            }
        }
        return result;
    }

    public String getEndingDate()
    {
        String result = endingDate.getTime().toString();
        for (int i = result.length() - 1; i >= 0; i--)
        {
            if (result.charAt(i) == ':')
            {
                return result.substring(0, i);
            }
        }
        return result;
    }
    
    public String getClientFirstName()
    {
        return client.getFirstName();
    }
    
    public String getClientLastName()
    {
        return client.getLastName();
    }

    public String getClientsName()
    {
        return client.getFirstName() + " " + client.getLastName();
    }
    
    public long getClientsID()
    {
        return client.getId();
    }
    
    @Override
    public String toString()
    {
        return id + " "+ facility.getTitle() + " " + client.getFirstName() + " " + client.getLastName() + " " + client.getId();
    }
}
