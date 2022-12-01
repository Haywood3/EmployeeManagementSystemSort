package com.codingdojo.employeemanagementsystem.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.employeemanagementsystem.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long>{
	Page<Employee> findAll(Pageable pageable);
	Iterable<Employee> findAll(Sort sort);
	List<Employee> findAll();
}