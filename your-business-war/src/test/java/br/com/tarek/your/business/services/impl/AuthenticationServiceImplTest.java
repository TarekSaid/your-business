package br.com.tarek.your.business.services.impl;

import br.com.tarek.your.business.models.Business;
import br.com.tarek.your.business.repositories.BusinessRepository;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by tarek on 27/12/15.
 */
@Test
public class AuthenticationServiceImplTest {

  @Tested
  private AuthenticationServiceImpl authenticationService;

  @Injectable
  private BusinessRepository businessRepository;

  @DataProvider(name = "businesses")
  public Iterator<Object[]> businesses() {
    Collection<Object[]> businesses = new ArrayList<>();

    Business b = new Business("username", "email");
    b.setPassword("password");
    b.setRole("test");

    businesses.add(new Object[]{"test@test.com", b});
    businesses.add(new Object[]{null, null});
    businesses.add(new Object[]{"", null});
    businesses.add(new Object[]{"email@not.found.com", null});
    businesses.add(new Object[]{"another@test.com", b});

    return businesses.iterator();
  }

  @Test(dataProvider = "businesses")
  public void loadUserByUsernameShouldCallFindEmailsFromRepository(final String email, final Business business) {
    new Expectations() {{
      businessRepository.findByEmail(email); result = business;
    }};

    UserDetails user = authenticationService.loadUserByUsername(email);

    if (business != null) {
      assertThat(user).isEqualTo(new User("email", "password", Arrays.asList(new SimpleGrantedAuthority("test"))));
    } else {
      assertThat(user).isNull();
    }
  }
}
