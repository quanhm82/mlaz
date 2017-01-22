package com.mlaz.api.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.mlaz.api.model.MlazService;

@EnableScan
public interface MlazServiceRepository extends CrudRepository<MlazService, String> {

}
