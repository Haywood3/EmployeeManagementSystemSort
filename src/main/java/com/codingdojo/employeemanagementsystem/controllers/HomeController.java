package com.codingdojo.employeemanagementsystem.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.employeemanagementsystem.models.Employee;
import com.codingdojo.employeemanagementsystem.services.EmployeeService;

@Controller
public class HomeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String central(HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("employeeList", employeeService.allEmployees());
		return "central.jsp";
	}
	@GetMapping("/employees/add")
	public String addEmployee(HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("addEmployee", new Employee ());
		return "addEmployee.jsp";
		}
	
	@PostMapping("employees/process")
	public String processEmployeeForm(
			@Valid @ModelAttribute("addEmployee") Employee employee,
			BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()) {
			return "addEmployee.jsp";
		}else {
			employeeService.createEmployee(employee);
			return "redirect:/employees/"+employee.getId();
		}
	}
	@GetMapping("employees/{id}")
	public String employeeDetails(
			@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		Employee foundEmployee = employeeService.oneEmployee(id);
		model.addAttribute("employee", foundEmployee);
		return "showEmployee.jsp";
	}
	@GetMapping("/employees/edit/{id}")
	public String editForm(@PathVariable("id")Long id, Model model, HttpSession session) {
		Employee foundEmployee = employeeService.oneEmployee(id);
		model.addAttribute("editEmployee", foundEmployee);
//		if(foundEmployee.getJob().getId() != (Long) session.getAttribute("userId")) {
//			return "redirect:/employees";
//		}
		return "editEmployee.jsp";
	}
	@PutMapping("/employees/edit/{id}")
	public String processEdit(
			@Valid @ModelAttribute("editEmployee") Employee employee,
			BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "editEmployee.jsp";
		}else {
			employeeService.editEmployee(employee);
			return "redirect:/employees/{id}";
		}
	}
	@DeleteMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable("id")Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}
	
	 @GetMapping("/page/{pageNo}")
	    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
	        @RequestParam("sortField") String sortField,
	        @RequestParam("sortDir") String sortDir,
	        Model model) {
	        int pageSize = 25;

	        Page < Employee > page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
	        List < Employee > employeeList = page.getContent();

	        model.addAttribute("currentPage", pageNo);
	        model.addAttribute("totalPages", page.getTotalPages());
	        model.addAttribute("totalItems", page.getTotalElements());

	        model.addAttribute("sortField", sortField);
	        model.addAttribute("sortDir", sortDir);
	        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

	        model.addAttribute("employeeList", employeeList);
	        return "central.jsp";
	    }
}