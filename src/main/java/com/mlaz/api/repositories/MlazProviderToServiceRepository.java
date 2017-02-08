package com.mlaz.api.repositories;

import com.mlaz.api.model.MlazProvider;
import com.mlaz.api.model.MlazProviderToService;
import com.mlaz.api.model.MlazService;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jimmy on 5/2/17.
 */
@EnableScan
public interface MlazProviderToServiceRepository extends CrudRepository<MlazProviderToService, String> {
	
	Page<MlazProviderToService> findByProviderByService_Id(String id, Pageable pageable);

	Page<MlazProvider> findProvidersByServiceId(String serviceId);

	Page<MlazService> findServicesByProviderId(String providerId);

	MlazProviderToService findByProviderAndService(String providerId, String serviceId);
}
