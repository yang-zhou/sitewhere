/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sitewhere.rest.model.common.MetadataProviderEntity;
import com.sitewhere.rest.model.datatype.JsonDateSerializer;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.user.AccountStatus;
import com.sitewhere.spi.user.IUser;

/**
 * Model class for a User.
 * 
 * @author Derek Adams
 */
@JsonInclude(Include.NON_NULL)
public class User extends MetadataProviderEntity implements IUser {

    /** For {@link Serializable} */
    private static final long serialVersionUID = -3322129570954465956L;

    /** Unique id */
    private UUID id;

    /** Reference token */
    private String token;

    /** Unique username */
    private String username;

    /** Hashed password */
    private String hashedPassword;

    /** First name */
    private String firstName;

    /** Last name */
    private String lastName;

    /** Last login */
    private Date lastLogin;

    /** Account status */
    private AccountStatus status;

    /** List of granted authorities */
    private List<String> authorities = new ArrayList<>();

    /*
     * @see com.sitewhere.spi.common.ISiteWhereEntity#getId()
     */
    @Override
    public UUID getId() {
	return id;
    }

    public void setId(UUID id) {
	this.id = id;
    }

    /*
     * @see com.sitewhere.spi.common.ISiteWhereEntity#getToken()
     */
    @Override
    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#getUsername()
     */
    @Override
    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#getHashedPassword()
     */
    @Override
    public String getHashedPassword() {
	return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
	this.hashedPassword = hashedPassword;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#getFirstName()
     */
    @Override
    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#getLastName()
     */
    @Override
    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#getLastLogin()
     */
    @Override
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getLastLogin() {
	return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
	this.lastLogin = lastLogin;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#getStatus()
     */
    @Override
    public AccountStatus getStatus() {
	return status;
    }

    public void setStatus(AccountStatus status) {
	this.status = status;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#getAuthorities()
     */
    @Override
    public List<String> getAuthorities() {
	return authorities;
    }

    public void setAuthorities(List<String> authorities) {
	this.authorities = authorities;
    }

    /**
     * Copy contents from the SPI class.
     * 
     * @param input
     * @return
     */
    public static User copy(IUser input) throws SiteWhereException {
	User result = new User();
	result.setUsername(input.getUsername());
	result.setHashedPassword(input.getHashedPassword());
	result.setFirstName(input.getFirstName());
	result.setLastName(input.getLastName());
	result.setLastLogin(input.getLastLogin());
	result.setStatus(input.getStatus());
	result.setAuthorities(new ArrayList<String>(input.getAuthorities()));
	MetadataProviderEntity.copy(input, result);
	return result;
    }
}