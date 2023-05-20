package com.illdangag.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class KafkaApplicationTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    void producerTest() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("/send/user")
                .param("name", "kim")
                .param("age", "27");

        mockMvc.perform(requestBuilder)
                .andDo(print());
    }
}
