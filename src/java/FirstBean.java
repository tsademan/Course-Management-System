import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class FirstBean implements Serializable {
   private String username;
   private String password;

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
   

  
   
    public String login() throws SQLException, ClassNotFoundException {
        boolean valid =Secondbean.express1(username,password);
         if (valid) {
              DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select pass from loginTabel where user1=?");
            ps.setString(1, username);       
            ResultSet rs = ps.executeQuery();
            rs.next();
            String userType =rs.getString(1);
            //HttpSession session = Session.getSession();
            //session.setAttribute("username", user);
            if ("Admin".equals(username)) {
                return "HomePage";
            } else {
                return "HomePage";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "index";
        }
    }

  
    
}