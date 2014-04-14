package domain;

/**
 *
 * @author Cristian
 */
public class Client
{

    private String firstName, lastName, address, country, email, travelAgency, password;
    private int phone, versionNumber;
    private long id;
    private double individualExpenses;

    public Client(long id, String firstName, String lastName, String country)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public long getId()
    {
        return id;
    }

    public String getCountry()
    {
        return country;
    }

    @Override
    public String toString()
    {
        return id + " " + firstName + " " + lastName + " " + country;
    }
}
