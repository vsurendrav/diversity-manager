package com.hackathon.diversity.dimentions.service;

import static com.hackathon.diversity.dimentions.constants.DiversityDimensionConstants.NOT_FOUND;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.hackathon.diversity.dimentions.util.DiversityDimesionsUtils;

@Service
public class DiversityDimentionsService {

	public List<String> readExcel() throws IOException, URISyntaxException {

		List<String> urls = new ArrayList<>();
		URL res = getClass().getClassLoader().getResource("DiversityDimentionsTestData.xlsx");
		File file = Paths.get(res.toURI()).toFile();

		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			if (row.getRowNum() > 0) {
				String companyName = row.getCell(1).getStringCellValue();
				if (companyName != null && !companyName.isEmpty()) {
					String url = DiversityDimesionsUtils.getSearchEnggUrlByTerm(companyName);
					urls.add(url);
					getNavtigationPages(url);
				}
			}
		}
		return urls;

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
					String leadPage = leaderShipLinks.attr("href");
					Document doc1 = DiversityDimesionsUtils.connectOrgURL(leadPage);
					Elements leaderShipcontent = doc1.select("div");
				}
			}
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
