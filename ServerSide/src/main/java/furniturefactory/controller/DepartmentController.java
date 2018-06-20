package furniturefactory.controller;

import furniturefactory.domain.Department;
import furniturefactory.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import furniturefactory.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    @Qualifier(value = "dprtmntSrv")
    DepartmentService departmentService;

    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {

        if (departmentDto == null) {
            return new ResponseEntity<DepartmentDto>(HttpStatus.NOT_FOUND);
        }

        Department department = convertToEntity(departmentDto);
        department = departmentService.addDepartment(department);
        departmentDto = convertToDto(department);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Department created  - ", String.valueOf(departmentDto.getId()));

        return new ResponseEntity<DepartmentDto>(departmentDto, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getDepartment/{id}", method = RequestMethod.GET)
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable long id) {

        Department department = departmentService.getById(id);
        if (department == null) {
            return new ResponseEntity<DepartmentDto>(HttpStatus.NOT_FOUND);
        }

        DepartmentDto departmentDto = convertToDto(department);

        return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllDepartments", method = RequestMethod.GET)
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {

        List<Department> departments = departmentService.getAll();
        if (departments == null && departments.isEmpty()) {
            return new ResponseEntity<List<DepartmentDto>>(HttpStatus.NOT_FOUND);
        }

        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for (Department department : departments) {
            DepartmentDto departmentDto = convertToDto(department);
            departmentDtos.add(departmentDto);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Department list  - ", String.valueOf(departmentDtos.size()));

        return new ResponseEntity<List<DepartmentDto>>(departmentDtos, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateDepartment/{id}", method = RequestMethod.POST)
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable long id,
                                                          @RequestBody DepartmentDto departmentDto) {

        if (departmentDto == null) {
            return new ResponseEntity<DepartmentDto>(HttpStatus.BAD_REQUEST);
        }

        Department isExist = departmentService.getById(id);
        if (isExist == null) {
            return new ResponseEntity<DepartmentDto>(HttpStatus.NOT_FOUND);
        }

        Department department = convertToEntity(departmentDto);
        department  = departmentService.updateDepartment(department);
        departmentDto = convertToDto(department);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Department updated  - ", String.valueOf(departmentDto));

        return new ResponseEntity<DepartmentDto>(departmentDto, httpHeaders, HttpStatus.OK);
    }

    private DepartmentDto convertToDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getName(), null, null);
        return departmentDto;
    }

    private Department convertToEntity(DepartmentDto departmentDto) {
        Department department = new Department(departmentDto.getId(), departmentDto.getName());
        return department;
    }
}
