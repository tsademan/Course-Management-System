

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

public List<CourseBean> getUserList()
{
List<CourseBean> list = new ArrayList<CourseBean>();
PreparedStatement ps = null;
Connection con = null;
ResultSet rs = null;
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TSADE", "4309");
String sql = "select * from COURSETABLE3";
ps= con.prepareStatement(sql); 
rs= ps.executeQuery(); 
while (rs.next())
{
CourseBean usr = new CourseBean();
usr.setCid(rs.getString("cid"));
usr.setCname(rs.getString("cname"));
usr.setCdhours(rs.getString("cdhours"));
usr.setScore(rs.getLong("score"));

list.add(usr);
} 
}
catch(Exception e)
{
e.printStackTrace();
}
finally
{
try
{
con.close();
ps.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}
return list;
}
}