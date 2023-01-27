
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class GradeBean {
  private Long sid;
  private Long cid;
  private Long score;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
    public void StdGrade(){
          
        try {
            
            StdBean reg = new StdBean();
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into GradeTable(SID,CID,SCORE) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, sid);
            ps.setLong(2, cid);
            ps.setLong(3, score);
            ps.executeUpdate();
        }
catch (Exception e) {
   }


PreparedStatement ps = null;
Connection con = null;

try
{
 
ps.executeUpdate();

con.close();
ps.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}
}
