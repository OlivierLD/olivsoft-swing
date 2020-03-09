package chartlib.sql.tests;


import coreutilities.sql.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class SQLTests02
{
  public static void main(String[] args)
    throws Exception
  {
    System.out.println("Running in " + System.getProperty("user.dir"));
    Connection connection = SQLUtil.getConnection(".", "LOG", "log", "log");
    
    String wd = "SET WRITE_DELAY FALSE"; // Default is 10 sec.
    Statement stmtWD = connection.createStatement();
    stmtWD.execute(wd);    

    if (true)
    {
      // Insert timestamp
      PreparedStatement pstmt = connection.prepareStatement("insert into datatype (id, label) values (?, ?)");
      pstmt.setString(1, "CSP");
      pstmt.setString(2, "Current Speed");
      int u = pstmt.executeUpdate();
      System.out.println("Execute returns:" + u);
      pstmt.setString(1, "CDR");
      pstmt.setString(2, "Current Direction");
      u = pstmt.executeUpdate();
      System.out.println("Execute returns:" + u);

//    pstmt.close();
      connection.commit();
    }

    String select = "select * from datatype order by 1 desc;";
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(select);
    while (rs.next())
    {
      String s1 = rs.getString(1);
      String s2 = rs.getString(2);
      System.out.println(s1 + ", " + s2);
    }
    rs.close();

    Thread.sleep(2000L);
    
    SQLUtil.shutdown(connection);
  }
}
