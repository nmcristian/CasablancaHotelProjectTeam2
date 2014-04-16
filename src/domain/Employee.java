package domain;

/**
 *
 * @author Cristian
 */
public class Employee
{

    private int versionNumber;
    private long id;
    private String firstName, lastName, position, password;

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

    public Employee(long id, String firstName, String lastName, String position, String password)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.password = password;
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

    
    @Override
    public String toString()
    {
        return id + ",  " + firstName + " " + lastName + ",  " + position;
    }
}
