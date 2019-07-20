package in.dbs.hack2hire.pharmacyapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import in.dbs.hack2hire.pharmacyapp.vo.UserRoleVO;
import in.dbs.hack2hire.pharmacyapp.vo.UserVO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TBL_USER_INFO")
@SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ")
public class UserEntity {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private Long userId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;

	@Column(name = "EMAIL_ID")
	private String emaild;

	@Column(name = "PASSWORD")
	private String password;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "TBL_USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<UserRoleEntity> userRoles;

	public UserEntity(UserVO userVO) {
		if (userVO != null) {
			this.userId = userVO.getUserId();
			this.firstName = userVO.getFirstName();
			this.lastName = userVO.getLastName();
			this.mobileNumber = userVO.getMobileNumber();
			this.emaild = userVO.getEmaild();
			this.password = new BCryptPasswordEncoder().encode(userVO.getPassword());

			if (userVO.getUserRoles() != null && userVO.getUserRoles().size() > 0) {
				this.userRoles = new HashSet<UserRoleEntity>();
				for (UserRoleVO roleVO : userVO.getUserRoles()) {
					this.userRoles.add(new UserRoleEntity(roleVO));
				}
			}
		}
	}

}
