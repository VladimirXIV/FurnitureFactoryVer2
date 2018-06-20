package furniturefactory.dao;

import furniturefactory.domain.Employee;

public class EmployeeDaoImpl extends GenericaDaoImpl<Employee> implements EmployeeDao {

    public void beanInit() {
        this.setClazz(Employee.class);
    }

}

