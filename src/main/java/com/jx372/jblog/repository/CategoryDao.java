package com.jx372.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {
	@Autowired
	SqlSession sqlsession;
	
	public List<CategoryVo> getList(String userId) {
		return sqlsession.selectList("category.getList", userId);
	}
	
	public List<CategoryVo> getAdminList(int userNo){
		return sqlsession.selectList("category.getAdminList", userNo);
	}
	public boolean init(){
		int count =	sqlsession.insert("category.init");
		return (count==1);
	}

	public boolean insertCate(CategoryVo categoryVo) {
		int count = sqlsession.insert("category.insert", categoryVo);
		return false;
	}

}
