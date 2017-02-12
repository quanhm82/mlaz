package com.mlaz.api.model;

import com.amazonaws.SystemDefaultDnsResolver;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.mlaz.api.Enum.MarketPriceEnum;

import java.math.BigDecimal;

/**
 * Created by jimmy on 12/2/17.
 */

@DynamoDBTable(tableName = "MLMarketPrice")
public class MlazMarketPrice {

    private String id;
    private String serviceId;

    private Long createAt;
    private Long lastModified;
    private Double averageFee;
    private String status;

    public MlazMarketPrice() {}

   
    public MlazMarketPrice(String serviceId, Double averageFee) {
		super();
		this.serviceId = serviceId;
		this.averageFee = averageFee;
		
		this.status = MarketPriceEnum.NEW.toString();

        this.createAt = System.currentTimeMillis();
        this.lastModified = System.currentTimeMillis();
	}


	public MlazMarketPrice(String serviceId, Double amount, String status) {
        this.serviceId = serviceId;
        this.averageFee = amount;
        this.status = status;

        this.createAt = System.currentTimeMillis();
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
    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    @DynamoDBAttribute
    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    @DynamoDBAttribute
    public Double getAverageFee() {
        return averageFee;
    }

    public void setAverageFee(Double averageFee) {
        this.averageFee = averageFee;
    }

    @DynamoDBAttribute
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
