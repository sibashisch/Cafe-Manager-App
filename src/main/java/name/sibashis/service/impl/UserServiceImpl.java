package name.sibashis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import name.sibashis.dao.UserDao;
import name.sibashis.entity.UserEntity;
import name.sibashis.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Transactional
	public List<UserEntity> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Transactional
	public void addUser(UserEntity userEntity) {
		userDao.addUser(userEntity);
	}

	@Transactional
	public void editUser(UserEntity userEntity) {
		userDao.editUser (userEntity);
	}

	@Transactional
	public void deleteUser(int userID) {
		userDao.deleteUser(userID);
	}

	@Transactional
	public UserEntity getUser(int userID) {
		return userDao.getUser(userID);
	}

}
