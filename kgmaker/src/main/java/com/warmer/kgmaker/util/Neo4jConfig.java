package com.warmer.kgmaker.util;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Neo4jConfig {
	@Value("${spring.neo4j.url}")
	private String url = "bolt://127.0.0.1:7687";

	@Value("${spring.neo4j.username}")
	private String username = "neo4j";

	@Value("${spring.neo4j.password}")
	private String password = "123456";

	/**
	 * 图数据库驱动模式
	 *
	 * @return
	 */

	@Bean
	public Driver neo4jDriver() {
		return GraphDatabase.driver(url, AuthTokens.basic(username, password));
	}

}