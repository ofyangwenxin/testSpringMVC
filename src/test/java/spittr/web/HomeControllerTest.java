package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.junit.Assert.*;

public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
//        HomeController controller = new HomeController();
//        assertEquals("home", controller.home());
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.view().name("home"));
    }
}