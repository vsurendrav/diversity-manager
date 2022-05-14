package com.hackathon.diversity.dimentions.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.diversity.dimentions.util.DiversityDimesionsUtils;
import static com.hackathon.diversity.dimentions.constants.DiversityDimensionConstants.NOT_FOUND;

@RestController
public class DiversityDimentionsController {

	static List<String> listofSites = Arrays.asList("Arista Business Imaging Solutions, Inc.", "EXECUTEAM CORPORATION",
			"Premier Oil & Gas Inc", "Best Capital Funding", "Vista Industrial Packaging, LLC",
			"Bema Electronic Manufacturing, Inc.", "S&S Quality Meats, LLC");
	
	@GetMapping("/read")
	public List<String> readExcel() throws IOException {
		/*
		 * List<String> urls = new ArrayList<>(); FileInputStream file = new
		 * FileInputStream(new File("C:\\Users\\Dell\\Hackathon.xlsx")); Workbook
		 * workbook = new XSSFWorkbook(file); Sheet sheet = workbook.getSheetAt(0); for
		 * (Row row : sheet) { if (row.getRowNum() > 0) { String companyName =
		 * row.getCell(1).getStringCellValue(); if (companyName != null &&
		 * !companyName.isEmpty()) { String url =
		 * DiversityDimesionsUtils.getSearchEnggUrlByTerm(companyName);
		 * getNavtigationPages(url); } } } return urls;
		 */
		listofSites.forEach(site -> {
			String url =  null; 
			try {
				 url =DiversityDimesionsUtils.getSearchEnggUrlByTerm(site);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 getNavtigationPages(url);
		});
		return null;
	}

	private void getNavtigationPages(String url) {
		try {
			System.out.println(url);
			if (!NOT_FOUND.equals(url)) {
				Document doc = DiversityDimesionsUtils.connectOrgURL(url);
				Elements leaderShipLinks = doc.select("a:contains(Leadership)");
				Elements aboutUsLinks = doc.select("a:contains(About Us)");
				Elements meetOutTeam = doc.select("a:contains(Meet Our Team)");
				
				if (leaderShipLinks != null && leaderShipLinks.first() != null) {
				  System.out.println(leaderShipLinks.attr("href"));
				  String leadPage =leaderShipLinks.attr("href"); 
				  Document doc1 = DiversityDimesionsUtils.connectOrgURL(leadPage); 
				  Elements leaderShipcontent = doc1.select("div");
				}
				 
				// leaderShipcontent.children();
				// .getElementsMatchingText(null)t
				// System.out.println(leaderShipcontent);
			}
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}