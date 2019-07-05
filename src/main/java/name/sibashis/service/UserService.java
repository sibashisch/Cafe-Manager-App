package name.sibashis.service;

import java.util.List;

import name.sibashis.entity.UserEntity;

public interface UserService {
	public void addUser (UserEntity userEntity);
	public void editUser (UserEntity userEntity);
	public void deleteUser (int userID);
	public UserEntity getUser (int userID);
	public List <UserEntity> getAllUsers ();
}
