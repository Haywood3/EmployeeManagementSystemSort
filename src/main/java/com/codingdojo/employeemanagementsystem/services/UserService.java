package com.codingdojo.employeemanagementsystem.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.employeemanagementsystem.models.LoginUser;
import com.codingdojo.employeemanagementsystem.models.User;
import com.codingdojo.employeemanagementsystem.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	// TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO: Additional validations!
    	// Reject if email is taken (present in database)
    	// 1. find user in database by email
    	Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
    	// 2. if email is present, reject
    	if(optionalUser.isPresent()) {
    		result.rejectValue("email", "Unique", "The email is already registered");
    	}
    	// Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The passwords are unmatched");
    	}
    	// return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    	// hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }
    public User login(LoginUser newLogin, BindingResult result) {
        // TO-DO: Additional validations!
	    // TO - reject values
	    // 1. find user in database by email
	    Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
	    // 2. if email is not present, reject
	    if(!optionalUser.isPresent()) {
	    	result.rejectValue("email", "Unique", "Email Not Registered");
	    	return null;
	    }
	    // 3. grab the user from potential user
	    User user = optionalUser.get();
	    
	    // if BCrypt match fails
	    if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	        result.rejectValue("password", "Matches", "Invalid Password!");
	    }
	    // 4. if result has errors, return
	    if(result.hasErrors()) {
	    	return null;
	    }
	    // otherwise return the user object
	    return user;
    }   
}