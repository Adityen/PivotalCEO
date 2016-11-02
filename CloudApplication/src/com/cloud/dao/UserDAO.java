package com.cloud.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cloud.domain.Credentials;
import com.cloud.domain.User;

public class UserDAO {
//	HibernateTemplate template;
	SessionFactory sessionFactory;
	
//	public void setTemplate(HibernateTemplate template) {
//		this.template = template;
//	}

	public void setSessionFactory(SessionFactory sesFactory){
		this.sessionFactory = sesFactory;
	}

	public Object findUser(String userName, String password) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Credentials.class);
		criteria.add(Restrictions.eq("userId", userName));
		criteria.add(Restrictions.eq("password", password));
		return criteria.list();
	}
}
