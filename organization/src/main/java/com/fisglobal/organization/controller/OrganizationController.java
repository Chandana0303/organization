package com.fisglobal.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.organization.model.Organization;
import com.fisglobal.organization.repository.OrganizationRepository;

@RestController
@RequestMapping("/api/department")
public class OrganizationController{
	
	@Autowired
	public OrganizationRepository organizationRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllOrganizations(){
		List<Organization> organizations = organizationRepository.findAll();
		if(organizations.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(organizations);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Data not found");
		}
	}
	
	
	
}