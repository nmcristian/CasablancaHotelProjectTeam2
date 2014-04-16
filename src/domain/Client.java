package domain;

/**
 *
 * @author Cristian
 */
public class Client
{


    private String firstName, lastName, address, country, email, travelAgency, password, telephoneNumber, personalID;
    private int versionNumber;
    private long id;
    private double individualExpenses;

    public Client(long id, String firstName, String lastName,  String country)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }
    
    public Client(long id, String firstName, String lastName, String address, String country, String email, String travelAgency, String password, String telephoneNumber, String personalID, int versionNumber, double individualExpenses)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        this.email = email;
        this.travelAgency = travelAgency;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
        this.personalID = personalID;
        this.versionNumber = versionNumber;
        this.id = id;
        this.individualExpenses = individualExpenses;
    }

    public String getPersonalID()
    {
        return personalID;
    }

    public void setPersonalID(String personalID)
    {
        this.personalID = personalID;
    }

    public Client(long id, String firstName, String lastName, String personalID, String address, String country, String email, String travelAgency, String password, String telephoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        this.email = email;
        this.travelAgency = travelAgency;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
        this.id = id;
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

    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @return the travelAgency
     */
    public String getTravelAgency()
    {
        return travelAgency;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @return the telephoneNumber
     */
    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    /**
     * @return the versionNumber
     */
    public int getVersionNumber()
    {
        return versionNumber;
    }

    public double getIndividualExpenses()
    {
        return individualExpenses;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }

    public void setVersionNumber(int versionNumber)
    {
        this.versionNumber = versionNumber;
    }     
}
