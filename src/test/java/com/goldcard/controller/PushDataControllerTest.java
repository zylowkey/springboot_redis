package com.goldcard.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.goldcard.Main;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class PushDataControllerTest {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void whenCreateSuccess() throws Exception {
		//String content = "{\"id\":null,\"name\":\"战争与和平\",\"content\":null,\"publishDate\":\"2018-03-29\"}";
//		mockMvc.perform(post("/meterno/201806200925").contentType(MediaType.APPLICATION_JSON))
		mockMvc.perform(post("/meterno")
				.contentType(MediaType.APPLICATION_JSON)
				.param("meterno","202012251623")
				.param("id","2"))
		.andExpect(status().isOk());
		//.andExpect(jsonPath("$.id").value("1"));
	}
}
