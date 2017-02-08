package com.mlaz.api.controller;

import com.mlaz.api.model.MlazProvider;
import com.mlaz.api.model.MlazProviderToService;
import com.mlaz.api.model.MlazService;
import com.mlaz.api.repositories.MlazProviderRepository;
import com.mlaz.api.repositories.MlazProviderToServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by jimmy on 5/2/17.
 */
@RestController
public class ProviderController {

    @Autowired
    MlazProviderRepository mlazProviderRepository;

    @Autowired
    MlazProviderToServiceRepository mlazProviderToServiceRepository;

    @RequestMapping(value = "providers", method = RequestMethod.GET)
    public Iterable<MlazProvider> list() {
        return mlazProviderRepository.findAll();
    }

    @RequestMapping(value = "providers/add", method = RequestMethod.POST)
    public MlazProvider add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                            @RequestParam("identity") String identity, @RequestParam("company") String company,
                            @RequestParam("address") String address, @RequestParam("phone") String phone) {
        MlazProvider mlazProvider = new MlazProvider(firstName, lastName, identity, address, phone, company);
        return mlazProviderRepository.save(mlazProvider);
    }

    @RequestMapping(value = "providers/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        mlazProviderRepository.delete(id);
    }

    //@RequestMapping(value = "providers/getAllServices/{id}", method = RequestMethod.GET)
    //public Iterable<MlazService> list(@PathVariable("id") String providerId) {
    //    return mlazProviderToServiceRepository.findServicesByProviderId(providerId);
    //}

    @RequestMapping(value = "providers/addService", method = RequestMethod.POST)
    public MlazProviderToService add(@RequestParam("providerId") String providerId, @RequestParam("serviceId") String serviceId,
                                     @RequestParam("fee")BigDecimal fee){
        MlazProviderToService providerToService = new MlazProviderToService(providerId, serviceId, fee);
        return mlazProviderToServiceRepository.save(providerToService);
    }

    @RequestMapping(value = "providers/updateService", method = RequestMethod.POST)
    public MlazProviderToService updateService(@RequestParam("id") String id, @RequestParam("fee") BigDecimal fee){

        MlazProviderToService mlazProviderToService = mlazProviderToServiceRepository.findOne(id);
        mlazProviderToService.setFee(fee);
        mlazProviderToService.setLastModified(System.currentTimeMillis());

        return mlazProviderToServiceRepository.save(mlazProviderToService);
    }

    @RequestMapping(value = "providers/deleteService/{providerId}/{serviceId}")
    public void deleteService(@PathVariable("providerId") String providerId, @PathVariable("serviceId") String serviceId){

        MlazProviderToService obj = mlazProviderToServiceRepository.findByProviderAndService(providerId, serviceId);

        mlazProviderToServiceRepository.delete(obj);
    }
}
