package domain;

/**
 *
 * @author Cristian
 */
public class Employee
{

    private String firstName, lastName, address, country, email, position, password, telephoneNumber, personalID;
    private int versionNumber;
    private long id;
    private double salary;

    public Employee()
    {

    }

    public Employee(long id, String firstName, String lastName, String position)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;        
    }

    public Employee(long id, String firstName, String lastName, String address, String country, String email, String position, String password, String telephoneNumber, String personalID, int versionNumber, double salary)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        this.email = email;
        this.position = position;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
        this.personalID = personalID;
        this.versionNumber = versionNumber;
        this.salary = salary;
    }
    
    public long getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPosition()
    {
        return position;
    }

    public int getVersionNumber()
    {
        return versionNumber;
    }

    public String getPassword()
    {
        return password;
    }

    public String getAddress()
    {
        return address;
    }

    public String getCountry()
    {
        return country;
    }

    public String getEmail()
    {
        return email;
    }

    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    public String getPersonalID()
    {
        return personalID;
    }

    public double getSalary()
    {
        return salary;
    }
    
    @Override
    public String toString()
    {
        return id + ",  " + firstName + " " + lastName + ",  " + position;
    }
}
