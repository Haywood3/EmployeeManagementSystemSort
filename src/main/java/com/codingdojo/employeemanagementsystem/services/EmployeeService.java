package com.codingdojo.employeemanagementsystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.employeemanagementsystem.models.Employee;
import com.codingdojo.employeemanagementsystem.repositories.EmployeeRepository;


@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	//find all
	public List<Employee> allEmployees() {
		return employeeRepo.findAll();
	}
	//find one
	public Employee oneEmployee(Long id) {
		Optional<Employee> optionalEmployee = employeeRepo.findById(id);
		if(optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}else {
			return null;
		}
	}
	//create
	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	//edit
	public Employee editEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	//delete
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}

	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
	 Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
	  Sort.by(sortField).descending();
	 
	 Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
	 return this.employeeRepo.findAll(pageable);
	}
}