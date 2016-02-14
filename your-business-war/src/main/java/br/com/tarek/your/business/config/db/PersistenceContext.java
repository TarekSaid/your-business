package br.com.tarek.your.business.config.db;

import br.com.tarek.your.business.models.Business;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.event.BeforeSaveEvent;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.security.crypto.password.PasswordEncoder;
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

  @Inject
  private PasswordEncoder passwordEncoder;

  @Override
  public SessionFactory getSessionFactory() {
    return new SessionFactory("br.com.tarek.your.business.models");
  }

  @Override
  @Bean
  public Neo4jServer neo4jServer() {
    return new RemoteServer(env.getProperty("neo4j.url"));
  }

  @Bean
  ApplicationListener<BeforeSaveEvent> beforeSaveEventApplicationListener() {
    return new ApplicationListener<BeforeSaveEvent>() {
      @Override
      public void onApplicationEvent(BeforeSaveEvent event) {
        Business entity = (Business) event.getEntity();
        String email = entity.getEmail();
        entity.setEmail(email.toLowerCase());
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
      }
    };
  }
}
