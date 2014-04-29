/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import datasource.DBConnector;
import datasource.DBConnectorTest;
import datasource.DataMapper;
import domain.Client;
import domain.Controller;
import domain.Employee;
import domain.Facility;
import domain.FacilityReservation;
import domain.Reservation;
import domain.Room;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import oracle.sql.TIMESTAMP;

/**
 *
 * @author user
 */
public class DataMapperTest
{

    Connection con;
    DataMapper dm;

    public DataMapperTest()
    {
        dm = new DataMapper();
        con = DBConnectorTest.getConnection();
    }

    @Before
    public void setUp()
    {
        Fixture.setUp(DBConnectorTest.getConnection());
    }

    @Test
    public void testGetRoomByRoomNumber()
    {
        int expResult = 4;
        Room room;
        room = dm.getRoomByRoomNumber(4, con);
        assertEquals(expResult, room.getRoomNumber());
    }

    @Test
    public void testGetAllRooms()
    {
        ArrayList<Integer> expResult = new ArrayList();
        expResult.add(4);
        ArrayList<Room> roomResult = dm.getAllRooms(con);
        ArrayList<Integer> result = new ArrayList();
        for (Room room : roomResult)
        {
            result.add(room.getRoomNumber());
        }
        assertEquals(expResult, result);
    }

    @Test
    public void testGetClientByClientId()
    {
        long expResult = 1000;
        Client client;
        client = dm.getClientByID(1000, con);
        assertEquals(expResult, client.getId());
    }

    @Test
    public void testGetAllClients()
    {
        ArrayList<Long> expResult = new ArrayList();
        expResult.add((long) 1000);
        expResult.add((long) 1001);
        ArrayList<Client> clientResult = dm.getAllClients(con);
        ArrayList<Long> result = new ArrayList();
        for (Client client : clientResult)
        {
            result.add((client.getId()));
        }
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertClients()
    {
        ArrayList<Client> clientsToAdd = new ArrayList();
        Client client = new Client((long) 500, "Mama", "Tata", "Vejlebrovej", "Danmark", "fam@gmail.com", "none", "blabla", "767", "7867867", 1, 0);
        clientsToAdd.add(client);
        //Test return value from method
        boolean expResult1 = true;
        boolean result1 = dm.insertClients(clientsToAdd, con);
        assertEquals(expResult1, result1);
        //Test that object was actually inserted into the list
        ArrayList<Long> expResult2 = new ArrayList();
        ArrayList<Long> result2 = new ArrayList();
        for (Client client1 : clientsToAdd)
        {
            expResult2.add(client1.getId());
        }
        for (long clientId : expResult2)
        {
            result2.add(dm.getClientByID(clientId, con).getId());
        }
        assertEquals(expResult2, result2);
    }

    @Test
    public void testGetEmployeeById()
    {
        long expResult = 1002;
        Employee emp;
        emp = dm.getEmployeeByID(expResult, con);
        assertEquals(expResult, emp.getId());
    }

    @Test
    public void testGetAllEmployees()
    {
        ArrayList<Long> expResult = new ArrayList();
        expResult.add((long) 1002);
        ArrayList<Employee> empResult = dm.getAllEmployees(con);
        ArrayList<Long> result = new ArrayList();
        for (Employee emp : empResult)
        {
            result.add((emp.getId()));
        }
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteEmployees()
    {
        ArrayList<Employee> employeesToDelete = new ArrayList();
        Employee emp1 = new Employee((long) 1002, "Raul", "Stelescu", "Receptionist");
        employeesToDelete.add(emp1);
        //Test return value from method
        boolean expResult1 = true;
        boolean result1 = dm.deleteEmployees(employeesToDelete, con);
        assertEquals(expResult1, result1);
        //Test if the clients were actually deleted
        for (Employee emp : employeesToDelete)
        {
            assertEquals(null, dm.getEmployeeByID(emp.getId(), con));
        }
    }

    @Test
    public void testGetFacilityByName()
    {
        String expResult = "Swimming";
        Facility fac;
        fac = dm.getFacilityByName(expResult, con);
        assertEquals(expResult, fac.getTitle());
    }

    @Test
    public void testGetAllFacilities()
    {
        ArrayList<String> expResult = new ArrayList();
        expResult.add("Swimming");
        ArrayList<Facility> facResult = dm.getAllFacilities(con);
        ArrayList<String> result = new ArrayList();
        for (Facility fac : facResult)
        {
            result.add((fac.getTitle()));
        }
        assertEquals(expResult, result);
    }

    @Test
    public void testGetReservationById()
    {
        int expResult = 1009;
        Reservation res;
        res = dm.getReservationByID(expResult, con);
        assertEquals(expResult, res.getID());
    }

    @Test
    public void testGetAllReservations()
    {
        ArrayList<Integer> expResult = new ArrayList();
        expResult.add(1009);
        ArrayList<Reservation> resResult = dm.getAllReservations(con);
        ArrayList<Integer> result = new ArrayList();
        for (Reservation res : resResult)
        {
            result.add((res.getID()));
        }
        assertEquals(expResult, result);
    } 
          

    @After
    public void tearDown()
    {
    }
}
