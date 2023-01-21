
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="courseBean")
@RequestScoped
public class CourseBean {
private String cname;
private String cdhours;
private String cid;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdhours() {
        return cdhours;
    }

    public void setCdhours(String cdhours) {
        this.cdhours = cdhours;
    }
    public void CourseData(){
        try {     
            CourseBean reg = new CourseBean();
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into CourseTable(CID,CNAME,CDHOURS) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cid);
            ps.setString(2, cname);
            ps.setString(3, cdhours);
            ps.executeUpdate();
        }
             catch (ClassNotFoundException | SQLException e) {
        }
      
    }
}
