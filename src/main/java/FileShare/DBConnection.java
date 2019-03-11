package FileShare;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kerwan Miguel Antoine
 */
public class DBConnection implements Runnable {
    
    private static Connection connect;
    private static PreparedStatement pst;
    private static ResultSet results;
    private final String DBLOGIN = "kmantoine";
    private final String DB = "kjasghfdkgasP@ssw0rddfjlkasfljkahgdsfjhgdjsfh";
    private final String DBURL = "jdbc:mysql://mysql8.db4free.net:3307/secureshare";
    
    public static String name;

    @Override
    public void run () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(DBURL, DBLOGIN, DB.substring (12, 20));
            Logger.getLogger(DBConnection.class.getName()).log(Level.INFO, "Database Connected Successfully");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger (DBConnection.class.getName ()).log (Level.SEVERE, "Error connecting to Database", ex);
        }
    }

    //validate the login of users
    protected static boolean validateLogin(String usrname, String pword) {
        try {
            pst = connect.prepareStatement("Select * from Users where ID=? and Password=?");
            pst.setString(1, usrname);
            pst.setString(2, pword);
            results = pst.executeQuery();
            results.next();
            name = results.getString("Name");
            return true;
        } catch (SQLException| NullPointerException | HeadlessException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Error Validating User");
            return false;
        } finally {
            try {
                if (results != null) {
                    results.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Database Error", ex);
            }
        }
    }

    //Qurey names to fill the share file box
    protected static void runListQuery () {
        try {
            pst = connect.prepareStatement("Select Name from Users");
            results = pst.executeQuery();
            while (results.next()) {
                Share.model.addElement(results.getString (1));
            }
        } catch (SQLException ex) {
            Logger.getLogger (DBConnection.class.getName ()).log (Level.SEVERE, "Database Error", ex);
        } finally {
            try {
                if (results != null) {
                    results.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Database Error", ex);
            }
        }
    }

    //Qurey selected users telephone number and email address for sharing files
    protected static String[] runShareQuery (String name) {
        try {
            pst = connect.prepareStatement("Select * from Users where Name=?");
            pst.setString (1, name);
            results = pst.executeQuery();
            while (results.next()) {
                return new String[] {results.getString ("Telephone"),results.getString ("E-Mail")};
            }
        } catch (SQLException ex) {
            Logger.getLogger (DBConnection.class.getName ()).log (Level.SEVERE, "Database Error", ex);
            return null;
        } finally {
            try {
                if (results != null) {
                    results.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Database Error", ex);
            }
        }
        return null;
    }

    //inserts encryption password into database along with filepath
    protected static void insertIntoDB (String rName, String fileName, String key) {
        try {
            pst = connect.prepareStatement("INSERT INTO Ecryption_Passwords" +  "(File_Name, Encryption_Key, Recipient)" + "VALUES" + "(?, ?, ?)");
            pst.setString(1, fileName);
            pst.setString(2, key);
            pst.setString (3, rName);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger (DBConnection.class.getName ()).log (Level.SEVERE, "Error inserting into database", ex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Database Error", ex);
            }
        }
    }

    //get encryption password from database and matches it
    public static boolean pullKey (String fileName, String key) {
        try {
            pst = connect.prepareStatement("SELECT * FROM Ecryption_Passwords WHERE File_Name=? and Encryption_Key=? and Recipient=?");
            pst.setString(1, fileName);
            pst.setString(2, key);
            pst.setString (3, name);
            results = pst.executeQuery();
            return results.next ();

        } catch (SQLException | NullPointerException | HeadlessException ex) {
            Logger.getLogger (DBConnection.class.getName ()).log (Level.SEVERE, "Database Error", ex);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (results != null) {
                    results.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Database Error", ex);
            }
        }        
    }

    //inserts encryption password into database along with filepath
    protected static void deleteFromDB (String fileName, String key) {
        try {
            pst = connect.prepareStatement("DELETE FROM Ecryption_Passwords WHERE File_Name=? and Encryption_Key=? and Recipient=?");
            pst.setString(1, fileName);
            pst.setString(2, key);
            pst.setString(3, name);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger (DBConnection.class.getName ()).log (Level.SEVERE, "Error deleting from database", ex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Database Error", ex);
            }
        }
    }

    /*      CONNECT TO DATABASE ----------------------------------------------------------------------------------------------
    public static void connectDB () {
Restart:try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(DBURL, DBLOGIN, DB);
            Logger.getLogger(DBConnection.class.getName()).log(Level.INFO, "Database Connected Successfully");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger (DBConnection.class.getName ()).log (Level.SEVERE, "Error connecting to Database", ex);
            break Restart;
        }
    }*/

}