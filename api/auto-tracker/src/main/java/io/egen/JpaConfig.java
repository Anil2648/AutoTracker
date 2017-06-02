package io.egen;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
//@PropertySource(value = "classpath:application.properties")
public class JpaConfig {

//    @Autowired
//    private Environment env;

	@Bean  
	public LocalContainerEntityManagerFactoryBean emf() {
		
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("io.egen.entity");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setJpaProperties(jpaProperties());
		return emf;
		
	}

    @Bean
    public DataSource dataSource() {
    	DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/vehicle_db?autoReconnect=true&useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
    }

    @Bean
    public PlatformTransactionManager txnManager(EntityManagerFactory emf) {
        JpaTransactionManager txnMgr = new JpaTransactionManager(emf);
        return txnMgr;
    }
    
    private Properties jpaProperties() {
    	Properties props = new Properties();
		props.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
        return props;
    }
}
