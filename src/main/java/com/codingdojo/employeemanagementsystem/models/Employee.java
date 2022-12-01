package com.codingdojo.employeemanagementsystem.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Employees")
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotNull
    @Min(value= 99, message="Number must be over 99")
    @Max(value=1000, message="Number must less than 100")
    private Integer employeeNumber;
	
	@NotNull
	@Size(min = 1, max = 28, message="Please Provide First Name")
	private String firstName;
	
	@NotNull
	@Size(min = 0, max = 28)
	private String middleName;
	
	@NotNull
	@Size(min = 1, max = 28, message="Please Provide Last Name")
	private String lastName;
	
	@NotNull
    @Min(value= 1)
	@Max(value= 1000000000, message="Please Provide Social Security Number, no dashes")
    private Integer socialSecurity;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
	
	@NotNull
	@Size(min = 1, max = 56, message="Please Provide Personal Email")
	private String email;
	
	@NotNull
	@Size(min = 1, max = 10, message="Please Provide 10 Digit Primary Phone Number, no dashes")
	private String phone;
	
	@NotNull
    @Min(value= 1, message="Please Provide Address Number, NO P.O. BOX")
	@Max(value= 1000000, message="Please Provide Address Number, NO P.O. BOX")
    private Integer addressNumber;
	
	@NotNull
	@Size(min = 1, max = 28, message="Please Provide Address, NO P.O. BOX")
	private String addressStreet;
		
	@NotNull
	@Size(min = 1, max = 28, message="Please Provide City")
	private String city;
	
	@NotNull
	@Size(min = 1, max = 2, message="Please Provide State Abreviation")
	private String state;
	
	@NotNull
	@Size(min = 1, max = 12, message="Please Provide Five Digit Zip Code")
	private String zipCode;
	
	@NotNull
	@Size(min = 1, max = 28, message="Please Provide Department")
	private String department;
	
	@NotNull
	@Size(min = 1, max = 28, message="Please Provide Manager Name")
	private String manager;
	
	@NotNull
	@Size(min = 1, max = 28, message="Please Provide Job Title")
	private String jobTitle;

	@NotNull
    @Min(value= 1, message="Please Provide Salary")
    private Integer salary;
		
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hireDate;
	
	@NotNull
	@Size(min = 1, max = 28, message="Please Provide Status")
	private String status;
	
	@NotNull
	@Size(min=0, max=500, message="Maximun 500 characters")
	private String notes;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date lastDate;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="job_id")
	private User job;
	
	public Employee () {}
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(Integer addressNumber) {
		this.addressNumber = addressNumber;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public Integer getSocialSecurity() {
		return socialSecurity;
	}
	public void setSocialSecurity(Integer socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public User getJob() {
		return job;
	}
	public void setJob(User job) {
		this.job = job;
	}
}