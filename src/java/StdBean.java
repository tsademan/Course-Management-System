
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StdBean {
    private String cname;
private String cdhours;
private String cid;
private String descr;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
private Long score;
private Long sid;

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
            String sql = "Insert into CourseTable(CID,CNAME,CDHOURS,SCORE,SID,DESCR) values(?,?,?,?,?,?)";
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
    private String  FName;
    private String  LName;
    private Long  id;
    private String  email;
    private  String    age;
    private String  phone;
    private String  address;
    private String gender;

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    } 
   private List <String>genderList;

    public List<String> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<String> genderList) {
        this.genderList = genderList;
    }

    public StdBean(){
        genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        genderList.add("Other");
    }
   

   public void StdData() throws SQLException {
        try {
            
            StdBean reg = new StdBean();
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into STDTABLE(FNAME,LNAME,ID,EMAIL,AGE,PHONE,ADDRESS,GENDER) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, FName);
            ps.setString(2, LName);
            ps.setLong(3, id);
            ps.setString(4, email);
            ps.setString(5, age);
            ps.setString(6, phone);
            ps.setString(7, address);
            ps.setString(8,gender );
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
 
