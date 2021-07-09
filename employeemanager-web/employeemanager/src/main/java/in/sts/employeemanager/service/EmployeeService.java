package in.sts.employeemanager.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sts.employeemanager.exception.UserNotFoundException;
import in.sts.employeemanager.model.Employee;
import in.sts.employeemanager.repo.EmployeeRepo;

@Service
@Transactional
public class EmployeeService {

	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee(Employee employee) {
		//employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	public List<Employee> findAllEmployees()
	{
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	
	public Employee findEmployeeById(Long id)
	{
		return employeeRepo.findEmployeeById(id)
							.orElseThrow(() -> new UserNotFoundException("User By Id : "+id+" was Not Found"));
	}
	
	public void deleteEmployeeById(Long id)
	{
		employeeRepo.deleteEmployeeById(id);
	}
	
}
