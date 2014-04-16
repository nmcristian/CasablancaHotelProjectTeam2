package domain;

/**
 *
 * @author Cristian
 */
public class Facility
{

    private int versionNumber;
    private double price;
    private String title, description;

    public Facility(String title, double price, String description)
    {
        this.title = title;
        this.price = price;
        if (description == null)
        {
            this.description = "no description";
        } else
        {
            this.description = description;
        }
    }

    public double getPrice()
    {
        return price;
    }

    public String getTitle()
    {
        return title;
    }
    
    public String getDescription()
    {
        return description;
    }

    public int getVersionNumber()
    {
        return versionNumber;
    }
    

    @Override
    public String toString()
    {
        return title + ",  $" + price + "/h,  " + description;
    }

}
