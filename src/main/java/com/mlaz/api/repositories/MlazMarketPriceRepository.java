package com.mlaz.api.repositories;

import com.mlaz.api.model.MlazMarketPrice;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jimmy on 12/2/17.
 */

@EnableScan
public interface MlazMarketPriceRepository extends CrudRepository<MlazMarketPrice, String> {

    List<MlazMarketPrice> findByServiceIdAndStatus(String serviceId, String status);
}
