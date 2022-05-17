package com.hackathon.diversity.manager.util;

import static com.hackathon.diversity.manager.constants.DiversityDimensionConstants.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DiversityDimesionsUtils {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(DiversityDimesionsUtils.class);

	
	private static Pattern patternDomainName;
	private Matcher matcher;
	private static final String DOMAIN_NAME_PATTERN = "([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}";
	static {
		patternDomainName = Pattern.compile(DOMAIN_NAME_PATTERN);
	}
	
	//Exceptions and Logging framework to be addressed
		public static List<String> readExcel(String fileName) throws IOException {
			
			List<String> customerNames = new ArrayList<String>();
			try {
				FileInputStream file = new FileInputStream(new File(fileName));
				Workbook workbook = new XSSFWorkbook(file);
				Sheet sheet = workbook.getSheetAt(0);
				for (Row row : sheet) {
					if (row.getRowNum() > 0) {
						String companyName = row.getCell(1).getStringCellValue();
						if (companyName != null && !companyName.isEmpty()) {
							customerNames.add(companyName);
						}
					}
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			return customerNames;
			
		}

	/* @param : searchTerm used in searching company website in google */
	public static HashSet<String> getUrlsFromGoogle(String searchTerm) throws IOException {
		HashSet<String> links = new HashSet<String> ();
		searchTerm = searchTerm.indexOf('&') != -1 ? searchTerm.replaceAll("&", "%26") : searchTerm;
		String searchURL = GOOGLE_SEARCH_URL + "?q=" + searchTerm + "&num=20";
		Document doc = connectURL(searchURL);
		Elements linksOnPage = doc.select("a[href]");

		if (linksOnPage != null) {
			
			links.add(searchURL);

		}

		return links;
	}

	/*
	 * @Param : url - provide the url to connect the site
	 */
	private static Document connectURL(String url) throws IOException {
		return connectOrgURL(url);
	}

	public static Document connectOrgURL(String url) throws IOException {
		return Jsoup.connect(url).userAgent(
				"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
				.timeout(5000).get();
	}

	public String getDomainName(String url) {

		String domainName = "";
		matcher = patternDomainName.matcher(url);
		if (matcher.find()) {
			domainName = matcher.group(0).toLowerCase().trim();
		}
		return domainName;

	}

}
