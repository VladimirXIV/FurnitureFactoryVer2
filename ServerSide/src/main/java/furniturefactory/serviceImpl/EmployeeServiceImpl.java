package furniturefactory.serviceImpl;

import furniturefactory.dao.EmployeeDao;
import furniturefactory.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import furniturefactory.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    @Qualifier(value = "emplDao")
    EmployeeDao employeeDao;

    @Override
    public Employee addEmployee(Employee employee) {
        employee = employeeDao.create(employee);
        return employee;
    }

    @Override
    public Employee getById(long id) {
        Employee employee = employeeDao.findOne(id);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = employeeDao.findAll();
        return employees;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employee = employeeDao.update(employee);
        return employee;
    }

    @Override
    public void delete(long id) {

    }
}
