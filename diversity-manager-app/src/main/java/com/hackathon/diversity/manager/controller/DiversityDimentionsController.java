package com.hackathon.diversity.manager.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.diversity.manager.service.DiversityDimentionsService;



@RestController
public class DiversityDimentionsController {

	@Autowired
	DiversityDimentionsService diversityDimentionsService;

	@GetMapping("/read")
	public List<String> readExcel() throws IOException, URISyntaxException {
	  return diversityDimentionsService.readExcel();
	}
}