package br.com.tarek.your.business.config.security;

import br.com.tarek.your.business.services.impl.AuthenticationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Inject;

/**
 * Created by tarek on 24/12/15.
 */
@Configuration
@ComponentScan("br.com.tarek.your.business")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Inject
  private AuthenticationServiceImpl authenticationService;

  @Inject
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DaoAuthenticationProvider authProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

    authProvider.setUserDetailsService(authenticationService);
    authProvider.setPasswordEncoder(passwordEncoder());

    return authProvider;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authProvider());
  }
}
