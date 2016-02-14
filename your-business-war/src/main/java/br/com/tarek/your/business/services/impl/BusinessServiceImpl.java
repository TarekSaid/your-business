package br.com.tarek.your.business.services.impl;

import br.com.tarek.your.business.models.Business;
import br.com.tarek.your.business.repositories.BusinessRepository;
import br.com.tarek.your.business.services.BusinessService;
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

  @Override
  public Business findBusiness(long id) {
    return businessRepository.findOne(id);
  }
}
