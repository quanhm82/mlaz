package com.mlaz.api.repositories;

import com.mlaz.api.model.MlazProvider;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jimmy on 5/2/17.
 */
@EnableScan
public interface MlazProviderRepository extends CrudRepository<MlazProvider, String> {
}
