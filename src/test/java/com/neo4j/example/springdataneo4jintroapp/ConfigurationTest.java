package com.neo4j.example.springdataneo4jintroapp;

import org.junit.jupiter.api.Test;
import org.neo4j.ogm.config.AutoIndexMode;
import org.neo4j.ogm.config.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigurationTest {

    @Test
    void shouldConfigureProgrammatically() {
        Configuration.Builder builder = new Configuration.Builder();
        builder.autoIndex("assert");
        builder.generatedIndexesOutputDir("dir");
        builder.generatedIndexesOutputFilename("filename");
        builder.credentials("fred", "flintstone");
        builder.uri("http://localhost:8080");
        builder.connectionPoolSize(200);
        builder.encryptionLevel("REQUIRED");
        builder.trustStrategy("TRUST_SIGNED_CERTIFICATES");
        builder.trustCertFile("/tmp/cert");
        builder.connectionLivenessCheckTimeout(1000);

        Configuration configuration = builder.build();

        assertThat(configuration.getAutoIndex()).isEqualTo(AutoIndexMode.ASSERT);
        assertThat(configuration.getDumpDir()).isEqualTo("dir");
        assertThat(configuration.getDumpFilename()).isEqualTo("filename");
        assertThat(configuration.getDriverClassName()).isEqualTo("org.neo4j.ogm.drivers.http.driver.HttpDriver");
        assertThat(configuration.getCredentials().credentials().toString()).isEqualTo("ZnJlZDpmbGludHN0b25l");
        assertThat(configuration.getURI()).isEqualTo("http://localhost:8080");
        assertThat(configuration.getConnectionPoolSize()).isEqualTo(200);
        assertThat(configuration.getEncryptionLevel()).isEqualTo("REQUIRED");
        assertThat(configuration.getTrustStrategy()).isEqualTo("TRUST_SIGNED_CERTIFICATES");
        assertThat(configuration.getTrustCertFile()).isEqualTo("/tmp/cert");
        assertThat(configuration.getConnectionLivenessCheckTimeout().intValue()).isEqualTo(1000);
    }
}
