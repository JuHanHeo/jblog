package com.jx372.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx372.jblog.repository.BlogDao;
import com.jx372.jblog.repository.CategoryDao;
import com.jx372.jblog.repository.PostDao;
import com.jx372.jblog.vo.BlogVo;
import com.jx372.jblog.vo.CategoryVo;
import com.jx372.jblog.vo.PostVo;

@Service
public class BlogService {
	
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	BlogDao blogDao;
	
	@Autowired
	PostDao postDao;
	
	public List<CategoryVo> getCategory(String userId){
		List<CategoryVo> list = categoryDao.getList(userId);
		return list;
	}

	public BlogVo getBlog(String userId) {
		return blogDao.getBlogById(userId);
	}

	public List<PostVo> getPostList(String userId, String category) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("category", category);
		return postDao.getList(map);
	}

	public PostVo getPostByNo(int post) {
		return postDao.getPostByNo(post);
	}

	public List<PostVo> getPostByCate(String userId, String category) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("category", category);
		System.out.println(category);
		return postDao.getListByCate(map);
	}
}
