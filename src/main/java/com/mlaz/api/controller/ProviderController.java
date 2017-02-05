package com.mlaz.api.controller;

import com.mlaz.api.model.MlazProvider;
import com.mlaz.api.repositories.MlazProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jimmy on 5/2/17.
 */
@RestController
public class ProviderController {

    @Autowired
    MlazProviderRepository mlazProviderRepository;

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
}
