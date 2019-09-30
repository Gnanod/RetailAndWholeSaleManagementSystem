package lk.whsars.DTO;

public class SalarySheetDTO {
    private String empName;
    private String role;
    private int employeeId;
    private String basicSal;
    private String netSal;
    private String date;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getBasicSal() {
        return basicSal;
    }

    public void setBasicSal(String basicSal) {
        this.basicSal = basicSal;
    }

    public String getNetSal() {
        return netSal;
    }

    public void setNetSal(String netSal) {
        this.netSal = netSal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
