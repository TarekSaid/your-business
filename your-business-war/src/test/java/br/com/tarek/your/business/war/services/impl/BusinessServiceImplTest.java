package br.com.tarek.your.business.war.services.impl;

import br.com.tarek.your.business.war.models.Business;
import br.com.tarek.your.business.war.repositories.BusinessRepository;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tarek on 25/12/15.
 */
@Test
public class BusinessServiceImplTest {

  @Tested
  private BusinessServiceImpl businessService;

  @Injectable
  private BusinessRepository businessRepository;

  public void createShouldCallSaveFromRepository(@Mocked final Business business) {
    new Expectations() {{
      businessRepository.save(business); result = business;
    }};

    assertThat(businessService.create(business)).isEqualTo(business);
  }

  public void listShouldCallFindAllFromRepository(@Mocked final List<Business> businesses) {
    new Expectations() {{
      businessRepository.findAll(); result = businesses;
    }};

    assertThat(businessService.list()).isEqualTo(businesses);
  }
}
