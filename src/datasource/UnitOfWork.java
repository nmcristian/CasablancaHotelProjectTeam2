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
        // if not already registered in any list
        if (!newData.contains(o) && !dirtyData.contains(o) && !filthyData.contains(o))
        {
            newData.add(o);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean delete(Object o, Connection connection)
    {
        // if not already registered in any list
        if (!newData.contains(o) && !dirtyData.contains(o) && !filthyData.contains(o))
        {
            filthyData.add(o);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean update(Object o, Connection connection)
    {
        // if not already registered in any list
        if (!newData.contains(o) && !dirtyData.contains(o) && !filthyData.contains(o))
        {
            dirtyData.add(o);
            return true;
        } else
        {
            return false;
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
                    if (!filthyData.isEmpty())
                    {
                        status = status && dataMapper.deleteReservations(filthyData, connection);
                    }
                    break;
                }
                case "Clients":
                {
                    status = status && dataMapper.insertClients(newData, connection);
                    if (!dirtyData.isEmpty())
                    {
                        status = status && dataMapper.updateClients(dirtyData, connection);
                    }
                    if (!filthyData.isEmpty())
                    {
                        status = status && dataMapper.deleteClients(filthyData, connection);
                    }
                    break;
                }
                case "Employees":
                {
                    //                 status = status && dataMapper.insertEmployees(newData, connection);
                    if (!dirtyData.isEmpty())
                    {
                        status = status && dataMapper.updateEmployees(dirtyData, connection);
                    }
                    if (!filthyData.isEmpty())
                    {
                        status = status && dataMapper.deleteEmployees(filthyData, connection);
                    }
                    break;
                }
                case "Rooms":
                {
                    //                 status = status && dataMapper.insertEmployees(newData, connection);
                    if (!dirtyData.isEmpty())
                    {
                        status = status && dataMapper.updateRooms(dirtyData, connection);
                    }
                    if (!filthyData.isEmpty())
                    {
                        status = status && dataMapper.deleteRooms(filthyData, connection);
                    }
                    break;
                }
                case "RoomTypes":
                {
                    //                 status = status && dataMapper.insertEmployees(newData, connection);
                    if (!dirtyData.isEmpty())
                    {
                        status = status && dataMapper.updateRoomTypes(dirtyData, connection);
                    }
                    if (!filthyData.isEmpty())
                    {
                        status = status && dataMapper.deleteRoomTypes(filthyData, connection);
                    }
                    break;
                }
                case "Facilities":
                {
                    //                 status = status && dataMapper.insertEmployees(newData, connection);
                    if (!dirtyData.isEmpty())
                    {
                        status = status && dataMapper.updateFacilities(dirtyData, connection);
                    }
                    if (!filthyData.isEmpty())
                    {
                        status = status && dataMapper.deleteFacilities(filthyData, connection);
                    }
                    break;
                }
                case "FacilityReservations":
                {
//                    status = status && dataMapper.insertEmployees(newData, connection);
//                    status = status && dataMapper.update(dirtyData, connection);
                    if (!filthyData.isEmpty())
                    {
                        status = status && dataMapper.deleteFacilityReservations(filthyData, connection);
                    }
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
