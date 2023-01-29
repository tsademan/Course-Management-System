

    
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class GradeDelete {

 private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void Delete(){
    try{
    DBConnection db=new DBConnection();
    Connection con=db.connMethod();
    PreparedStatement ps=con.prepareStatement("Delete from COURSETABLE3 where sid=?");
    ps.setLong(1,id);
    ps.executeUpdate();
    }
    catch(Exception e){
      System.out.print(e);
    }
    }  
}

    
