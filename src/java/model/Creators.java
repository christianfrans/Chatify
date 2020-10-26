package model;
// Generated Oct 24, 2020 11:56:23 PM by Hibernate Tools 4.3.1


import controller.creatorController;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * Creators generated by hbm2java
 */
@ManagedBean
public class Creators  implements java.io.Serializable {


     private Integer id;
     private String firstName;
     private String lastName;
     private String address;
     private String email;
     private String phone;
     private String username;
     private String password;
     private Set stickerses = new HashSet(0);

    public Creators() {
    }

	
    public Creators(String firstName, String lastName, String address, String email, String phone, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }
    public Creators(String firstName, String lastName, String address, String email, String phone, String username, String password, Set stickerses) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.address = address;
       this.email = email;
       this.phone = phone;
       this.username = username;
       this.password = password;
       this.stickerses = stickerses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set getStickerses() {
        return this.stickerses;
    }
    
    public void setStickerses(Set stickerses) {
        this.stickerses = stickerses;
    }
    
    public String validatelogin()
    { 
        try {
            creatorController controller = new creatorController();
            List<Creators> creators=controller.validateLogin(username, password);
            username=creators.get(0).username;
            password=creators.get(0).password;
            id=creators.get(0).id;
            
            FacesContext context = FacesContext.getCurrentInstance();
            if(username != null) {
                context.getExternalContext().getSessionMap().put("username", username);
                context.getExternalContext().getSessionMap().put("email", email);
                return "success";
            }
            else {
                return "error";
            }
        }
        catch(Exception ex) {
            return "error";
        }
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }
}


