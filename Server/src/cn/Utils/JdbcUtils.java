package cn.Utils;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;


public final class JdbcUtils
{
  private static DataSource myDataSource = null;

  static
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      Properties pro = new Properties();

      String path = System.getProperty("user.dir") + "\\" + "dbcpconfig.properties";
      pro.load(new FileInputStream(path));
      myDataSource = BasicDataSourceFactory.createDataSource(pro);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new ExceptionInInitializerError(e);
    }
  }

  public static DataSource getDataSource()
  {
    return myDataSource;
  }

  public static Connection getConnection()
    throws SQLException
  {
    BasicDataSource bds = (BasicDataSource)myDataSource;
    System.out.println("active_number" + bds.getNumActive());
    System.out.println("idle_number" + bds.getNumIdle());

    return myDataSource.getConnection();
  }

  public static void free(ResultSet rs, Statement st, Connection con) {
    if (rs != null)
      try {
        rs.close();
      } catch (SQLException e) {
        e.printStackTrace();
        throw new ExceptionInInitializerError("连接关闭失败");
      }
      finally
      {
        if (st != null)
          try {
            st.close();
          }
          catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("连接关闭失败");
          }
          finally {
            if (con != null)
              try {
                con.close();
              }
              catch (SQLException e) {
                System.out.println("关闭失败");
                e.printStackTrace();
                throw new ExceptionInInitializerError("连接关闭失败");
              }
          }
      }
  }
}