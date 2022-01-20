package home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Hyperlink;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JavaPgSql {
    static String url = "jdbc:postgresql://localhost:5433/CurioCity";
    static String user = "postgres";
    static String PGpassword = "Percy394/*";
    public static void writeToDatabase(String AdhaarNo,String Name,String contact, String dob, String password){
        String url = "jdbc:postgresql://localhost:5433/CurioCity";
        String user = "postgres";
        String PGpassword = "Percy394/*";

        String AN = AdhaarNo;
        String userName = Name;
        String usercontact = contact;
        String userDOB=dob;
        String userpassword = password;

        String query = "INSERT INTO details(AN, userName, userContact, userDOB, userPassword) VALUES(?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url,user,PGpassword);
            PreparedStatement pst = con.prepareStatement(query)){
            pst.setString(1,AN);
            pst.setString(2,userName);
            pst.setString(3,usercontact);
            pst.setString(4,userDOB);
            pst.setString(5,userpassword);
            pst.executeUpdate();
            System.out.println("Successfully created.");
        }catch (SQLException ex){
            Logger lgr = Logger.getLogger(JavaPgSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(),ex);
        }
    }

    public static int readLoginDatabase(String AdhaarNo, String password) {
        String AN = AdhaarNo;
        String userpassword = password;
        int flag=0;
        String query = "SELECT AN,userPassword FROM details";
        try (Connection conn = DriverManager.getConnection(url,user,PGpassword);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {

                if (AN.equals(rs.getString(1)) && userpassword.equals(rs.getString(2))) {
                    {
                        flag++;
                        break;
                    }
                } else
                    continue;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return flag;
    }

    public static Connection fetchConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url,user,PGpassword);
        return con;
    }

    public static ObservableList<PrtTable> readPrt() throws SQLException {
        Connection con=fetchConnection();
        ObservableList<PrtTable> list= FXCollections.observableArrayList();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM PrT");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String AN = rs.getString(1);
                String Name = rs.getString(2);
                String Contact_no= rs.getString(3);
                String address=rs.getString(4);
                String sbNo=rs.getString(5);
                String skills=rs.getString(6);
                PrtTable row = new PrtTable(AN,Name,Contact_no,address,sbNo,skills);
                list.add(row);
              /*  list.add(new PrtTable(rs.getString("AN"),rs.getString("Name"),
                        rs.getString("Contact_no"),
                        rs.getString("address"),rs.getString("sb_no"),
                        rs.getString("skills")));*/
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public static ObservableList<SbTable> readSb() throws SQLException {
        Connection con=fetchConnection();
        ObservableList<SbTable> list= FXCollections.observableArrayList();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM sb");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String Sb_no = rs.getString(1);
                String SBName = rs.getString(2);
                String Name= rs.getString(3);
                String Contact_no=rs.getString(4);
                String description=rs.getString(5);//Sb_no,SBName,Name,Contact_no,description
                SbTable row = new SbTable(Sb_no,SBName,Name,Contact_no,description);
                list.add(new SbTable(rs.getString(1),rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),rs.getString(5)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}
