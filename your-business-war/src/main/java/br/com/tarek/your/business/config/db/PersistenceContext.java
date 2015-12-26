package br.com.tarek.your.business.config.db;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;

/**
 * Created by tarek on 24/12/15.
 */
@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories("br.com.tarek.your.business.repositories")
@ComponentScan("br.com.tarek.your.business.models")
@PropertySource("classpath:/database.properties")
public class PersistenceContext extends Neo4jConfiguration {

  @Inject
  private Environment env;

  @Override
  public SessionFactory getSessionFactory() {
    return new SessionFactory("br.com.tarek.your.business.models");
  }

  @Override
  @Bean
  public Neo4jServer neo4jServer() {
    return new RemoteServer(env.getProperty("neo4j.url"));
  }
}
