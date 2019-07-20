package in.dbs.hack2hire.pharmacyapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "TBL_STATUS")
public class TblStatus {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "ID")
    private Long id;

    @Column (name = "NAME")
    private String name;
}
