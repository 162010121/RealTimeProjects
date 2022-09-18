package com.akhm.service.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class PropertyDTO {
	
	private Integer propertyId;
	private String propertyType;
	private String houseNumber;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private Integer propertyCreatedBy;
	private Date createdOn;
	private String status;
	

}
