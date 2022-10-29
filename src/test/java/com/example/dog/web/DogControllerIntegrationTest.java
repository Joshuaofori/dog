package com.example.dog.web;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.dog.service.DogService;


@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerIntegrationTest {
	@Autowired
    private MockMvc mvc;

	   @MockBean
	    private DogService dogService;
	    
	    @Test
	    @WithMockUser(username="joshua",roles="USER")
	    public void findDogs() throws Exception {
	    	 mvc.perform(get("/dogs"))
	         .andExpect(status().isOk())
	         .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	         .andExpect(content().json("[]"));
	    	 
	    	 verify(dogService, times(1)).retrieveDogs();
	      }
	    
	   
	   
}
