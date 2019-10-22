package com.lucene.search.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucene.search.Service.FunService;

@RestController
@RequestMapping("/restApi")
public class FunController {

	@Autowired
	private FunService funService;
	
	@RequestMapping(value = "/getClientFun" , method = RequestMethod.GET)
	public String getSearchSugesstions() {
		return funService.doFun();
	}
	

}
