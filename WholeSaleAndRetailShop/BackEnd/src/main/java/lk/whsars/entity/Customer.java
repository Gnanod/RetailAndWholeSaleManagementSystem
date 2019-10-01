package lk.whsars.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cusID;
    String firstName;
    String lastName;
    String userName;
    String address;
    String nic;
    String phone;
    String email;
    String birthday;
    String type;
    String aboutCus;
    int loyaltyPoints;


    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "customer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<CustomerOrder> ordersList;


    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAboutCus() {
        return aboutCus;
    }

    public void setAboutCus(String aboutCus) {
        this.aboutCus = aboutCus;
    }

    public Set<CustomerOrder> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(Set<CustomerOrder> ordersList) {
        this.ordersList = ordersList;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }


}
