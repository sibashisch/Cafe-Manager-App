package name.sibashis.dao;

import name.sibashis.entity.UserEntity;
import java.util.List;

public interface UserDao {
	public void addUser (UserEntity userEntity);
	public void editUser (UserEntity userEntity);
	public void deleteUser (int userID);
	public UserEntity getUser (int userID);
	public List <UserEntity> getAllUsers ();
}
