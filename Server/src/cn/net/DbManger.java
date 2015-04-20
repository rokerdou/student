package cn.net;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.Utils.JdbcUtils;
import cn.Utils.Utils;
import cn.domain.Message;
import cn.domain.MessageData;
import cn.domain.Student;

public class DbManger {
	 private static DbManger db = new DbManger();
	 public static Object read = new Object();
	  public static DbManger getInstance()
	  {
	    return db;
	  }
	  public static Message Login(String user,String pwd,int type)
	  {
		    Connection con = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    Message ms = new Message();
		    String password="";
		  if(type==MessageData.LOGIN_TYPE_ADMIN)
		  {
		        String sql = "select password from admin where id=?";
		        try {
		        con = JdbcUtils.getConnection();
		        ps = con.prepareStatement(sql);
		        ps.setObject(1, user);


			        rs = ps.executeQuery();
			        if (rs.next())
			        {
			          password = rs.getString("password");
			        }
			        if (password.equals(pwd))
			        {
			        	ms.State=MessageData.RESPONSE_LOGIN_SUCCESS;
			        	return ms;
			        
			        }else
			        {
			        	ms.State=MessageData.RESPONSE_LOGIN_FAIL;
			        	return ms;
			        }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//ms.State=MessageData.SERVICE_ERROR;
					ms.State=MessageData.SERVICE_ERROR;
				
					e.printStackTrace();
					return ms;
				}     finally {
			        JdbcUtils.free(rs, ps, con);
			      }

			  
		  }
		  else if(type==MessageData.LOGIN_TYPE_STUDENT)
		  {
			  String sql = "select * from student where id=?";
		        try {
		        con = JdbcUtils.getConnection();
		        ps = con.prepareStatement(sql);
		        ps.setObject(1, user);


			        rs = ps.executeQuery();
			        if (rs.next())
			        {
			          password = rs.getString("password");
			        	ms.stu.id= rs.getString("id");
			        	ms.stu.name=rs.getString("name");
			        	ms.stu.sex=rs.getString("sex");
			        	ms.stu.classid=rs.getString("classid");
			        	ms.stu.classgrade=rs.getString("regtime");
			        	ms.stu.province=rs.getString("province");
			        	ms.stu.cardid=rs.getString("cardid");
			        	ms.stu.password=password;
			        }

			        if (password.equals(pwd))
			        {
			        	ms.State=MessageData.RESPONSE_LOGIN_SUCCESS;
	
			        	return ms;
			        
			        }else
			        {
			        	ms.State=MessageData.RESPONSE_LOGIN_FAIL;
			        	return ms;
			        }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//ms.State=MessageData.SERVICE_ERROR;
					ms.State=MessageData.SERVICE_ERROR;
				
					e.printStackTrace();
					return ms;
				}     finally {
			        JdbcUtils.free(rs, ps, con);
			      }
			  
		  }
		return ms;
	  }
	public Message AddnewStu(Student stu) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Message ms = new Message();
        String sql = "insert into student(id,name,password,sex,deptno,classid,regtime,province,cardid) values (?,?,?,?,?,?,?,?,?)";
        try {
			con = JdbcUtils.getConnection();
	        ps = con.prepareStatement(sql);
	        ps.setObject(1, stu.id);
	        ps.setObject(2, stu.name);
	        ps.setObject(3, stu.password);
	        ps.setObject(4, stu.sex);
	        ps.setObject(5, Utils.getDeptByclssId(stu.classid));
	        ps.setObject(6, stu.classid);
	        ps.setObject(7, stu.classgrade);
	        if(stu.province!=null&&stu.province.trim().length()>0)
	        {
	        	  ps.setObject(8, stu.province);
	        }
	        else
	        	ps.setObject(8, "");
	        ps.setObject(9, stu.cardid);
	      ps.executeUpdate();
	      ms.State=MessageData.RESPONSE_ADDSTU_SUCCESS;
	      return ms;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ms.State=MessageData.RESPONSE_ADDSTU_FAIL;
			e.printStackTrace();
			return ms;
		}finally {
	        JdbcUtils.free(rs, ps, con);
	      }

	
	}
}
