package com.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginDTO;
import com.example.repository.UsersRepository;
import com.example.service.CustomUserDetailsService;

@RestController
@RequestMapping("/")
public class UsersController {
	
	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	CustomUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping
    public Principal retrievePrincipal(Principal principal) {
        return principal;
    }
	
	@PostMapping("/login")
	public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO loginDTO){
		Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>("User login successfully!.", HttpStatus.OK);
	}
    
    @GetMapping("/error")
	public String error() {
		return "Endpoint method not allowed. Please, check and try again.";
	}

	public String getErrorPath() {
		return error();
	}
}
