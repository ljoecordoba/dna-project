package com.dna.controller;

import jdk.net.SocketFlow;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DNAControllerTest extends AbstractTest{
    @Override
    @Before
    public void setUp(){
        super.setUp();
    }
    @Test
    public void mutant() throws Exception{
        String uri = "/mutant";
        String json = "{ \"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json)).andReturn();
        assertTrue(mvcResult.getResponse().getStatus() == 200);
    }
}
