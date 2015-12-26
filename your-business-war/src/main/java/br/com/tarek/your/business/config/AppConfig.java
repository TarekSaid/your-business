package br.com.tarek.your.business.config;

import br.com.tarek.your.business.config.db.PersistenceContext;
import br.com.tarek.your.business.config.web.WebappConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by tarek on 07/12/15.
 */
@Configuration
@ComponentScan("br.com.tarek.your.business")
@Import({WebappConfig.class, PersistenceContext.class})
public class AppConfig {
}
