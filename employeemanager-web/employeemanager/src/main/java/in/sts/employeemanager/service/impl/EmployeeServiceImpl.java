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

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	} 
	
	@Override
	public Employee addEmployee(Employee employee) {
		//employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User By Id : "+id+" was Not Found"));
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}


}
