package com.mlaz.api.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.mlaz.api.model.MlazConsumer;

/**
 * @author quanhoang
 *
 */
@EnableScan
public interface MlazConsumerRepository extends CrudRepository<MlazConsumer, String>{
	MlazConsumer findByRefUser(String refUser);
}
