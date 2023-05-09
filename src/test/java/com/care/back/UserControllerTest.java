package com.care.back;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.care.back.member.controller.BilMemberController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	BilMemberController memberController;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
	}
	
	/*
	 * @DisplayName("1.로그인 실패 테스트")
	 * 
	 * @Test public void test1() throws Exception { JSONObject jsonObject = new
	 * JSONObject(); jsonObject.put("id", "test_userr"); jsonObject.put("pwd",
	 * "test_passwordd");
	 * 
	 * ResultActions result = mockMvc.perform(post("/user/login")
	 * .content(jsonObject.toString()) .contentType(MediaType.APPLICATION_JSON));
	 * 
	 * MvcResult mvcResult = result.andDo(print()) .andExpect(status().isOk())
	 * .andReturn();
	 * 
	 * System.out.println(mvcResult.getResponse().getContentAsString()); }
	 */
	
	@DisplayName("2. 로그인 성공 테스트")
	@Test
	public void test2() throws Exception {
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "test_user");
        jsonObject.put("pwd", "test_password");
        
        ResultActions result = mockMvc.perform(post("/user/login")
                .content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON));

        MvcResult mvcResult = result.andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
	}
}
