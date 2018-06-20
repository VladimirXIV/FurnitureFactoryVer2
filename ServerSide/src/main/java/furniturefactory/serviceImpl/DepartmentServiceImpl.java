package furniturefactory.serviceImpl;

import furniturefactory.dao.DepartmentDao;
import furniturefactory.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import furniturefactory.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    @Qualifier(value = "dprtmntDao")
    DepartmentDao departmentDao;

    @Override
    public Department addDepartment(Department department) {
        department = departmentDao.create(department);
        return department;
    }

    @Override
    public Department getById(long id) {
        Department department = departmentDao.findOne(id);
        return department;
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments = departmentDao.findAll();
        return departments;
    }

    @Override
    public Department updateDepartment(Department department) {
        department = departmentDao.update(department);
        return department;
    }

    @Override
    public void delete(Department department) {
        departmentDao.delete(department);
    }

    @Override
    public void deleteById(long id) {
        departmentDao.deleteById(id);
    }
}
