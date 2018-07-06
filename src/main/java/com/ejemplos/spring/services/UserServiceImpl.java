package com.ejemplos.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.dao.UserDAO;
import com.ejemplos.spring.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	/*
	public UserServiceImpl(){
		
	}
	
	public UserServiceImpl(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
	*/


	@Override
	public List<User> list() {
    	System.out.println("class = UserServiceImpl  -- Transactional --  method = list -- inicio");
    	System.out.println("class = UserServiceImpl  -- Transactional --  method = list -- fin llamando userDao.list");

		return userDAO.list();
	}

	@Override
	public User get(int id) {
    	System.out.println("class = UserServiceImpl  -- Transactional --  method = get -- inicio");
    	System.out.println("class = UserServiceImpl  -- Transactional --  method = get -- fin llamando userDao.get");
		return userDAO.get(id);
	}

	@Override
	public void saveOrUpdate(User user) {
    	System.out.println("class = UserServiceImpl  -- Transactional --  method = saveOrUpdate -- inicio");
		userDAO.saveOrUpdate(user);
    	System.out.println("class = UserServiceImpl  -- Transactional --  method = saveOrUpdate -- fin ");

	}

	@Override
	public void delete(int id) {
    	System.out.println("class = UserServiceImpl  -- Transactional --  method = delete -- inicio");
		userDAO.delete(id);
    	System.out.println("class = UserServiceImpl  -- Transactional --  method = delete -- fin");

	}

}
