package in.sts.employeemanager.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import in.sts.employeemanager.model.Employee;


@Service
@Transactional
public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	
	public List<Employee> findAllEmployees();
	
	public Employee updateEmployee(Employee employee);
	
	public Employee findEmployeeById(Long id);
	
	public void deleteEmployeeById(Long id);
	
}
