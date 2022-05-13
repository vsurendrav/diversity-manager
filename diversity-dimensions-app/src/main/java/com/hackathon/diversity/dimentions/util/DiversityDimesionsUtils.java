package com.hackathon.diversity.dimentions.util;

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
	public static final String NOT_FOUND = "NOT_FOUND";
	static List<String> listofSites = Arrays.asList("CP&y, Inc.", "Arista Business Imaging Solutions, Inc.", "EXECUTEAM CORPORATION",
			"Premier Oil & Gas Inc", "Best Capital Funding", "Vista Industrial Packaging, LLC",
			"Bema Electronic Manufacturing, Inc.", "S&S Quality Meats, LLC");
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DiversityDimesionsUtils.class);

	/*@param : searchTerm used in searching company website in google*/
	private static String getSearchEnggUrlByTerm(String searchTerm)throws IOException {		
   		searchTerm = searchTerm.indexOf('&') !=-1 ?searchTerm.replaceAll("&", "%26"):searchTerm;			
   		String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num=1";
   		Document doc =connectURL(searchURL);
   		Elements results = doc.select("link[href]"); 
   		if(results!=null && results.first()!=null) {
   			return  results.first().attr("href");
		}
			 
   		return NOT_FOUND;
   	}
   	
	/*
	 * @Param : url - provide the url to connect the site
	 */
	private static Document connectURL(String url) throws IOException{
		return Jsoup.connect(url).get();
	}
	
	/* Return List of Urls */
	private static List<String>  getListOfAbsUrls() {
   		return listofSites.stream().map(t -> {
			try {
				return getSearchEnggUrlByTerm(t);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";
		}).collect(Collectors.toList());
   		
   	}
}
