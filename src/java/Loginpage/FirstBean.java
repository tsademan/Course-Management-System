
package Loginpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FirstBean {
     private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String USERNAME = "SYSTEM";
    private static final String PASSWORD = "4309";
    Connection con=null;
    private String username;
    private String password;
    private String msg="some problem is here" ;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
    public String Login() throws ClassNotFoundException, SQLException{
     try{
      Class.forName(DRIVER);
      con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
      Statement st=con.createStatement();
      ResultSet rs=st.executeQuery("select * from LoginTable where user1='"+getUsername()+"'&& pass='"+getPassword()+"'");
      if(rs.next())
        return "HomePage.xhtml";
      else 
        return "invalid username/password";  
     }
     catch(Exception event){
         
     }
         return null;
}
}