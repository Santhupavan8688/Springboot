package com.app.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.spring.exception.Resourcenotfound;
import com.app.spring.model.Employee;
import com.app.spring.repository.EmployeeJpaRepository;
@RestController
@RequestMapping("/api")
public class Employeecontroller {
    @Autowired
	public EmployeeJpaRepository repository;
    
    @PostMapping("/create")
    public ResponseEntity<Employee> saveemployee(@RequestBody Employee emp){
    	return new ResponseEntity<Employee>(repository.save(emp),HttpStatus.CREATED);
    	
    }
    
    @GetMapping("/employee")
    public List<Employee> getdetails(){
    return repository.findAll();
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getemployeebyid(@PathVariable(value="id") Long employeeid)throws Resourcenotfound{
    	Employee emp = repository.findById(employeeid).orElseThrow(()-> new Resourcenotfound("employee not found this id:"+employeeid));
    	return ResponseEntity.ok().body(emp);
    	
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateemployee(@PathVariable(value="id") Long employeeid,@RequestBody Employee emp) throws Resourcenotfound{
    	Employee emps = repository.findById(employeeid).orElseThrow(()-> new Resourcenotfound("employee not found this id:"+employeeid));
    emps.setFirstname(emp.getFirstname());
    emps.setLastname(emp.getLastname());
    emps.setEmail(emp.getEmail());
   final Employee update=repository.save(emps);
    return ResponseEntity.ok(update);
    }
}
