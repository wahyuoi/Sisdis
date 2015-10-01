package com.sisdis;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Max;

/**
 * Created by wahyuoi on 9/3/15.
 */
public class AppConfiguration extends Configuration {
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();
    public DataSourceFactory getDataSourceFactory(){
        return database;
    }

    @Valid
    @JsonProperty
    private ImmutableList<String> allowedGrantTypes;
    public ImmutableList<String> getAllowedGrantTypes(){
        return allowedGrantTypes;
    }

    @Valid
    @JsonProperty
    @NotEmpty
    private String bearerRealm;
    public String getBearerRealm(){
        return bearerRealm;
    }
}
