
package com.hackathon.diversity.dimentions.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hackathon.diversity.manager.controller.DiversityDimentionsController;
import com.hackathon.diversity.manager.service.DiversityDimentionsService;

@ExtendWith(MockitoExtension.class)
@DisplayName("Diversity Dimesions Controller")
class DiversityDimentionsControllerTest {
	
	@InjectMocks
	DiversityDimentionsController ddController;
	
	@Mock
	DiversityDimentionsService ddService;
	
	List<String> urls;
	
	private static final String CPYI_URL = "https://www.cpyi.com/";
	
	@BeforeEach
	void setUp() {
		urls = new ArrayList<String>();
		urls.add(CPYI_URL);
	}

	//@Test
	@DisplayName("Diversity Dimesions Controller read Excel")
	void testReadExcel() throws IOException, URISyntaxException {
		//when(ddService.readExcel()).thenReturn(urls);
		//assertEquals(1, ddController.readExcel().size());
		//assertEquals(CPYI_URL, ddController.readExcel().get(0));
	}

}
