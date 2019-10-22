package com.lucene.search.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucene.search.Service.ClientService;

@RestController
@RequestMapping("/restApi")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/getClient" , method = RequestMethod.GET)
	public String getSearchSugesstions() {
		return clientService.getClientInfo();
	}
	

}
