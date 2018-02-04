
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        Connection connec = DriverManager.getConnection("jdbc:sqlite:Kata5.db");	
        Statement st = connec.createStatement();	
        String	query = "SELECT * FROM PEOPLE;";	
        ResultSet rs = st.executeQuery(query);	
        System.out.println("ID | Nombre | Apellido | Departamento ");
        while(rs.next()){	
            Integer id	= rs.getInt(1);	
            String name	= rs.getString(2);	
            String apellido = rs.getString(3);	
            String departamento	= rs.getString(4);	
            System.out.println(id + "  | "+ name + " | " + apellido+ " | " + departamento);
	}	
    }   
}
