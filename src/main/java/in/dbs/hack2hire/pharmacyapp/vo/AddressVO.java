package in.dbs.hack2hire.pharmacyapp.vo;

import in.dbs.hack2hire.pharmacyapp.entity.TblAddress;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressVO {
	private Long id;
	private Long userId;
	private Boolean defaultAddress;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String landmark;
	private Double latitude;
	private Double longitude;

	public AddressVO(TblAddress address) {
		this.id = address.getId();
		this.userId = address.getUserId();
		this.defaultAddress = address.getDefaultAddress();
		this.addressLine1 = address.getAddressLine1();
		this.addressLine2 = address.getAddressLine2();
		this.addressLine3 = address.getAddressLine3();
		this.city = address.getCity();
		this.state = address.getState();
		this.country = address.getCountry();
		this.zipcode = address.getZipcode();
		this.landmark = address.getLandmark();
		this.latitude = address.getLatitude();
		this.longitude = address.getLongitude();
	}
}
