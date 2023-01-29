
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
private Long score;
private Long sid;
private String descr;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
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
            String sql = "Insert into CourseTable3(CID,CNAME,CDHOURS,SCORE,SID,DESCR) values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cid);
            ps.setString(2, cname);
            ps.setString(3, cdhours);
            ps.setLong(4, score);
            ps.setLong(5, sid);
            ps.setString(6, descr);
           
            ps.executeUpdate();
        }
             catch (ClassNotFoundException | SQLException e) {
        }
      
    }
    public void deleteCourse(String id) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			 CourseBean reg = new CourseBean();
                        DBConnection dbcon = new DBConnection();
                        Connection con = dbcon.connMethod();
			String sql = "DELETE FROM CourseTable3 WHERE cid=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, cid);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
