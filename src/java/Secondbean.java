
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


class Secondbean {

    static boolean express1(String username, String password) {
    boolean status =false;
         try {
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select * from logintable where USER1=? && PASS=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    }
