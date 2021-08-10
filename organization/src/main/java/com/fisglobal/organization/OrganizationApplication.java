package com.fisglobal.organization;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.organization.model.Organization;
import com.fisglobal.organization.repository.OrganizationRepository;

@SpringBootApplication
public class OrganizationApplication {

	public static void main(String[] args) {
	 ConfigurableApplicationContext context = SpringApplication.run(OrganizationApplication.class, args);
	 OrganizationRepository organizationRepository = context.getBean(OrganizationRepository.class);
	 //Organization organization = new Organization("o002","Ibm","Bangalore");
	 //organizationRepository.save(organization);
	 //List<Organization> organizations = organizationRepository.findAll();
	 //System.out.println(organizations);
	}

}
