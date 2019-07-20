package in.dbs.hack2hire.pharmacyapp.impl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.dbs.hack2hire.pharmacyapp.api.dao.UserDAO;
import in.dbs.hack2hire.pharmacyapp.entity.UserEntity;
import in.dbs.hack2hire.pharmacyapp.repository.UserRepository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity getUser(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		return userRepository.saveAndFlush(userEntity);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}
}
