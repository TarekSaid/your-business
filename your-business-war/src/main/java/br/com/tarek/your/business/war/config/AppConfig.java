package br.com.tarek.your.business.war.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by tarek on 07/12/15.
 */
@Configuration
@ComponentScan( "br.com.tarek.your.business" )
@Import({ WebappConfig.class })
public class AppConfig {
}
