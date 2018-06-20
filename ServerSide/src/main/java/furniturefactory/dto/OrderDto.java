package furniturefactory.dto;

import furniturefactory.domain.Department;
import furniturefactory.domain.Employee;

import java.util.Date;

public class OrderDto {

    private long id;

    private String name;

    private Date date;

    private Date finalDate;

    private boolean isReady;

    private Department department;

    private Employee employee;


    public OrderDto() {

    }

    public OrderDto(long id, String name, Date date, Date finalDate, boolean isReady, Department department, Employee employee) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.finalDate = finalDate;
        this.isReady = isReady;
        this.department = department;
        this.employee = employee;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}





