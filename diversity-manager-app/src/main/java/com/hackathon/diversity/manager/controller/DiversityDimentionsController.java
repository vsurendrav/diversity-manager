package com.hackathon.diversity.manager.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.diversity.manager.service.DiversityDimentionsService;

@RestController
public class DiversityDimentionsController {

	
	@Autowired
	DiversityDimentionsService diversityService;

	

	@GetMapping("/excel-read")
	public List<String> getDiverseLeadersFromExcel(String fileFullName) throws IOException {
			List<String> leaders = new ArrayList<String> ();
		
			try {
				leaders = diversityService.getDiverseLeaders(fileFullName);
			} catch (IOException e) {
				e.printStackTrace();
			}

		
		return leaders;
	}
	

}