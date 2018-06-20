package furniturefactory.service;

import furniturefactory.domain.Department;

import java.util.List;

public interface DepartmentService {

    Department       addDepartment(Department department);    // create
    Department       getById(long id);                        // retrieve
    List<Department> getAll();
    Department       updateDepartment(Department department); // update
    void             delete(Department department);
    void             deleteById(long id);                     // delete

}
