package name.sibashis.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import name.sibashis.dao.UserDao;
import name.sibashis.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getAllUsers() {
		return session.getCurrentSession().createQuery("from UserEntity").list();
	}

	@Override
	public void addUser(UserEntity userEntity) {
		session.getCurrentSession().save(userEntity);
	}

	@Override
	public void editUser(UserEntity userEntity) {
		session.getCurrentSession().update(userEntity);
	}

	@Override
	public void deleteUser(int userID) {
		session.getCurrentSession().delete(getUser(userID));
	}

	@Override
	public UserEntity getUser(int userID) {
		return (UserEntity)session.getCurrentSession().get(UserEntity.class, userID);
	}

}
