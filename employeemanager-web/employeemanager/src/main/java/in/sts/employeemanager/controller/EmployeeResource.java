package in.sts.employeemanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.sts.employeemanager.model.Employee;
import in.sts.employeemanager.service.EmployeeService;
import io.swagger.annotations.ApiOperation;

/**
 * API end points to manage Employee
 *
 * @author Gautam Kumar
 */
@RestController
@RequestMapping("/employee")
//@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeResource {
	private final EmployeeService employeeService;

	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	/*
	 * This API fetch all the employee list
	 * 
	 * @return
	 */	
	@ApiOperation("View all Employees Details")
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	
	/*
	 * This API fetch Employee details by Id
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@ApiOperation("View employee details by Id")
	@GetMapping("find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	
	/*
	 * This API adds new employee object
	 * 
	 * @param employee
	 * 
	 * @return
	 */	
	@ApiOperation("Add new employee to register")
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.OK);
	}
	
	
	/*
	 * This API updates the employee object
	 * 
	 * @param employee
	 * 
	 * @return
	 */	
	@ApiOperation("Update Employee details")
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		Employee updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	}
	
	
	/*
	 * This API deletes employee object
	 * 
	 * @param id
	 */	
	@ApiOperation("Delete Employee by Id")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id)
	{
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
