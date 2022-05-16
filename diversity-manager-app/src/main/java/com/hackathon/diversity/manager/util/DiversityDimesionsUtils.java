package com.hackathon.diversity.manager.util;

import static com.hackathon.diversity.manager.constants.DiversityDimensionConstants.NOT_FOUND;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DiversityDimesionsUtils {
	public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";

	private static final Logger LOGGER = LoggerFactory.getLogger(DiversityDimesionsUtils.class);

	/* @param : searchTerm used in searching company website in google */
	public static String getSearchEnggUrlByTerm(String searchTerm) throws IOException {
		searchTerm = searchTerm.indexOf('&') != -1 ? searchTerm.replaceAll("&", "%26") : searchTerm;
		String searchURL = GOOGLE_SEARCH_URL + "?q=" + searchTerm;
		Document doc = connectURL(searchURL);
		Elements results = doc.select("link[href]");
		if (results != null && results.first() != null) {
			System.out.println(results.first().attr("href"));
			return results.first().attr("href");
		}

		return NOT_FOUND;
	}

	/*
	 * @Param : url - provide the url to connect the site
	 */
	private static Document connectURL(String url) throws IOException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Thread inturrpted");
		}
		return connectOrgURL(url);
	}
	
	public static Document connectOrgURL(String url) throws IOException {
		return Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").get();
	}

}
