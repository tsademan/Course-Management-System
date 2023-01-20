
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StdBean {
    private String  FName;
    private String  LName;
    private String   id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    List<String> genderList;

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
   public void profilerInsert() {
        //List<FirstManagedBean> list = new ArrayList<>();
        try {
            
            StdBean reg = new StdBean();
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into STDTABEL(FIRSTNAME,LASTNAME,ID,EMAIL,AGE,PHONE,ADDRESS,GENDER) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, FName);
            ps.setString(2, LName);
            ps.setString(3, id);
            ps.setString(4, email);
            ps.setString(5, age);
            ps.setString(6, phone);
            ps.setString(7, address);
            ps.setString(8,gender );
            ps.executeUpdate();
////            String sql1 = "Insert into USERTBL(USERNAMEE,PASSWORD,USERTYPE) values(?,?,?)";
////            PreparedStatement ps1 = con.prepareStatement(sql1);
////            ps1.setString(1,user);
////            ps1.setString(2, pwd);
////            ps1.setString(3, userType);
////            ps1.executeUpdate();
//            System.err.println("success");
//        } 
        }
catch (Exception e) {
   }
}
}