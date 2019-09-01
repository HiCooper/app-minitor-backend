package com.berry.appmonitor;

import com.berry.appmonitor.api.AuthController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class SpringBootMicroServiceApplicationTests {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new AuthController()).build();
    }

    @Test
    public void contextLoads() {
    }


    @Test
    public void sendEmail() {

    }

}
