package com.akhm.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akhm.repository.entity.PropertyEntity;


@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Integer> {
	
	
	public List<PropertyEntity> findAllByPropertyCreatedBy(Integer propertyCreatedBy);
	
	@Query(value="select * from property_tl",nativeQuery = true)
	public List<PropertyEntity> findAll();	
	
	

}
