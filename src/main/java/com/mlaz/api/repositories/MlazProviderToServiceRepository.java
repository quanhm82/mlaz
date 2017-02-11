package com.mlaz.api.repositories;

import com.mlaz.api.model.MlazProviderToService;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jimmy on 5/2/17.
 */
@EnableScan
public interface MlazProviderToServiceRepository extends CrudRepository<MlazProviderToService, String> {

	List<MlazProviderToService> findByServiceId(String serviceId);

	List<MlazProviderToService> findByProviderId(String providerId);

	List<MlazProviderToService> findByProviderIdAndServiceId(String providerId, String serviceId);
}
