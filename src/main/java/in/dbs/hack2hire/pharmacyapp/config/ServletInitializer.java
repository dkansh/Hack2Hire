package in.dbs.hack2hire.pharmacyapp.config;

import in.dbs.hack2hire.pharmacyapp.PharmacyAppServerApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PharmacyAppServerApplication.class);
	}

}
