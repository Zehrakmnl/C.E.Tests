/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mssqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class MsSqlConnection {


    public static void main(String[] args)
    {
        Connection connect=null;
        Statement statement=null;
        String Query="select * from [tablename]";

        String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DATABASE_URL = "jdbc:jtds:sqlserver://youraddress;database=yourdbname;integratedSecurity=true;";
        String USERNAME = "sa"; 
        String PASSWORD = "*****";
        try
        {
            //Driveri ekliyoruz.
            Class.forName(JDBC_DRIVER);
            connect=DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
          
            statement=connect.createStatement();
            ResultSet result=statement.executeQuery(Query);
            
            ResultSetMetaData metaData = result.getMetaData();
            int number = metaData.getColumnCount();
            for(int i=1; i<=number; i++) 
            System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
            System.out.println();
            while(result.next()) {
            for(int i=1; i<=number; i++) 
            System.out.printf("%-8s\t", result.getObject(i));
       //   int id = result.getInt("ID"); //if you want to fetch specitfic info use this method.
            System.out.println();
                 
            }
        }
 
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        finally
        {
            try
            {
            	connect.close();
                statement.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
