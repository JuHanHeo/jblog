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
public class AdminService {
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	PostDao postDao;
	
	@Autowired
	BlogDao blogDao;
	

	public List<CategoryVo> getAdminCList(int userNo) {
		return categoryDao.getAdminList(userNo);
	}

	public boolean insertPost(PostVo postVo, String category, int no) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", postVo.getTitle());
		map.put("content", postVo.getContent());
		map.put("category", category);
		map.put("no", no);
		return postDao.insert(map);
		
	}

	public boolean updateBlog(BlogVo vo) {
		return blogDao.updateBlog(vo);
	}

	public BlogVo getBlog(int no) {
		return blogDao.getBlog(no);
	}

	public boolean insertCate(CategoryVo categoryVo) {
		return categoryDao.insertCate(categoryVo);
		
	}

	public List<PostVo> getGroupCount() {
		return postDao.groupCount();
	}
	
	
}
