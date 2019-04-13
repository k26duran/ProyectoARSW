package edu.eci.arsw.evern.persistence;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Component
public class RepositoryDataBases {
	
	public static BasicDataSource basicDataSource = null;

	@Bean
	public static  BasicDataSource dataSource() throws URISyntaxException {
	        URI dbUri = new URI("postgres://uozxbwcunhctpl:11b33551faf37a7d47d2335f60b57209dc621fb613d9470f23758bcd7c2bc5b2@ec2-23-23-173-30.compute-1.amazonaws.com:5432/d802phqcue7pj9");
	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
	        basicDataSource = new BasicDataSource();
	        basicDataSource.setUrl(dbUrl);
 	        basicDataSource.setUsername(username);
 	        basicDataSource.setPassword(password);
 	        basicDataSource.setMaxIdle(5);
 	        basicDataSource.setMinIdle(3);
	        return basicDataSource;
	}
		
}
