package br.com.tarek.your.business.services.impl;

import br.com.tarek.your.business.models.Business;
import br.com.tarek.your.business.repositories.BusinessRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tarek on 27/12/15.
 */
@Service
public class AuthenticationServiceImpl implements UserDetailsService {

  @Inject
  private BusinessRepository businessRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Business business = businessRepository.findByEmail(email);

    if (business != null) {
      List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(business.getRole()));
      UserDetails userDetails = new User(business.getEmail(), business.getPassword(), authorities);
      return userDetails;
    }

    return null;
  }
}
