package model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class Databaseimpl{
    Connection con;

    private String insertSql = "INSERT INTO fetchDetails VALUES(?,?,?)";

    
    public Databaseimpl() throws ClassNotFoundException, IOException, SQLException {
        InputStream inputStream = Databaseimpl.class.getResourceAsStream("database.properties");
        Properties p = new Properties();
        
            p.load(inputStream);
        
        String driver = p.getProperty("datasource.driverclassname");
        String jdbcUrl=p.getProperty("datasource.url");

        Class.forName(driver);
        con=DriverManager.getConnection(jdbcUrl);

    }
    public boolean saveDetails(GetDetails fetch){
        try (PreparedStatement pstmt = con.prepareStatement(insertSql)) {
            pstmt.setString(1, fetch.getName());
            pstmt.setString(2, fetch.getCity());
            pstmt.setInt(3, fetch.getDistance());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
       

    }
    

}