package furniturefactory.controller;

import furniturefactory.domain.Employee;
import furniturefactory.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import furniturefactory.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    @Qualifier(value = "emplSrv")
    EmployeeService employeeService;


    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {

        if (employeeDto == null) {
            return new ResponseEntity<EmployeeDto>(HttpStatus.NOT_FOUND);
        }

        Employee employee = convertToEntity(employeeDto);
        employee = employeeService.addEmployee(employee);
        employeeDto = convertToDto(employee);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Employee created  - ", String.valueOf(employeeDto.getId()));

        return new ResponseEntity<EmployeeDto>(employeeDto, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id) {

        Employee employee = employeeService.getById(id);
        if (employee == null) {
            return new ResponseEntity<EmployeeDto>(HttpStatus.NOT_FOUND);
        }

        EmployeeDto employeeDto = convertToDto(employee);

        return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

        List<Employee> employees = employeeService.getAll();
        if (employees == null && employees.isEmpty()) {
            return new ResponseEntity<List<EmployeeDto>>(HttpStatus.NOT_FOUND);
        }

        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDto employeeDto = convertToDto(employee);
            employeeDtos.add(employeeDto);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Employee list  - ", String.valueOf(employeeDtos.size()));

        return new ResponseEntity<List<EmployeeDto>>(employeeDtos, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.POST)
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id,
                                                      @RequestBody EmployeeDto employeeDto) {

        Employee employee = employeeService.getById(id);
        if (employee == null) {
            return new ResponseEntity<EmployeeDto>(HttpStatus.NOT_FOUND);
        }

        employee = employeeService.updateEmployee(employee);
        employeeDto = convertToDto(employee);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Employee updated  - ", String.valueOf(employeeDto));

        return new ResponseEntity<EmployeeDto>(employeeDto, httpHeaders, HttpStatus.OK);
    }

    private EmployeeDto convertToDto(Employee employee) {
        EmployeeDto departmentDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getMiddleName(), employee.getLastName(), employee.getBirthdate(), null, null);
        return departmentDto;
    }

    private Employee convertToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getMiddleName(), employeeDto.getLastName());
        return employee;
    }


}

