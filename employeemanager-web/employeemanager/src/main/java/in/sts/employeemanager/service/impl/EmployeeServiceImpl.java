package in.sts.employeemanager.service.impl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sts.employeemanager.exception.UserNotFoundException;
import in.sts.employeemanager.model.Employee;
import in.sts.employeemanager.repo.EmployeeRepo;
import in.sts.employeemanager.service.EmployeeService;

/*
* Employee service implementation for employee entity management methods.
*
* @author Gautam Kumar
*/
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	} 
	
	/*
	 * override the method from employeeservice interface and defined to save the
	 * employee details to database in the method body
	 * 
	 * @param employee
	 * 
	 * @return
	 */
	@Override
	public Employee addEmployee(Employee employee) {
		//employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	/*
	 * override the abstract method of employeeservice interface and defined to find
	 * all employee list from database in the method body
	 * 
	 * @return
	 */
	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}

	/*
	 * override the method from employeeservice interface and defined to update the
	 * employee details to database in the method body
	 * 
	 * @param employee
	 * 
	 * @return
	 */
	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	
	/*
	 * override the method from employeeservice interface and defined fetch the
	 * employee details by thier id from database in the method body
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@Override
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User By Id : "+id+" was Not Found"));
	}

	/*
	 * override the method from employeeservice interface and defined to delete the
	 * employee object from database 
	 * 
	 * @param id
	 */
	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}


}
