package in.dbs.hack2hire.pharmacyapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import in.dbs.hack2hire.pharmacyapp.vo.UserRoleVO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TBL_USER_ROLE")
@SequenceGenerator(name="user_role_seq", sequenceName = "USER_ROLE_SEQ")
public class UserRoleEntity {
	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_seq")
	private Integer roleId;
	
	@Column(name = "ROLE_NAME")
	private String roleName;
	
	public UserRoleEntity(UserRoleVO roleVO) {
		this.roleId = roleVO.getRoleId();
		this.roleName = roleVO.getRoleName();
	}
}
