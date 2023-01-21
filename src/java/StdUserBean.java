


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "stdUserBean")
@SessionScoped
public class StdUserBean {

public List<StdBean> getUserList()
{
List<StdBean>list = new ArrayList<StdBean>();
PreparedStatement ps = null;
Connection con = null;
ResultSet rs = null;
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "4309");
String sql = "select * from STDTABEL";
ps= con.prepareStatement(sql); 
rs= ps.executeQuery(); 
while (rs.next())
{
StdBean usr = new StdBean();
usr.setFName(rs.getString("FName"));
usr.setLName(rs.getString("LName"));
usr.setId(rs.getString("id"));
usr.setEmail(rs.getString("email"));
usr.setAge(rs.getString("age"));
usr.setPhone(rs.getString("phone"));
usr.setAddress(rs.getString("address"));
usr.setGender(rs.getString("gender"));
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