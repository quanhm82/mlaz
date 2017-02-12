package com.mlaz.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.mlaz.api.Enum.MarketPriceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlaz.api.model.MlazMarketPrice;
import com.mlaz.api.model.MlazProviderToService;
import com.mlaz.api.repositories.MlazMarketPriceRepository;
import com.mlaz.api.repositories.MlazProviderToServiceRepository;

/**
 * Created by jimmy on 12/2/17.
 */

@RestController
public class MarketPriceController {

    @Autowired
    private MlazMarketPriceRepository mlazMarketPriceRepository;

    @Autowired
    private MlazProviderToServiceRepository mlazProviderToServiceRepository;

    @RequestMapping(value = "marketPrice")
    public Iterable<MlazMarketPrice> list() {
        return mlazMarketPriceRepository.findAll();
    }

    @RequestMapping(value = "marketPrice/calculateMarketService")
    public void calculateMarketService() {
        Iterable<MlazProviderToService> providerToServiceList =  mlazProviderToServiceRepository.findAll();

        //List<MlazProviderToService> providerToServices = new ArrayList<MlazProviderToService>();
        //providerToServiceList.forEach(providerToServices::add);
 
        Map<String, Double> serviceWithAvgFee = StreamSupport.stream(providerToServiceList.spliterator(), false).collect(
                            Collectors.groupingBy(MlazProviderToService::getServiceId, Collectors.averagingDouble(MlazProviderToService::getFee)));

        List<MlazMarketPrice> marketPrices = new ArrayList<MlazMarketPrice>();
       
        serviceWithAvgFee.forEach((k,v) -> {
        	marketPrices.add(new MlazMarketPrice(k,v));
        });
        
        mlazMarketPriceRepository.save(marketPrices);
    }

    @RequestMapping(value = "marketPrice/setMainPrice/{id}")
    public void updateStatus(@PathVariable("id") String id){
        MlazMarketPrice marketPrice = mlazMarketPriceRepository.findOne(id);

        List<MlazMarketPrice> oldMarketPrices = mlazMarketPriceRepository.findByServiceIdAndStatus(marketPrice.getServiceId(), MarketPriceEnum.USE.toString());
        oldMarketPrices.forEach(x -> {
            x.setStatus(MarketPriceEnum.NOT_USE.toString());
        });

        marketPrice.setStatus(MarketPriceEnum.USE.toString());

        mlazMarketPriceRepository.save(oldMarketPrices);

        mlazMarketPriceRepository.save(marketPrice);
    }
}
