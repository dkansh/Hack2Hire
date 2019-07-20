package in.dbs.hack2hire.pharmacyapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "TBL_ADDRESS")
public class TblAddress {
    @Id
    @Column(name = "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "USER")
    private UserEntity user;

    @Column (name = "DEFAULT_ADDR", columnDefinition = "tinyint default 0")
    private boolean defaultAddress;

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
}
