package com.akhm.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.exception.PropertyException;
import com.akhm.repository.PropertyRepository;
import com.akhm.repository.entity.PropertyEntity;
import com.akhm.service.PropertyService;
import com.opencsv.CSVWriter;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository repository;
	
	
	@Override
	public PropertyEntity insertProperty(PropertyEntity propertyEntity)
	{
		
		log.info("In propertyserviceimpl...insertProperty() method started");
		try {
			
			log.info("In propertyserviceimpl...insertProperty() method deatails are succefully register");
			PropertyEntity entity=repository.save(propertyEntity);
			return entity;
			
		} catch (Exception e) {
			
			log.info("In propertyserviceimpl...insertProperty() method error message accured-{} ",e);
			throw new PropertyException(e.getMessage());
			
		}
	}

	@Override
	public List<PropertyEntity> getProperties(Integer propertyCreatedBy) {
		
		log.info("In propertyserviceimpl...getProperties() method started");
		try {
			log.info("In propertyserviceimpl...getProperties() method deatails are succefully register");
				List<PropertyEntity> properties=repository.findAllByPropertyCreatedBy(propertyCreatedBy);
				return properties;
			
		} catch (Exception e) {
			log.info("In propertyserviceimpl...insertProperties() method error message accured-{} ",e);
			throw new PropertyException(e.getMessage());
		}
		
		
		
	}

	@Override
	public PropertyEntity getProperty(Integer propertyId) {
		log.info("In propertyserviceimpl...getProperty() method started");
		try {
			log.info("In propertyserviceimpl...getProperty() method deatails are succefully register");
			PropertyEntity entity=repository.findById(propertyId).get();
			return entity;
			
		} catch (Exception e) {
			
			log.info("In propertyserviceimpl...insertProperty() method error message accured-{} ",e);
			throw new PropertyException(e.getMessage());
		}
		
	}

	@Override
	public void updateProperty(PropertyEntity propertyEntity) {
	
		log.info("In propertyserviceimpl...updateProperty() method started");
		try {
			log.info("In propertyserviceimpl...updateProperty() details are register");
				repository.save(propertyEntity);
			
		} catch (Exception e) {
			log.info("In propertyserviceimpl...updateProperty() method error message accured-{}",e);
			
			throw new PropertyException(e.getMessage());
			
		}
	}

	@Override
	public void deleteProperty(Integer propertyId) {
		log.info("In propertyserviceimpl...deleteProperty() method started");
		try {
			log.info("In propertyserviceimpl...deleteteProperty() details are register");
			
			
			repository.deleteById(propertyId);
			
		} catch (Exception e) {
			
			log.info("In propertyserviceimpl...deleteProperty() details are register");
			
			throw new PropertyException(e.getMessage());
		}
		
	}

	@Override
	public void listToCSV() {
		
		try {
			
				List<PropertyEntity> properties=repository.findAll();
				if (properties !=null) {
					
					String[] columnsNames= {"propertyId","propertyType","houseNumber","address","city","state","pincode","propertyCreatedBy","createdOn","status"};
					CSVWriter csvWrite=new CSVWriter(new FileWriter(new File("C:\\testcsv\\Property.csv")));
					csvWrite.writeNext(columnsNames);
					for(PropertyEntity e:properties)
					{
						List<String> data=new ArrayList<String>();
						data.add(String.valueOf(e.getPropertyId()));
						data.add(e.getPropertyType());
						data.add(e.getHouseNumber());
						data.add(e.getAddress());
						data.add(e.getCity());
						data.add(e.getState());
						data.add(e.getPincode());
						//data.add(String.valueOf(e.getPropertyCreatedBy()));
						data.add(e.getStatus());
						csvWrite.writeNext(data.toArray(new String[0]));
						
					
					}
					csvWrite.close();
				}
			
		} catch (Exception e) {
			
			throw new PropertyException(e.getMessage());
		}
		
		
	}


	
	
}
