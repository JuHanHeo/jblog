package com.jx372.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.jblog.vo.BlogVo;
import com.jx372.jblog.vo.PostVo;

@Repository
public class BlogDao {

	@Autowired
	SqlSession sqlSession;
	public boolean insert() {
		int cnt = sqlSession.insert("blog.insert");
		return (cnt==1);
	}
	public boolean updateBlog(BlogVo vo) {
		int cnt = sqlSession.insert("blog.update", vo);
		return (cnt==1);
	}
	public BlogVo getBlog(int no) {
		return sqlSession.selectOne("blog.get", no);
	}
	public BlogVo getBlogById(String userId) {
		return sqlSession.selectOne("blog.getById", userId);
	}

}
