package chartlib.sql.tests;


import coreutilities.sql.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;


public class SQLTests
{
  public static void main(String... args) throws Exception
  {
    System.out.println("Running in " + System.getProperty("user.dir"));
    Connection connection = SQLUtil.getConnection(".", "LOG", "log", "log");
    
    if (false)
    {
      Statement delete = connection.createStatement();
      delete.execute("delete from datalog;");
      delete.close();
    }
    if (false)
    {
      // Insert timestamp    
      PreparedStatement pstmt = connection.prepareStatement("insert into datalog (logtime, comment) values (?, ?)");
  //  Date date = new Date(new java.util.Date().getTime());
      Timestamp ts = new Timestamp(new java.util.Date().getTime());
      pstmt.setTimestamp(1, ts);
      pstmt.setString(2, "This is a test");
      int u = pstmt.executeUpdate();
      System.out.println("Execute returns:" + u);
      Thread.sleep(2000L);
      ts = new Timestamp(new java.util.Date().getTime());
      pstmt.setTimestamp(1, ts);
      pstmt.setString(2, "This is a test (2)");
      u = pstmt.executeUpdate();
      System.out.println("Execute returns:" + u);
      
      pstmt.close();
      connection.commit();
    }
    
    if (false)
    {
      Statement insert = connection.createStatement();
      insert.execute("insert into datalog values (current_timestamp, 'Raw Insert');");
      insert.close();
      connection.commit();
    }

    String select = "select * from datalog;";
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(select);
    while (rs.next())
    {
      Timestamp d = rs.getTimestamp(1);
      String s = rs.getString(2);
      java.util.Date jd = new java.util.Date(d.getTime());
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
      System.out.println("Date:" + sdf.format(jd) + ", String:" + s);
    }
    rs.close();
//  connection.commit();
    
    SQLUtil.shutdown(connection);
  }
}
