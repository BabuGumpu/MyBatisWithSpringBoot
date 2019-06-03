package com.bank;

import com.bank.controller.EmployeeController;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/*
 *
 * @project - mybatiswithspringboot
 * @author - Babu Gumpu , on 29/05/2019
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeApplicationIntegrationTests {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeApplicationIntegrationTests.class);

    @LocalServerPort
    private int port;

    TestRestTemplate testRestTemplate = new TestRestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();

    @Autowired
    private EmployeeController employeeController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(employeeController).isNotNull();
    }

    @Test
    public void testGetAllEmployees() throws JSONException {
        logger.info("::testGetAllEmployees Started -->");
        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> response = testRestTemplate.exchange(createURLWithPort("/api/all"), HttpMethod.GET, entity, String.class);
        System.out.println((response.getBody()));
        logger.info("::testGetAllEmployees response.getBody() -->{}", response.getBody());
        logger.info("::testGetAllEmployees createURLWithPort(\"/all\") -->{}", createURLWithPort("/api/all"));

        String expected = "[{\"empNo\":10002,\"birthDate\":\"1964-06-01T23:00:00.000+0000\",\"firstName\":\"Bezalel\",\"lastName\":\"Simmel\",\"gender\":\"F\",\"hireDate\":\"1985-11-21T00:00:00.000+0000\"}]";
        //JSONAssert.assertEquals(expected, response.getBody(),false);

    }

    private String createURLWithPort(String uri) {
        logger.info("::createURLWithPort port -->{}", port);
        return "http://localhost:" + port + uri;
    }

}