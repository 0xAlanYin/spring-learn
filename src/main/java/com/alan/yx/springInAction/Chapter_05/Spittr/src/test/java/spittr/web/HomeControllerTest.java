package com.alan.yx.springInAction.Chapter_05.Spittr.src.test.java.spittr.web;

import com.alan.yx.springInAction.Chapter_05.Spittr.src.main.java.spittr.web.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
//        assertEquals("test", "home", controller.home());
        // 搭建 MockMvc
        MockMvc mockMvc = standaloneSetup(controller).build();
        // 对 "/"执行请求
        mockMvc.perform(get("/"))
                // 预期得到 home 视图
                .andExpect(view().name("home"));
    }

}
