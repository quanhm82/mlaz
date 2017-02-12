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
 * Created by jimmy on 5/2/17.
 * For common info like first/last name, address, email ... will be
 * stored in referenced user (refUser)
 */
@DynamoDBTable(tableName = "MLProvider")
public class MlazProvider {

    private String id;

    private String firstName; //TODO: will be referenced to MlazUser

    private String lastName; //TODO: will be referenced to MlazUser

    private String identity;

    private String address; //TODO: will be referenced to MlazUser

    private String phone; //TODO: will be referenced to MlazUser

    private Long createdAt;

    private Long lastModified;

    private String company;
    
    private List<MlazService> services;

    public MlazProvider() {};

    public MlazProvider(String firstName, String lastName, String identity, String address, String phone, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identity = identity;
        this.address = address;
        this.phone = phone;

        this.company = company;

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
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @DynamoDBAttribute
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @DynamoDBAttribute
    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @DynamoDBAttribute
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @DynamoDBAttribute
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    @DynamoDBAttribute
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SUBSELECT)
//	public List<MlazService> getServices() {
//		return services;
//	}
//
//	public void setServices(List<MlazService> services) {
//		this.services = services;
//	}


}
