package spring.boot.demo.cache.repository;

import spring.boot.demo.cache.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
