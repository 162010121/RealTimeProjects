package com.akhm.command;



import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class PropertyCommand {
	
	@Id
	private Integer propertyId;
	private String propertytype;
	private String housenumber;
	private String address;
	private String state;
	private String city;
	private String pincode;

}
