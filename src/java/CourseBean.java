
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CourseBean {
private String cname;
private String cid;
private String cdhours;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCdhours() {
        return cdhours;
    }

    public void setCdhours(String cdhours) {
        this.cdhours = cdhours;
    }

}
