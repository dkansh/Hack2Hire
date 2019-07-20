package in.dbs.hack2hire.pharmacyapp.vo;

import in.dbs.hack2hire.pharmacyapp.entity.UserRoleEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRoleVO {
	private Integer roleId;
	private String roleName;

	public UserRoleVO(UserRoleEntity roleEntity) {
		this.roleId = roleEntity.getRoleId();
		this.roleName = roleEntity.getRoleName();
	}
}
