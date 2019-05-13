package edu.eci.arsw.evern.persistence;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDataBases {
	
	private static BasicDataSource dataSource= new BasicDataSource();
	
	static {
		dataSource.setUrl("jdbc:postgresql://ec2-23-23-173-30.compute-1.amazonaws.com/d802phqcue7pj9?sslmode=require&user=uozxbwcunhctpl&password=11b33551faf37a7d47d2335f60b57209dc621fb613d9470f23758bcd7c2bc5b2");
		dataSource.setUsername("uozxbwcunhctpl");
		dataSource.setPassword("11b33551faf37a7d47d2335f60b57209dc621fb613d9470f23758bcd7c2bc5b2");
		dataSource.setMinIdle(1);
		dataSource.setMaxIdle(5);
	}
	
	public BasicDataSource dataSource() {
		return dataSource;
	}		
}
