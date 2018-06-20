package furniturefactory.service;


import furniturefactory.domain.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);    // create
    Employee getById(long id);                  // retrieve
    List<Employee> getAll();
    Employee updateEmployee(Employee employee); // update
    void     delete(long id);                   // delete

}
