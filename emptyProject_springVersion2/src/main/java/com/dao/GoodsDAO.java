package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Goods;
@Repository
public class GoodsDAO {	
	@Autowired
	SqlSessionTemplate template ;
	
	//모두보기 
	public List<Goods> GoodsList(){
		List<Goods> list = 
					template.selectList("GoodsMapper.goodsList"); 
		return list ; 
	}
	
}
