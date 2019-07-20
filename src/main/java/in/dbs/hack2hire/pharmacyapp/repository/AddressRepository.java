package in.dbs.hack2hire.pharmacyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import in.dbs.hack2hire.pharmacyapp.entity.TblAddress;

public interface AddressRepository extends JpaRepository<TblAddress, Long>{
	public TblAddress findByUserId(@Param("userId") Long userId);
}
