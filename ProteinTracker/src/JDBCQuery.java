import java.sql.* ;

class JDBCQuery
{
 public static void main( String args[] )
 {
  try {
      // Load the database driver
      Class.forName( "com.mysql.jdbc.Driver" ) ;

      // Get a connection to the database
      Connection conn = DriverManager.getConnection( "jdbc:mysql://windows:3306/protein_tracker", "appuser", "appuser" ) ;

      // Print all warnings
      for( SQLWarning warn = conn.getWarnings(); warn != null; warn = warn.getNextWarning() )
         {
          System.out.println( "SQL Warning:" ) ;
          System.out.println( "State  : " + warn.getSQLState()  ) ;
          System.out.println( "Message: " + warn.getMessage()   ) ;
          System.out.println( "Error  : " + warn.getErrorCode() ) ;
         }

      // Get a statement from the connection
      Statement stmt = conn.createStatement() ;

      // Execute the query
      ResultSet rs = stmt.executeQuery( "SELECT * FROM users" ) ;

      // Loop through the result set
      System.out.println("id\tName\tTotal\tGoal");
      while( rs.next() )
         System.out.println( rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)) ;

      // Close the result set, statement and the connection
      rs.close() ;
      stmt.close() ;
      conn.close() ;
  }
  catch( SQLException se )
     {
      System.out.println( "SQL Exception:" ) ;

      // Loop through the SQL Exceptions
      while( se != null )
         {
          System.out.println( "State  : " + se.getSQLState()  ) ;
          System.out.println( "Message: " + se.getMessage()   ) ;
          System.out.println( "Error  : " + se.getErrorCode() ) ;

          se = se.getNextException() ;
         }
     }
  catch( Exception e )
     {
      System.out.println( e ) ;
     }
 }
}