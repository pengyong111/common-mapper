package com.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcast.mapper.BaseDictMapper;
import com.itcast.pojo.BaseDict;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class BaseDictService {

	
	@Autowired
	private BaseDictMapper dictMapper;
	
	
	public List<BaseDict> getBaseDicByTypeCode(String typeCode){
		
		Example example = new Example(BaseDict.class);
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEqualTo("dict_type_code", typeCode);
		return dictMapper.selectByExample(example);
		
	}
}
