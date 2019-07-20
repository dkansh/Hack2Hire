package in.dbs.hack2hire.pharmacyapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import in.dbs.hack2hire.pharmacyapp.vo.RetailInfoVO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TBL_RETAIL_INFO")
@SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ")
public class RetailInfoEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private Long id;

	@Column(name = "STORE_NAME")
	private String storeName;

	@Column(name = "LICENSE_NUMBER")
	private String licenseNumber;
	
	@Column(name = "USER_ID")
    private Long userId;

	public RetailInfoEntity(RetailInfoVO retailInfoVO) {
		if (retailInfoVO != null) {
			this.id = retailInfoVO.getId();
			this.userId = retailInfoVO.getUserId();
			this.storeName = retailInfoVO.getStoreName();
			this.licenseNumber = retailInfoVO.getLicenseNumber();
		}
	}
}
