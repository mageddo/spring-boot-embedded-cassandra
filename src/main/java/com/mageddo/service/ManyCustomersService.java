package com.mageddo.service;

import com.mageddo.entity.CustomerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
* @author elvis
* @version $Revision: $<br/>
*          $Id: $
* @since 8/26/16 12:18 PM
*/
@Service
public class ManyCustomersService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManyCustomersService.class);

	@Inject
	private CustomerService customerService;


	@Transactional
	public void createCustomers(List<CustomerEntity> customerEntities){
			for(CustomerEntity customerEntity: customerEntities){
					customerService.createCustomer(customerEntity);
			}
	}

	@Transactional
	public void createCustomersWithoutFail(List<CustomerEntity> customerEntities){
			for(CustomerEntity customerEntity: customerEntities){
					try {
							customerService.createCustomerWithoutFail(customerEntity);
					}catch (final DuplicateKeyException e){
							LOGGER.warn("status=duplicated, name={}, msg={}", customerEntity.getFirstName(), e.getMessage(), e);
					}
			}
	}
}
