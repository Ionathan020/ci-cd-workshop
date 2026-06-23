package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MarioController.class)
class MarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void mario_shouldReturnCatchPhrase() throws Exception {
        mockMvc.perform(get("/mario"))
                .andExpect(status().is5xxServerError())
                .andExpect(content().string("It's-a me, Mario!"));
    }
}
