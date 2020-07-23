package com.panicbuyinglk.springmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panicbuyinglk.springmvc.pojo.ProductData;


@Controller
public class ProductController {

	@RequestMapping(value = "/registerProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean registerProduct(@RequestBody ProductData prdData) {
		
		
		return true;
	}
}
