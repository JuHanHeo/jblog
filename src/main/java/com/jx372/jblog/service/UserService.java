package com.jx372.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx372.jblog.repository.BlogDao;
import com.jx372.jblog.repository.CategoryDao;
import com.jx372.jblog.repository.UserDao;
import com.jx372.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	BlogDao blogDao;
	@Autowired
	CategoryDao categoryDao;
	
	public boolean insert(UserVo userVo) {
		if(userDao.insert(userVo)){
			if(blogDao.insert()){
				return categoryDao.init();
			}
		}
		 return false;
	}

	public UserVo getUser(UserVo logVo) {
		return userDao.getUser(logVo);
	}

}
