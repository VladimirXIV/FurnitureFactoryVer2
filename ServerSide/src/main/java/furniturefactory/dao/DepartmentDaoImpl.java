package furniturefactory.dao;


import furniturefactory.domain.Department;

public class DepartmentDaoImpl extends GenericaDaoImpl<Department> implements DepartmentDao {

    public void beanInit() {
        this.setClazz(Department.class);
    }

}
