package com.lucene.search.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lucene.search.Utils.PowerbiUtils;

@Service
public class PowerBiService {
	
	@Autowired
	private Environment env;
	
	public String getAccessToken() {
		return PowerbiUtils.getPowerBiAccessToken();
	}
	
	public String getEmbedToken(String accessToken){
		return PowerbiUtils.getEmbedToken(accessToken);
	}

}
