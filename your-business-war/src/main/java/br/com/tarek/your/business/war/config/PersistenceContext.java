package br.com.tarek.your.business.war.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by tarek on 24/12/15.
 */
@Configuration
@EnableNeo4jRepositories("br.com.tarek.your.business.war.repositories")
@EnableTransactionManagement
@ComponentScan("br.com.tarek.your.business.war.models")
public class PersistenceContext extends Neo4jConfiguration {

  @Override
  public SessionFactory getSessionFactory() {
    return null;
  }

  @Override
  @Bean
  public Neo4jServer neo4jServer() {
    return null;
  }
}
