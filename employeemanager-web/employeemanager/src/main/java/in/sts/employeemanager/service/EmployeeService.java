package in.sts.employeemanager.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import in.sts.employeemanager.model.Employee;

/**
* @author Gautam Kumar
* 
* Employee service interface to define all available methods for employee entity management
*/
@Service
@Transactional
public interface EmployeeService {

	/*
	 * Save employee details for registration
	 * 
	 * @param employee
	 * 
	 * @return
	 */
	public Employee addEmployee(Employee employee);
	
	/*
	 * Fetch all employee list
	 * 
	 * @return
	 */
	public List<Employee> findAllEmployees();
	
	/*
	 * Edit or update Employee details
	 * 
	 * @param employee
	 * 
	 * @return
	 */
	public Employee updateEmployee(Employee employee);
	
	/*
	 * Find or get employee details by employee Id
	 * 
	 * @param id
	 * 
	 * @return
	 */
	public Employee findEmployeeById(Long id);
	
	/*
	 * Delete Employee by their employee-id
	 * 
	 * @param id
	 */
	public void deleteEmployeeById(Long id);
	
}
