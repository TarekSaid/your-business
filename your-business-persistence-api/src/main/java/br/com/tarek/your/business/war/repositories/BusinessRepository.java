package br.com.tarek.your.business.war.repositories;

import br.com.tarek.your.business.war.models.Business;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by tarek on 25/12/15.
 */
public interface BusinessRepository extends GraphRepository<Business> {
}
