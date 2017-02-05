package com.mlaz.api.repositories;

import com.mlaz.api.model.MlazProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jimmy on 5/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MlazProviderRepositoryTest {

    @Autowired
    MlazProviderRepository mlazProviderRepository;

    MlazProvider mlProvider;

    @Test
    public void createOnService() {
        mlProvider = new MlazProvider();

        mlProvider.setFirstName("Test");
        mlProvider.setLastName("Test");
        mlProvider.setIdentity("test identity");
        mlProvider.setCompany("test company");
        mlProvider.setCreatedAt(System.currentTimeMillis());
        mlProvider.setLastModified(mlProvider.getCreatedAt());

        MlazProvider actualProvider = mlazProviderRepository.save(mlProvider);
        Assert.assertEquals("Fail to insert new MLAZ provider", mlProvider, actualProvider);
    }

    @After
    public void tearDown(){
        if (mlProvider != null)
            mlazProviderRepository.delete(mlProvider);
    }
}
