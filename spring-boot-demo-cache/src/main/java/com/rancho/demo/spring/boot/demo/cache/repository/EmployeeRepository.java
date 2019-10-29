package com.rancho.demo.spring.boot.demo.cache.repository;

import com.rancho.demo.spring.boot.demo.cache.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
