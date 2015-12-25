package br.com.tarek.your.business.war.services.impl;

import br.com.tarek.your.business.war.models.Business;
import br.com.tarek.your.business.war.repositories.BusinessRepository;
import br.com.tarek.your.business.war.services.BusinessService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by tarek on 25/12/15.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

  @Inject
  private BusinessRepository businessRepository;

  @Override
  public Business create(Business business) {
    return businessRepository.save(business);
  }

  @Override
  public Iterable<Business> list() {
    return businessRepository.findAll();
  }
}
