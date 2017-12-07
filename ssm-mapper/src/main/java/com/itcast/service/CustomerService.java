package com.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcast.mapper.BaseDictMapper;
import com.itcast.pojo.Customer;
import com.itcast.pojo.QueryVo;
import com.itheima.boot.util.Page;

@Service
public class CustomerService {

	@Autowired
	private BaseDictMapper  baseDictMapper;
	
	
	public Page<Customer> findCustomerBy3geTiaoJian(QueryVo queryVo){
		if (queryVo.getPage() != null) {
			queryVo.setStart((queryVo.getPage() - 1) * queryVo.getSize());
		}
		
		List<Customer> customers =baseDictMapper.findCustomerBys(queryVo);
		
		Page<Customer> page = new Page<Customer>();
		
		page.setRows(customers);
		
		page.setSize(queryVo.getSize());
		
		page.setTotal(baseDictMapper.getCustomerListCount(queryVo));
		
		page.setPage(queryVo.getPage());
		
		return page;
		
	}
	
	
	
}
