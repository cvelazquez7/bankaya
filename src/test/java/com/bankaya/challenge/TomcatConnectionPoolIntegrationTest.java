package com.bankaya.challenge;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
class TomcatConnectionPoolIntegrationTest {

    @Autowired
    private DataSource dataSource;


    @Test
    void tomcatConnectionPoolInstance() {
        assertEquals( "org.apache.tomcat.jdbc.pool.DataSource", dataSource.getClass().getName());
    }
}
