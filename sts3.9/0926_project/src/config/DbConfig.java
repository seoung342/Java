package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3307/spring5db2?useSSL=false&allowPublicKeyRetrieval=true");
		ds.setUsername("root");
		ds.setPassword("mysql");
//		ds.setInitialSize(2);
//		ds.setMaxActive(10);
//		ds.setTestWhileIdle(true);
//		ds.setMinEvictableIdleTimeMillis(60000 * 3);
//		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}
}