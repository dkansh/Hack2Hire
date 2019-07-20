package in.dbs.hack2hire.pharmacyapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import in.dbs.hack2hire.pharmacyapp.vo.AddressVO;

@Data
@NoArgsConstructor
@Entity
@Table (name = "TBL_ADDRESS")
public class TblAddress {
    @Id
    @Column(name = "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "USER_ID")
    private Long userId;

    @Column (name = "DEFAULT_ADDR", columnDefinition = "tinyint default 0")
    private Boolean defaultAddress;

    @Column (name = "ADDRESS_LINE1")
    private String addressLine1;

    @Column (name = "ADDRESS_LINE2")
    private String addressLine2;

    @Column (name = "ADDRESS_LINE3")
    private String addressLine3;

    @Column (name = "CITY")
    private String city;

    @Column (name = "STATE")
    private String state;

    @Column (name = "COUNTRY")
    private String country;

    @Column (name = "ZIPCODE")
    private String zipcode;

    @Column (name = "LANDMARK")
    private String landmark;

    @Column (name = "LATITUDE", columnDefinition="Decimal(10,8) default NULL")
    private Double latitude;

    @Column (name = "LANGITUDE", columnDefinition="Decimal(10,8) default NULL")
    private Double longitude;
    
    public TblAddress(AddressVO addressVO) {
    	this.id = addressVO.getId();
    	this.userId = addressVO.getUserId();
		this.defaultAddress = addressVO.getDefaultAddress();
		this.addressLine1 = addressVO.getAddressLine1();
		this.addressLine2 = addressVO.getAddressLine2();
		this.addressLine3 = addressVO.getAddressLine3();
		this.city = addressVO.getCity();
		this.state = addressVO.getState();
		this.country = addressVO.getCountry();
		this.zipcode = addressVO.getZipcode();
		this.landmark = addressVO.getLandmark();
		this.latitude = addressVO.getLatitude();
		this.longitude = addressVO.getLongitude();
    }
}
