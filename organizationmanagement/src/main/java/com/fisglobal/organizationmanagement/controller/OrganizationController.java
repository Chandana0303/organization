package com.fisglobal.organizationmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.organizationmanagement.exception.ResourceNotFound;
import com.fisglobal.organizationmanagement.model.Organization;
import com.fisglobal.organizationmanagement.repository.OrganizationRepository;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

	@Autowired
	public OrganizationRepository organizationRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllOrganizations()
	{
		List<Organization> organizations = organizationRepository.findAll();
		if(organizations.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(organizations);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Data not found");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrganizationById(@PathVariable("id") String id) throws ResourceNotFound
	{
		
		Organization organization = organizationRepository.findById(id).orElseThrow(()->new ResourceNotFound("department not found::"+id));
		return ResponseEntity.ok().body(organization);
		/*Optional<Organization> optional= organizationRepository.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
		}*/
		
	}
	
	@PostMapping("/createOrganization")
	public ResponseEntity<?> createDepartment(@Valid @RequestBody Organization organization)
	{	
			if(organizationRepository.existsById(organization.getOrgId()))
			{
				return ResponseEntity.status(HttpStatus.CONFLICT).body("record already exists");
			}
			Organization org1 = organizationRepository.save(organization);
			System.out.println(org1);
			if(org1!=null)
			{
			return ResponseEntity.status(HttpStatus.CREATED).body(org1);
		
	}
			else
			{
				return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Data not created");
			}
}
}
