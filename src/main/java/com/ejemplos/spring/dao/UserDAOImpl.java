package com.ejemplos.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplos.spring.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl() {
		
	}
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<User> list() {
    	System.out.println("class = UserDAOImpl  -- Transactional --  method = list -- inicio");
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    	System.out.println("class = UserDAOImpl  -- Transactional --  method = list -- fin");

		return listUser;
	}

	@Override
	@Transactional
	public void saveOrUpdate(User user) {
    	System.out.println("class = UserDAOImpl  -- Transactional --  method = saveOrUpdate -- inicio");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
    	System.out.println("class = UserDAOImpl  -- Transactional --  method = saveOrUpdate -- fin");
	}

	@Override
	@Transactional
	public void delete(int id) {
    	System.out.println("class = UserDAOImpl  -- Transactional --  method = delete -- inicio");
		User userToDelete = new User();
		userToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
    	System.out.println("class = UserDAOImpl  -- Transactional --  method = delete -- fin");
	}

	@Override
	@Transactional
	public User get(int id) {
    	System.out.println("class = UserDAOImpl  -- Transactional --  method = get -- inicio");
		String hql = "from User where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
    	System.out.println("class = UserDAOImpl  -- Transactional --  method = get -- fin");
		
		return null;
	}
}