package lk.whsars.DTO;

public class SupplierDetailsDto {

    String supplierName;
    String supplierNic;
    String address;
    String email;
    String phone;
    String date;
    //String company;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierNic() {
        return supplierNic;
    }

    public void setSupplierNic(String supplierNic) {
        this.supplierNic = supplierNic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public String getCompany() {
//        return company;
//    }
//
//    public void setCompany(String company) {
//        this.company = company;
//    }
}
