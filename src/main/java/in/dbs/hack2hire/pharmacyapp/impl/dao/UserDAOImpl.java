package in.dbs.hack2hire.pharmacyapp.impl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.dbs.hack2hire.pharmacyapp.api.dao.UserDAO;
import in.dbs.hack2hire.pharmacyapp.entity.RetailInfoEntity;
import in.dbs.hack2hire.pharmacyapp.entity.TblAddress;
import in.dbs.hack2hire.pharmacyapp.entity.UserEntity;
import in.dbs.hack2hire.pharmacyapp.repository.AddressRepository;
import in.dbs.hack2hire.pharmacyapp.repository.RetailInfoRepository;
import in.dbs.hack2hire.pharmacyapp.repository.UserRepository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private RetailInfoRepository retailInfoRepository;

	@Override
	public UserEntity getUser(String mobileNumber) {
		return userRepository.findByMobileNumber(mobileNumber);
	}

	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		return userRepository.saveAndFlush(userEntity);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public TblAddress saveAddress(TblAddress tblAddress) {
		return addressRepository.saveAndFlush(tblAddress);
	}

	@Override
	public RetailInfoEntity saveRetailInfo(RetailInfoEntity retailInfoEntity) {
		return retailInfoRepository.saveAndFlush(retailInfoEntity);
	}

	@Override
	public TblAddress getAddress(Long userId) {
		return addressRepository.findByUserId(userId);
	}

	@Override
	public RetailInfoEntity getRetailInfo(Long userId) {
		return retailInfoRepository.findByUserId(userId);
	}
}
