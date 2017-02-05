package com.mlaz.api.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.mlaz.api.model.MlazProvider;
import com.mlaz.api.model.MlazService;

@EnableScan
public interface MlazServiceRepository extends CrudRepository<MlazService, String> {
	
	Page<MlazProvider> findByProviders_Id(String id, Pageable pageable);
}
