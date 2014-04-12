package datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cristian
 */
public class UnitOfWork
{

    private DataMapper dataMapper;
    private ArrayList newData;
    private ArrayList dirtyData;
    private ArrayList filthyData;
    private String resultType;

    public UnitOfWork(String resultType, DataMapper dataMapper)
    {
        this.resultType = resultType;
        this.dataMapper = dataMapper;
        this.newData = new ArrayList();
        this.dirtyData = new ArrayList();
        this.filthyData = new ArrayList();
    }

    public boolean add(Object o, Connection connection)
    {
        switch (resultType)
        {
            case "Reservations":
            {
                // if not already registered in any list
                if (!newData.contains(o) && !dirtyData.contains(0) && !filthyData.contains(o))
                {
                    newData.add(o);
                    return true;
                } else
                {
                    return false;
                }
            }

            default:
            {
                return false;
            }
        }
    }

    public boolean commit(Connection connection)
    {
        boolean status = true;  // will be set false if any part of transaction fails    
        try
        {
            connection.setAutoCommit(false);

            switch (resultType)
            {
                case "Reservations":
                {
                    status = status && dataMapper.insertReservations(newData, connection);
//                    status = status && dataMapper.updateReservations(dirtyData, connection);
//                    status = status && dataMapper.deleteReservations(filthyData, connection);
                    break;
                }
                default:
                {
                    //do nothing;
                }

            }

            if (!status)
            {
                throw new Exception("Process Order Business Transaction aborted");
            }
            connection.commit();
            //=== system transaction - ends with success
        } catch (Exception e)
        {
            //=== system transaction - ends with roll back
            try
            {
                connection.rollback();
            } catch (SQLException e1)
            {
                System.out.println(e1.toString());
            }
            status = false;
        }
        return status;
    }
}
