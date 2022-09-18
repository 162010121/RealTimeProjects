package com.akhm.service;

import java.util.List;

import com.akhm.service.dto.PropertyDTO;

public interface PropertiesService 
{
	
	public PropertyDTO saveProperty(PropertyDTO propertyDTO);
	
	public List<PropertyDTO> getProperties(Integer userId);
	
	public PropertyDTO getProperty(Integer propertyId);
	
	public void updateProperty(PropertyDTO propertyDTO );
	
	public void deleteProperty(Integer propertyId);
	
	
	

}
