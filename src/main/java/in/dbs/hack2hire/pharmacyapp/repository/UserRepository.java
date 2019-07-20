package in.dbs.hack2hire.pharmacyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import in.dbs.hack2hire.pharmacyapp.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	public UserEntity findByUserName(@Param("userName") String userName);

}
