package com.mlaz.api.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.math.BigDecimal;

/**
 * Created by jimmy on 9/2/17.
 */
@DynamoDBTable(tableName = "MLProviderToService")
public class MlazProviderToService {

    private String id;

    private String providerId;

    private String serviceId;

    private BigDecimal fee;

    private Long createAt;

    private Long lastModified;

    public MlazProviderToService(String providerId, String serviceId, BigDecimal fee) {
        this.providerId = providerId;
        this.serviceId = serviceId;
        this.fee = fee;

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
    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    @DynamoDBAttribute
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @DynamoDBAttribute
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
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
}
