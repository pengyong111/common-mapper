package com.itcast.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itcast.pojo.BaseDict;
import com.itcast.pojo.Customer;
import com.itcast.pojo.QueryVo;
import com.itcast.service.BaseDictService;
import com.itcast.service.CustomerService;
import com.itheima.boot.util.Page;


@Controller
public class PageController {

	@Autowired
	private BaseDictService baseService;
	
	@Autowired
	private CustomerService customerService;
	@Value("${customer.source.code}")
	private String custSorceCode;
	@Value("${customer.industory.code}")
	private String custIndustoryCode;
	@Value("${customer.level.code}")
	private String custLevelCode;
	
	
	
	@RequestMapping("/customer/list")
	public String index(QueryVo queryVo, Model model){
		List<BaseDict> custSourceList = baseService.getBaseDicByTypeCode(custSorceCode);
		List<BaseDict> custIndustoryList = baseService.getBaseDicByTypeCode(custIndustoryCode);
		List<BaseDict> custLevelList = baseService.getBaseDicByTypeCode(custLevelCode);
		model.addAttribute("fromType", custSourceList);
		model.addAttribute("industryType", custIndustoryList);
		model.addAttribute("levelType", custLevelList);
		
		
		
		Page<Customer> page =customerService.findCustomerBy3geTiaoJian(queryVo);
		model.addAttribute("page", page);
		
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustory());
		model.addAttribute("custLevel", queryVo.getCustLevel());
		model.addAttribute("custName", queryVo.getCustName());
		
		
		
		
		return "customer";
	}
	
	
	
	
	
	
}
