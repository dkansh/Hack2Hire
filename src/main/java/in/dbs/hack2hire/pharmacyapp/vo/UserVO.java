package in.dbs.hack2hire.pharmacyapp.vo;

import java.util.ArrayList;
import java.util.List;

import in.dbs.hack2hire.pharmacyapp.entity.UserEntity;
import in.dbs.hack2hire.pharmacyapp.entity.UserRoleEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVO {
	private Long userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String emaild;
	private String password;
	private List<UserRoleVO> userRoles;
	private AddressVO addressVO;
	private RetailInfoVO retailInfoVO;

	public UserVO(UserEntity userEntity) {
		if (userEntity != null) {
			this.userId = userEntity.getUserId();
			this.firstName = userEntity.getFirstName();
			this.lastName = userEntity.getLastName();
			this.mobileNumber = userEntity.getMobileNumber();
			this.emaild = userEntity.getEmaild();
			this.password = userEntity.getPassword();

			if (userEntity.getUserRoles() != null && userEntity.getUserRoles().size() > 0) {
				this.userRoles = new ArrayList<UserRoleVO>();
				for (UserRoleEntity roleEntity : userEntity.getUserRoles()) {
					this.userRoles.add(new UserRoleVO(roleEntity));
				}
			}
		}
	}
}
