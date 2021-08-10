package com.fisglobal.organizationmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fisglobal.organizationmanagement.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, String> {

}
