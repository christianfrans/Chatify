package model;
// Generated Oct 24, 2020 11:56:23 PM by Hibernate Tools 4.3.1

import controller.adminController;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;



@ManagedBean
/**
 * News generated by hbm2java
 */
public class News  implements java.io.Serializable {


     private Integer id;
     private Integer admin;
     private String title;
     private String url;

    public News() {
    }

    public News(Integer admin, String title, String url) {
       this.admin = admin;
       this.title = title;
       this.url = url;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Integer admin) {
        this.admin = admin;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public void save() {
        adminController controller = new adminController();
        controller.inputNews(this);
    }
    
    public List<SelectItem> getAllAdmin(){
        List<SelectItem> admin = new ArrayList<>();
        adminController controller = new adminController();
        List<Admin> adminID = controller.retrieveAdmin();
         for(Admin kode: adminID){
            admin.add(new SelectItem(kode.getId(), kode.getName()));
        }
        return admin;
    }
}


