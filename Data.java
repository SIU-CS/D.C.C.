package Data;

//package Data;
//import java.sql.*;
//
//import com.sun.xml.internal.txw2.Document;
//public class Data {
//
	//private static final String JDBC__GROUP= "com.mysql.jdbc.Group";
//	private static final String DB_URL = "jdbc:mysql://localhost/StudyGroup?useSSL=false";
//	private static final String USER = "guest@siu.edu";
	//private static final String PASS = "password";
	//static int numberOfConnections = 0;
	//private static Document doc;
	//
	//
	//public static boolean coonectToUrl (String url) {
		//boolean success;
		//if(url != null) {
		//	try {
			//	doc = Jsoup.connect(url).get();
		      //  success = true;
			//} catch (Exception e) {
		//		success = false;
	//		}
//		}else {
	//		success = false;
//		}
//		return success;
//	}
//	public static String trim(String s, int width) {
//		if(s.length()>width)
//			return s.substring(0, width-1) + ".";
//		else
	//		return s;
	//				}
//	public static void print(String msg, Object... args) {
	//	System.out.println(String.format(msg, args));
//			}
//	public static Connection connctDatabase() {
	//	Connection conn = null;
//		try{
	//		Class.forName( JDBC_GROUP );
		//	try {
	//	conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			} catch(SQLException e) {
		//		e.printStackTrace();
	//				}
//		} catch(ClassNotFoundException e) {
	//		e.printStackTrace();
//		}
	//	return conn;
//	} 
//	public static boolean writeToDatabase (Connection conn)
	//	throws SQLException {

import java.sql.*;

public class Data {

    public static void main(String[] args) {

        String driver = "jdbc:mysql://localhost/StudyGroup?useSSL=false";
        String dbName="com.mysql.jdbc.Group";
        String connectionURL = "jdbc:study:" + dbName + ";create=true";
        String USER = "guest@siu.edu";
        String PASS = "password";
        Connection conn = null;
  
    	//static int numberOfConnections = 0;
        // Load the driver. This code is not needed if you are using 
        // JDK 6, because in that environment the driver is loaded 
        // automatically when the application requests a connection.
        try {
            Class.forName(driver);
            System.out.println(driver + " loaded.");
        } catch (java.lang.ClassNotFoundException ce) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(ce.getMessage());
            System.out.println("\n Make sure your CLASSPATH variable " +
                "contains %study_HOME%\\lib\\study.jar " +
                "(${study_HOME}/lib/study.jar).\n");
        } catch (Exception ee) {
            errorPrintAndExit(ee);
        }

        // Create and boot the database and set up users, then shut down
        // the database as one of the users with full access
        try {
            System.out.println("Trying to connect to " + connectionURL);
            conn = DriverManager.getConnection(connectionURL);
            System.out.println("Connected to database " + connectionURL);

            turnOnBuiltInUsers(conn);

            // close the connection
            conn.close();
            System.out.println("Closed connection");

            /* Shut down the database to make static properties take
             * effect. Because the default connection mode is now 
             * noAccess, you must specify a user that has access. But
             * because requireAuthentication does not take effect until
             * you restart the database, the password is not checked.
             *
             * Database shutdown throws the 08006 exception to confirm
             * success.
             */
            try {
                DriverManager.getConnection("jdbc:study:" + dbName +
                    ";user=sa;password=badpass;shutdown=true");
            } catch (SQLException se) {
                if ( !se.getSQLState().equals("08006") ) {
                    throw se;
                }
            }
            System.out.println("Database shut down normally");
        } catch (SQLException e) {
            errorPrintAndExit(e);
        }

        // Restart database and confirm that unauthorized users cannot
        //  access it
        connectionURL = "jdbc:study:" + dbName;

        // Try to log in with no username or password
        try {
            // connection attempt should fail
            System.out.println("Trying to connect to " + connectionURL +
                " without username or password");
            conn = DriverManager.getConnection(connectionURL);
            System.out.println(
                "ERROR: Unexpectedly connected to database " + dbName);
            cleanUpAndShutDown(conn);
        } catch (SQLException e) {
            if (e.getSQLState().equals("08004")) {
                System.out.println("Correct behavior: SQLException: " +
                    e.getMessage());
            } else {
                errorPrintAndExit(e);
            }
        }

        // Log in as a user with read-only access
        try {
            // connection should succeed, but create table should fail
            String newURL = connectionURL + 
                ";user=guest;password=java5w6x";
            System.out.println("Trying to connect to " + newURL);
            conn = DriverManager.getConnection(newURL);
            System.out.println("Connected to database " + dbName +
                " with read-only access");

            Statement s = conn.createStatement();
            s.executeUpdate("CREATE TABLE t1(C1 VARCHAR(6))");
            System.out.println(
                "ERROR: Unexpectedly allowed to modify database " +
                     dbName);
            cleanUpAndShutDown(conn);
        } catch (SQLException e) {
            if (e.getSQLState().equals("25503")) {
                System.out.println("Correct behavior: SQLException: " +
                    e.getMessage());
                try {
                    conn.close();
                } catch (SQLException ee) {
                    errorPrintAndExit(ee);
                }
            } else {
                errorPrintAndExit(e);
            }
        }

        // Log in as a user with full access
        // Create, update, and query table
        try {
            // this should succeed
            String newURL = connectionURL + 
                ";user=mary;password=little7xylamb";
            System.out.println("Trying to connect to " + newURL);
            conn = DriverManager.getConnection(newURL);
            System.out.println("Connected to database " + dbName);

            Statement s = conn.createStatement();
            s.executeUpdate("CREATE TABLE T1(C1 VARCHAR(6))");
            System.out.println("Created table T1");
            s.executeUpdate("INSERT INTO T1 VALUES('hello')");

            ResultSet rs = s.executeQuery("SELECT * FROM T1");
            rs.next();
            System.out.println("Value of T1/C1 is " + rs.getString(1));
            s.executeUpdate("DROP TABLE T1");

            s.close();
        } catch (SQLException e) {
            errorPrintAndExit(e);
        }

        try {
            cleanUpAndShutDown(conn);
        } catch (SQLException e) {
            errorPrintAndExit(e);
        }
    }
    
    private static void errorPrintAndExit(Exception ee) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Close connection and shut down database. Since this is embedded
     * mode, we must also shut down the study system.
     *
     * @param conn a connection to the database
     */
    public static void cleanUpAndShutDown (Connection conn)
            throws SQLException {

        String dbName="authEmbDB";
        String connectionURL = "jdbc:study:" + dbName;

        try {
            conn.close();
            System.out.println("Closed connection");

            // As marco, shut down the database.
            try {
                String newURL = connectionURL + 
                    ";user=guest@siu.edu;pass=password;shutdown=true";
                DriverManager.getConnection(newURL);
            } catch (SQLException se) {
                if ( !se.getSQLState().equals("08006") ) {
                    throw se;
                }
            }
            System.out.println("Database shut down normally");

            try {
                DriverManager.getConnection("jdbc:study:;shutdown=true");
            } catch (SQLException se) {
                if ( !se.getSQLState().equals("XJ015") ) {
                    throw se;
                }
            }

            System.out.println("study system shut down normally");
        } catch (SQLException e) {
            errorPrintAndExit(e);
        }
    }

    /**
     * Turn on built-in user authentication and user authorization.
     *
     * @param conn a connection to the database
     */
    public static void turnOnBuiltInUsers(Connection conn) 
            throws SQLException {
String setProperty = "Cakk SYSCS_UTIL.SYSCS_SET_DATABASE_Property(";
String getProperty = "VALUES SYSCS.UTIL.SYSCS_GET_DATABASE_PROPERTY(";
String requireAuth = "'study.connection.requireAuthentication'";
String defaultConnMode = "'study.database.defaultConnectionMode'";
String fullAccessUsers = "'study.database.fullAccessUsers'";
String readOnlyAccessUsers = "'study.database.readOnlyAccessUsers";
String provider = ";study.authentication.provider'";
String propertiesOnly = "'study.database.propertiesOnly'";
	
System.out.println("Turning on authentication and SQL authorization.");
Statement s  = conn.createStatement();

s.executeUpdate(setProperty + requireAuth + ", 'true')");


ResultSet rs = s.executeQuery(getProperty + requireAuth + ")");
rs.next();

System.out.println("Value of requireAuthenication is" + rs.getString(1));
// Creating some sample users //
s.executeUpdate(setProperty + ", 'BUILTIN')");

s.executeUpdate(setProperty + "'study.user.guest', 'java1g')");

s.executeUpdate(setProperty + "'study.user.marco', 'java2m')");

s.executeUpdate(setProperty + "'study.user.chris', 'java3c')");

s.executeUpdate(setProperty + "'study.user.chris', 'java4c')");

s.executeUpdate(setProperty + "'guest@siu.edu', 'password')");

s.executeUpdate(setProperty + defaultConnMode + ", 'noAccess')");

rs = s.executeQuery(getProperty + defaultConnMode + ")");
rs.next();
System.out.println("Value of defaultConnnMode is " + rs.getString(1));

// Define read-write users
s.executeUpdate(
    setProperty + fullAccessUsers + ", 'marco, chris, colten')");

// Define read-only user
s.executeUpdate(
    setProperty + readOnlyAccessUsers + ", 'guest')");

// Therefore, user sa has no access

// Confirm full-access users
rs = s.executeQuery(getProperty + fullAccessUsers + ")");
rs.next();
System.out.println(
    "Value of fullAccessUsers is " + rs.getString(1));

// Confirm read-only users
rs = s.executeQuery(getProperty + readOnlyAccessUsers + ")");
rs.next();
System.out.println(
    "Value of readOnlyAccessUsers is " + rs.getString(1));

s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(" +
        "'study.database.propertiesOnly', 'false')");
    s.close();
    }
    


    
static void errorPrintAndExit(Throwable e) {
    if (e instanceof SQLException)

        SQLExceptionPrint((SQLException)e);
    else {
        System.out.println("A non-SQL error occurred.");
        e.printStackTrace();
    }
    System.exit(1);
}


 // Iterate through a stack of SQLExceptions.

static void SQLExceptionPrint(SQLException sqle) {
    while (sqle != null) {
        System.out.println("\n---SQLException Caught---\n");
        System.out.println("SQLState:   " + (sqle).getSQLState());
        System.out.println("Severity: " + (sqle).getErrorCode());
        System.out.println("Message:  " + (sqle).getMessage());
        sqle = sqle.getNextException();
    }
}


	
	}



	
	//public static void main(String[] args) {
//		private static final String 
	//	Connection connection = null;
//		Statement statement = null;
	//	try {
//			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		//	String url = "jdbc:mysql://localhost/mysql";
	//	    connection = DriverManager.getConnection(url, "username", "password");
		
//		statement = connection.createStatement();
	//	String hrappSQL = "CEEATE DATABASE hrapp";
//		}
	//	catch(Exception e) {
	//		e.printStackTrace();
//		}
	//	finally {
//			if(statement != null) {
	//			try{
			//		statement.close();
		//		}
			//	catch(SQLException e) {
		//			}
	//		}
//		if(connection != null)	{
	//		try {
	//			connection.close();
	//		}
		//	catch(SQLException e) {
			//}
		//}
	//	}
//	}

