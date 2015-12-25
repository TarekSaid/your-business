package br.com.tarek.your.business.war.services;

import br.com.tarek.your.business.war.models.Business;

/**
 * Created by tarek on 25/12/15.
 */
public interface BusinessService {

  Business create(Business business);

  Iterable<Business> list();
}
