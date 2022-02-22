package in.sts.employeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sts.employeemanager.model.Employee;

/* 
 * Repository for employee entity
 *
 * @author gautam kumar
*/
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	/**
	 * Delete employee by id.
	 * 
	 * @param employeeId
	 */
	void deleteEmployeeById(Long id);
	
	/**
	 * Find employee by id.
	 * 
	 * @param employeeId
	 * @return
	 */
	Optional<Employee> findEmployeeById(Long id);
}
