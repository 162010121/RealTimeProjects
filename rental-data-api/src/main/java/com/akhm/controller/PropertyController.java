package com.akhm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akhm.repository.entity.PropertyEntity;
import com.akhm.service.PropertyService;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	@PostMapping("/insertproperty")
	public ResponseEntity<PropertyEntity> insertProperty(@RequestBody PropertyEntity propertyEntity)
	{
		log.info("in PropertyController...insert() methos started");
		try {
			
				PropertyEntity entity=propertyService.insertProperty(propertyEntity);
				log.info("in PropertyControll...rigester method() details are succefully rigester");
				return new ResponseEntity<>(entity, HttpStatus.OK);
			
		} catch (Exception e) {

			
			log.error("In PropertyController rigester() method erro accured-{}",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping("/properties")
	public ResponseEntity<List<PropertyEntity>> getProperties(@RequestParam Integer userId )
	{
		
		log.info("in PropertyController....getProperties method() started");
		try {
				List<PropertyEntity> properties=propertyService.getProperties(userId);
				return new ResponseEntity<>(properties,HttpStatus.OK);
				
		
		} catch (Exception e) {
			log.error("in PropertyController getProperties()method erroraccured-{}",e);
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		
	}
	@GetMapping("/property/{propertyId}")
	public ResponseEntity<PropertyEntity> getProperty(@PathVariable ("propertyId") Integer propertyId)
	{
		log.info("in UserController... login()method started");
		try 
		{
			
			PropertyEntity entity=propertyService.getProperty(propertyId);
			log.info("in UserController... login() method user details are succesesfully rigestored");
			return new ResponseEntity<>(entity,HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			log.error("in PropertyController login()method erroraccured-{}",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/updateproperty")
	public ResponseEntity<Void> updateProperty(@RequestBody PropertyEntity propertyEntity)
	
	{
		log.info("in propertyentity...updateproperty() method stated ");
		
		try {
			
			propertyService.updateProperty(propertyEntity);
			log.error("in propertycontroller...updateproperty() method user details are succesesfully rigestored");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			
			log.error("in PropertyController updateproperty()method erroraccured-{}",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	@GetMapping("/deleteproperty/{propertyId}")
	public ResponseEntity<Void> deleteProperty(@PathVariable ("propertyId") Integer propertyId)
	{
		log.info("in propertyentity...deleteproperty() method stated ");
		try {
			
			propertyService.deleteProperty(propertyId);
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/downloadCSV")
	public ResponseEntity<Void> downloadCSV()
	{
		
		try {
			
			propertyService.listToCSV();
			return new ResponseEntity<>(HttpStatus.OK);
			
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		
		
	}
	
	
	
	

}
