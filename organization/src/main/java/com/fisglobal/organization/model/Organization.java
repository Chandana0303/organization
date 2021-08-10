package com.fisglobal.organization.model;

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
	private String OrgId;
	@Size(min=2,max=15,message="OrgName shoud contain min 2 chars")
	private String OrgName;
	@Size(min=2,max=15,message="OrgLoc shoud contain min 2 chars")
	private String OrgLoc;
	
}
