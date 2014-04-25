
import datasource.DBConnectorTest;
import domain.Controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Fixture
{

    public static void setUp(Connection con)
    {
        try
        {

            Statement st = con.createStatement();
            // start transaction
            con.setAutoCommit(false);

            st.addBatch("delete from employees");
            st.addBatch("delete from FACILITIES_RESERVATIONS");
            st.addBatch("delete from facilities");
            st.addBatch("delete from clients_reservations");
            st.addBatch("delete from clients");
            st.addBatch("delete from room_reservations");
            st.addBatch("delete from rooms");
            st.addBatch("delete from room_types");
            st.addBatch("delete from reservations");
            
            String insert = "insert into facilities values ";
            st.addBatch(insert + "('Swimming', NULL, 40, 1)");
            
            insert = "insert into clients values ";
            st.addBatch(insert + "(1000, 'Smaranda', 'Dungeanu', null, 'Vejlebrovej 62', 'Denmark', NULL, '50223347', 'smaranda.dungeanu@gmail.com', 'casablanca95', 1)");
            st.addBatch(insert + "(1001, 'Marek', 'Furak', null, 'Albertslund Dorm 55', 'Denmark', 'Furak Holidays', '41547852', 'marek.furak@gmail.com', 'casablanca93', 1)");
            
            insert = "insert into employees values ";
            st.addBatch(insert + "(1002, 'Raul', 'Stelescu', 'Receptionist', 150, '19403BLABLABLA', 'Casablanca Rue, nb 101', 'Romania', '+4550234884', 'stelescuraul@gmail.com', 'casablanca100', 1)");
            
            insert = "insert into FACILITIES_RESERVATIONS values ";
            st.addBatch(insert + "(1004, 1000, 'Swimming', to_timestamp('01-04-2014 14:00:00', 'dd-mm-yyyy hh24:mi:ss'), " +
"                    to_timestamp('01-04-2014 15:00:00', 'dd-mm-yyyy hh24:mi:ss'), 1)");
           
            insert = "insert into room_types values ";
            st.addBatch(insert + "('Single room', 60, 1, 1)");
            
            insert = "insert into rooms values ";
            st.addBatch(insert + "(4, 'Single room', 1)");
            
            insert = "insert into reservations values ";
            st.addBatch(insert + "(1009, 180, 0, 1)");
            
            insert = "insert into room_reservations values ";
            st.addBatch(insert + "(1009, 4, TO_DATE('29-APR-2014','DD-MON-YYYY'), TO_DATE('02-MAI-2014','DD-MON-YYYY'), 1)");
            
            insert = "insert into clients_reservations values ";
            st.addBatch(insert + "(1009, 1000, 1)");

            //First new Order we insert is expected to have id = 3000
            st.addBatch("drop sequence newDataSeq");
            st.addBatch("create sequence newDataSeq start with 1000");

            int[] opcounts = st.executeBatch();

            // end transaction
            con.commit();
        } catch (Exception e)
        {
            try
            {
                con.rollback();
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            System.out.println("Fail in Fixture.setup()");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        setUp(DBConnectorTest.getConnection());
    }
}
