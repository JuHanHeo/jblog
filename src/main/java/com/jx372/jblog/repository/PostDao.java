package com.jx372.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.jblog.vo.PostVo;

@Repository
public class PostDao {
	
	@Autowired
	SqlSession sqlsession;

	public boolean insert(Map<String, Object> map) {
		int count = sqlsession.insert("post.insert", map);
		return (count==1);
	}

	public List<PostVo> getList(Map map) {
		return sqlsession.selectList("post.getList", map);
	}
	public List<PostVo> getListByCate(Map map) {
		return sqlsession.selectList("post.getListByCate", map);
	} 

	public PostVo getPostByNo(int post) {
		return sqlsession.selectOne("post.getPostByNo", post);
	}

	public List<PostVo> groupCount() {
		return sqlsession.selectList("post.groupCount");
	}
	
	

}
