

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "gradeUserBean")
@SessionScoped
public class GradeUserBean {

public List<StdBean> getUserList()
{
List<StdBean> list = new ArrayList<StdBean>();
PreparedStatement ps = null;
Connection con = null;
ResultSet rs = null;
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TSADE", "4309");
String sql = "select a.FNAME, a.LNAME,a.ID, b.CNAME,b.CID,b.SCORE,b.DESCR from STDTABLE a, COURSETABLE3 b WHERE a.ID = b.SID";
ps= con.prepareStatement(sql); 
rs= ps.executeQuery(); 
while (rs.next())
{
StdBean usr = new StdBean();
usr.setFName(rs.getString("FName"));
usr.setLName(rs.getString("LName"));
usr.setId(rs.getLong("id"));
usr.setCname(rs.getString("CNAME"));
usr.setCid(rs.getString("CID"));
usr.setScore(rs.getLong("SCORE"));
usr.setDescr(rs.getString("descr"));

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
