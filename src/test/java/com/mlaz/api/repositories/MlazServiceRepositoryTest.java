package com.mlaz.api.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mlaz.api.model.MlazService;


@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = {PropertyPlaceholderAutoConfiguration.class, DynamoDbConfiguration.class})
@SpringBootTest
public class MlazServiceRepositoryTest {
	
	@Autowired
	private MlazServiceRepository mlazServiceRepositoryl;
	
	@Test
	public void createOneService() {
		MlazService mlService = new MlazService();
		MlazService actualService = mlazServiceRepositoryl.save(mlService);
		Assert.assertEquals("Fail to insert new MLAZ service", mlService, actualService);
	}
}
