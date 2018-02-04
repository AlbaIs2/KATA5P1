
package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
        String fileName = "C:\\Users\\ALBA\\Documents\\NetBeansProjects\\Kata5P1\\emails.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        
       	Class.forName("org.sqlite.JDBC");
        Connection connec = DriverManager.getConnection("jdbc:sqlite:Kata5.db");	
        Statement st = connec.createStatement();
        
        String mail;
        String query;
        
        while((mail = reader.readLine()) != null){
            if(mail.contains("@")){
                query = "INSERT INTO MAIL (Mail) VALUES ('"+ mail+"');";
                st.execute(query);
            }
        }    	  	
    }   
}
