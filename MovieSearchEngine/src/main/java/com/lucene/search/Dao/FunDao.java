package com.lucene.search.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class FunDao extends BaseDao{
  
	public String getFun(){
		return "S4 is doing fun";
	}
} 
