package com.hackathon.diversity.dimentions.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.diversity.dimentions.util.DiversityDimesionsUtils;

@RestController
public class DiversityDimentionsController {

	@GetMapping("/read")
	public List<String> readExcel() throws IOException {
		List<String> urls = new ArrayList<>();
		FileInputStream file = new FileInputStream(new File("C:\\Users\\Dell\\Hackathon.xlsx"));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			if (row.getRowNum() > 0) {
				String companyName = row.getCell(1).getStringCellValue();
				if (companyName != null && !companyName.isEmpty()) {
					urls.add(DiversityDimesionsUtils.getSearchEnggUrlByTerm(companyName));
				}
			}
		}
		return urls;
	}
}