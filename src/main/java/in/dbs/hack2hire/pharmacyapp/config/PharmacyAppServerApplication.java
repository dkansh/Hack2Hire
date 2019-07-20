package in.dbs.hack2hire.pharmacyapp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EntityScan("in.dbs.hack2hire.pharmacyapp.entity")
@EnableJpaRepositories("in.dbs.hack2hire.pharmacyapp.repository")
@SpringBootApplication(scanBasePackages={"in.dbs.hack2hire.pharmacyapp"})
public class PharmacyAppServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyAppServerApplication.class, args);
	}
}
