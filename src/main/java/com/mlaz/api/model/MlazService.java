package com.mlaz.api.model;

import java.util.List;

//import javax.persistence.CascadeType;
//import javax.persistence.FetchType;
//import javax.persistence.ManyToMany;
//
//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * @author quanhoang
 * Model data for MLAZ Service
 */
@DynamoDBTable(tableName = "MLService")
public class MlazService {
	
	private String id;
	
	private String name;
	
	private String description;
	
	private String unit;
	
	private Long createdAt;
	
	private Long lastModified;
	
	private List<MlazProvider> providers;

	public MlazService() {};

	public MlazService(String name, String unit) {
		this.name = name;
		this.unit = unit;
		this.createdAt = System.currentTimeMillis();
		this.lastModified = System.currentTimeMillis();
	}

	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DynamoDBAttribute
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@DynamoDBAttribute
	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	@DynamoDBAttribute
	public Long getLastModified() {
		return lastModified;
	}

	public void setLastModified(Long lastModified) {
		this.lastModified = lastModified;
	}

	@DynamoDBAttribute
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	@DynamoDBAttribute
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@Fetch(FetchMode.SUBSELECT)
//	public List<MlazProvider> getProviders() {
//		return providers;
//	}
//
//	public void setProviders(List<MlazProvider> providers) {
//		this.providers = providers;
//	}
}
