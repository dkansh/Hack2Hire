package in.dbs.hack2hire.pharmacyapp.impl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.dbs.hack2hire.pharmacyapp.api.dao.UserDAO;
import in.dbs.hack2hire.pharmacyapp.api.service.UserService;
import in.dbs.hack2hire.pharmacyapp.entity.RetailInfoEntity;
import in.dbs.hack2hire.pharmacyapp.entity.TblAddress;
import in.dbs.hack2hire.pharmacyapp.entity.UserEntity;
import in.dbs.hack2hire.pharmacyapp.vo.AddressVO;
import in.dbs.hack2hire.pharmacyapp.vo.RetailInfoVO;
import in.dbs.hack2hire.pharmacyapp.vo.UserRoleVO;
import in.dbs.hack2hire.pharmacyapp.vo.UserVO;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
    private JavaMailSender javaMailSender;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserVO userVO = getUser(userName);
		if (userVO == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new User(userVO.getMobileNumber(), userVO.getPassword(), getAuthority(userVO.getUserRoles()));
	}

	private List<SimpleGrantedAuthority> getAuthority(List<UserRoleVO> userRoles) {
		return userRoles.stream().map(UserRoleVO::getRoleName).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public UserVO getUser(String userName) {
		UserEntity userEntity = userDAO.getUser(userName);
		TblAddress address = userDAO.getAddress(userEntity.getUserId());
		RetailInfoEntity retailInfoEntity = userDAO.getRetailInfo(userEntity.getUserId());
		UserVO responce = new UserVO(userEntity);
		responce.setAddressVO(new AddressVO(address));
		responce.setRetailInfoVO(new RetailInfoVO(retailInfoEntity));
		return responce;
	}

	@Override
	public UserVO saveUser(UserVO userVO) {
		sendMail(userVO.getEmaild());
		UserEntity userEntity = userDAO.saveUser(new UserEntity(userVO));
		userVO.getAddressVO().setUserId(userEntity.getUserId());
		TblAddress address = userDAO.saveAddress(new TblAddress(userVO.getAddressVO()));
		userVO.getRetailInfoVO().setUserId(userEntity.getUserId());
		RetailInfoEntity retailInfoEntity = userDAO.saveRetailInfo(new RetailInfoEntity(userVO.getRetailInfoVO()));
		UserVO responce = new UserVO(userEntity);
		responce.setAddressVO(new AddressVO(address));
		responce.setRetailInfoVO(new RetailInfoVO(retailInfoEntity));
		return responce;
	}

	@Override
	public List<UserVO> getAllUsers() {
		List<UserVO> userVOs = new ArrayList<UserVO>();
		for (UserEntity userEntity : userDAO.getAllUsers()) {
			userVOs.add(new UserVO(userEntity));
		}
		return userVOs;
	}
	
	private void sendMail(String mailId) {
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailId);

        msg.setSubject("DBS Pharmacy App User Validation");
        msg.setText("Dear User, \n Please use OTP " + OTP(6) + " to validate your account!");
        
        javaMailSender.send(msg);
	}
	
	private String OTP(int len) {
		String numbers = "0123456789";
		Random rndm_method = new Random();

		char[] otp = new char[len];

		for (int i = 0; i < len; i++) {
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return String.valueOf(otp);
	}
}
