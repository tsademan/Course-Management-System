
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="courseUpdate")
@RequestScoped
public class CourseUpdate {
    private String sid;
    private String cname;
    private String cdhours;
    private Long score;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
    public void CourseUpdateData(){
     try {
            
           
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("UPDATE  CourseTable3 SET CNAME=?, CDHOURS=?,SCORE=?   WHERE SID=?");
             ps.setString(1, cname);
             ps.setString(2, cdhours);
             ps.setLong(3, score);
             ps.setString(4, sid);
             ps.executeUpdate();
     }
     catch(ClassNotFoundException | SQLException e){
       System.out.println("some problem is found");
     }
      
  }
}
