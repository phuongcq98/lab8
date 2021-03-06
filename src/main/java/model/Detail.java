package model;
// Generated Dec 6, 2018 1:48:32 AM by Hibernate Tools 4.3.1



/**
 * Detail generated by hbm2java
 */
public class Detail  implements java.io.Serializable {


     private int detailId;
     private Employee employee;
     private String addressName;
     private Integer phoneNumber;

    public Detail() {
    }

	
    public Detail(int detailId, Employee employee) {
        this.detailId = detailId;
        this.employee = employee;
    }
    public Detail(int detailId, Employee employee, String addressName, Integer phoneNumber) {
       this.detailId = detailId;
       this.employee = employee;
       this.addressName = addressName;
       this.phoneNumber = phoneNumber;
    }
   
    public int getDetailId() {
        return this.detailId;
    }
    
    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public String getAddressName() {
        return this.addressName;
    }
    
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




}


