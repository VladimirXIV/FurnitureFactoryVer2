package furniturefactory.dto;

import java.util.Set;

public class DepartmentDto {

    private long id;

    private String name;

    private Set<EmployeeDto> employees;

    private Set<OrderDto> orders;


    public DepartmentDto() {
    }

    public DepartmentDto(long id, String name, Set<EmployeeDto> employees, Set<OrderDto> orders) {
        this.id = id;
        this.name = name;
        this.employees = employees;
        this.orders = orders;
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

    public Set<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeDto> employees) {
        this.employees = employees;
    }

    public Set<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderDto> orders) {
        this.orders = orders;
    }
}
