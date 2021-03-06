package model;
// Generated Dec 6, 2018 1:48:32 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Employee generated by hbm2java
 */
public class Employee  implements java.io.Serializable {


     private int userId;
     private String name;
     private Set<Detail> details = new HashSet<Detail>(0);

    public Employee() {
    }

	
    public Employee(int userId) {
        this.userId = userId;
    }
    public Employee(int userId, String name, Set<Detail> details) {
       this.userId = userId;
       this.name = name;
       this.details = details;
    }
   
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set<Detail> getDetails() {
        return this.details;
    }
    
    public void setDetails(Set<Detail> details) {
        this.details = details;
    }




}
