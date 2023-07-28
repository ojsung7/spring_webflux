package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
public class DBConfig extends AbstractR2dbcConfiguration{
	@Override
	public ConnectionFactory connectionFactory() {
		return ConnectionFactories.get("r2dbc:postgres://localhost:5432/test");
	}
	
	@Bean
	public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
		var initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		var databasePopulator = new CompositeDatabasePopulator();
		databasePopulator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
		databasePopulator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));
		initializer.setDatabasePopulator(databasePopulator);
		return initializer;
	}
}
