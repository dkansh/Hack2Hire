package in.dbs.hack2hire.pharmacyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.dbs.hack2hire.pharmacyapp.entity.RetailInfoEntity;

public interface RetailInfoRepository extends JpaRepository<RetailInfoEntity, Long> {

	public RetailInfoEntity findByUserId(Long userId);
}
