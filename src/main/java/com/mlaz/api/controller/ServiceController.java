package com.mlaz.api.controller;

import com.mlaz.api.model.MlazService;
import com.mlaz.api.repositories.MlazServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jimmy on 5/2/17.
 */
@RestController
public class ServiceController {

    @Autowired
    private MlazServiceRepository mlazServiceRepository;

    @RequestMapping(value = "services", method = RequestMethod.GET)
    public Iterable<MlazService> list() {
        return mlazServiceRepository.findAll();
    }

    @RequestMapping(value = "services/add", method = RequestMethod.POST)
    public MlazService add(@RequestParam("name") String name, @RequestParam("unit") String unit) {
        MlazService mlazService =  new MlazService(name, unit);

        return mlazServiceRepository.save(mlazService);
    }

    @RequestMapping(value = "services/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        mlazServiceRepository.delete(id);
    }
}
