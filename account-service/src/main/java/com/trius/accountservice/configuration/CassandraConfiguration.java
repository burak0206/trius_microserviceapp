package com.trius.accountservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${accountservice.cassandra.keyspace.name}")
    private String keyspaceName;

    @Value("${accountservice.cassandra.port}")
    private int port;

    @Value("${accountservice.cassandra.contact.point}")
    private String contactPoint;

    @Value("${accountservice.cassandra.uname}")
    private String uname;

    @Value("${accountservice.cassandra.passwd}")
    private String passwd;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getUname() {
        return uname;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.trius.accountservice"};
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

}
