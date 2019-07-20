package in.dbs.hack2hire.pharmacyapp.vo;

import in.dbs.hack2hire.pharmacyapp.entity.RetailInfoEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RetailInfoVO {
	private Long id;
	private Long userId;
	private String storeName;
	private String licenseNumber;

	public RetailInfoVO(RetailInfoEntity retailInfoEntity) {
		this.id = retailInfoEntity.getId();
		this.userId = retailInfoEntity.getUserId();
		this.storeName = retailInfoEntity.getStoreName();
		this.licenseNumber = retailInfoEntity.getLicenseNumber();
	}
}
