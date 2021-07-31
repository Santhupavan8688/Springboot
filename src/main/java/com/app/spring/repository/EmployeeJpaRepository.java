package com.app.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.spring.model.Employee;
@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Long>{

}
