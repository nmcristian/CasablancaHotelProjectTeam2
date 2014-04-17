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

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }

    public void setPersonalID(String personalID)
    {
        this.personalID = personalID;
    }

    public void setSalary(double salary)
    {
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
