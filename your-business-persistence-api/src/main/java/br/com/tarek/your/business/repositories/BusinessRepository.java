package br.com.tarek.your.business.repositories;

import br.com.tarek.your.business.models.Business;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by tarek on 25/12/15.
 */
public interface BusinessRepository extends GraphRepository<Business> {
}
