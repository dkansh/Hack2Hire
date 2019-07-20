package in.dbs.hack2hire.pharmacyapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@EnableTransactionManagement
@EntityScan("in.dbs.hack2hire.pharmacyapp.entity")
@EnableJpaRepositories("in.dbs.hack2hire.pharmacyapp.repository")
@SpringBootApplication
public class PharmacyAppServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyAppServerApplication.class, args);
		log.info("DBS Pharmacy Application has started...");
	}
}
