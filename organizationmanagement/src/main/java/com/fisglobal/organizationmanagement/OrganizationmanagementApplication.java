package com.fisglobal.organizationmanagement;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.organizationmanagement.model.Organization;
import com.fisglobal.organizationmanagement.repository.OrganizationRepository;

@SpringBootApplication
public class OrganizationmanagementApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context = SpringApplication.run(OrganizationmanagementApplication.class, args);
	OrganizationRepository organizationRepository = context.getBean(OrganizationRepository.class);
	//Organization organization = new Organization("o007","T","Mumbai");
	//organizationRepository.save(organization);
	}

}
