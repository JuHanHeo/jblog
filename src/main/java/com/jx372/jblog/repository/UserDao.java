package com.jx372.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.jblog.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlsession;
	public boolean insert(UserVo userVo) {
		// TODO Auto-generated method stub
		int count = sqlsession.insert("user.insert", userVo);
		return (count==1);
	}
	public UserVo getUser(UserVo logVo) {
		return sqlsession.selectOne("user.getUser", logVo);
	}

}
