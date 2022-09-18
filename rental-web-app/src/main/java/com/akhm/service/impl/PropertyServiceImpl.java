package com.akhm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhm.constant.CommanConstant;
import com.akhm.service.PropertiesService;
import com.akhm.service.dto.PropertyDTO;


@Service
public class PropertyServiceImpl  implements PropertiesService{

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
		
		ResponseEntity<PropertyDTO> response=restTemplate.postForEntity(CommanConstant.RENTAL_DATA_HOST_NAME+"insertproperty", propertyDTO,PropertyDTO.class);
		
		return response.getBody();
		
		
	}


	@Override
	public List<PropertyDTO> getProperties(Integer userId) {
		
		ResponseEntity<List> response=restTemplate.getForEntity(CommanConstant.RENTAL_DATA_HOST_NAME+"properties?userId="+userId,List.class);
		
		return response.getBody();
	}


	@Override
	public PropertyDTO getProperty(Integer propertyId) {
		ResponseEntity<PropertyDTO> response=restTemplate.getForEntity(CommanConstant.RENTAL_DATA_HOST_NAME+"property/"+propertyId,PropertyDTO.class);
		return response.getBody();
	}


	@Override
	public void updateProperty(PropertyDTO propertyDTO) {
		
		
		ResponseEntity<Void> response=restTemplate.postForEntity(CommanConstant.RENTAL_DATA_HOST_NAME+"updateproperty", propertyDTO, Void.class);
		
	}


	@Override
	public void deleteProperty(Integer propertyId) {
		
		ResponseEntity<Void> response=restTemplate.getForEntity(CommanConstant.RENTAL_DATA_HOST_NAME+"deleteproperty/"+propertyId, Void.class);
		
	}
	
	

}
