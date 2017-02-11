package com.mlaz.api.repositories;

import com.mlaz.api.model.MlazProvider;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.amazonaws.auth.policy.actions.DynamoDBv2Actions.Query;

/**
 * Created by jimmy on 5/2/17.
 */
@EnableScan
public interface MlazProviderRepository extends CrudRepository<MlazProvider, String> {
	
	Page<MlazProvider> findByServices_Id(String id, Pageable pageable);
}
