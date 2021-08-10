package com.fisglobal.organizationmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="org")
public class Organization {
	
	@Id
	private String orgId;
	@Size(min=2,max=20,message="OrgName should have atleast 2 chars")
	private String orgName;
	private String orgLoc;

}
