package in.dbs.hack2hire.pharmacyapp.api.dao;

import java.util.List;

import in.dbs.hack2hire.pharmacyapp.entity.UserEntity;

public interface UserDAO {
	public UserEntity getUser(String userName);

	public UserEntity saveUser(UserEntity userVO);

	public List<UserEntity> getAllUsers();
}
