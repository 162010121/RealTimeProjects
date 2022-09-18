package com.thoghti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoghti.repository.OrderEntityRepository;
import com.thoghti.repository.entity.OrderEntity;
import com.thoghti.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderEntityRepository repository;

	@Override
	public List<OrderEntity> insertOrders(List<OrderEntity> orders) {
		return repository.saveAll(orders);
		
	}

	@Override
	public OrderEntity getOrder(Integer orderId) {
		// TODO Auto-generated method stub
		return repository.findById(orderId).get();
	}

	@Override
	public List<OrderEntity> getOrders() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}
