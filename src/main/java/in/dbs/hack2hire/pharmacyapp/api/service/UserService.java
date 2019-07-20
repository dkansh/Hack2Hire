package in.dbs.hack2hire.pharmacyapp.api.service;

import java.util.List;

import in.dbs.hack2hire.pharmacyapp.vo.UserVO;

public interface UserService {
	public UserVO getUser(String userId);

	public UserVO saveUser(UserVO userVO);

	public List<UserVO> getAllUsers();
}
