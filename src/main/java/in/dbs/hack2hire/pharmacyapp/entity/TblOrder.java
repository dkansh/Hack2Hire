package in.dbs.hack2hire.pharmacyapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "TBL_ORDER")
public class TblOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "CUSTOMER")
    private UserEntity customer;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "STATUS")
    private TblStatus status;
}
