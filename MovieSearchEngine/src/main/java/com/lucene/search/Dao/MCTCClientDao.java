package com.lucene.search.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class MCTCClientDao extends ClientDao{
  
	public String getInfo(){
		return "MCTC Client";
	}
}
