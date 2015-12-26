package br.com.tarek.your.business.services;

import br.com.tarek.your.business.models.Business;

/**
 * Created by tarek on 25/12/15.
 */
public interface BusinessService {

  Business create(Business business);

  Iterable<Business> list();
}
