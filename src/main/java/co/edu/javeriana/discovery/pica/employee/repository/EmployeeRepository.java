package co.edu.javeriana.discovery.pica.employee.repository;

import co.edu.javeriana.discovery.pica.employee.repository.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
