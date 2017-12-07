package com.itcast.mapper;

import java.util.List;

import com.itcast.pojo.BaseDict;
import com.itcast.pojo.Customer;
import com.itcast.pojo.QueryVo;
import com.itcast.util.MyMapper;

public interface BaseDictMapper extends MyMapper<BaseDict> {

	
	List<Customer> findCustomerBys(QueryVo queryVo);
	int getCustomerListCount(QueryVo queryVo);
}
