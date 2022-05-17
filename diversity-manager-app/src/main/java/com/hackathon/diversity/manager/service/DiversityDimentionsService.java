package com.hackathon.diversity.manager.service;

import static com.hackathon.diversity.manager.constants.DiversityDimensionConstants.NOT_FOUND;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.hackathon.diversity.manager.constants.DiversityDimensionConstants;
import com.hackathon.diversity.manager.util.DiversityDimesionsUtils;

@Service
public class DiversityDimentionsService {

	private HashSet<String> links;
	
	public DiversityDimentionsService() {
		links = new HashSet<String>();
	}
	
	
	
	
	public List<String> getDiverseLeaders(String fileName) throws IOException {
		//List<String> customerNames = 	DiversityDimesionsUtils.readExcel( fileName);
		List<String> customerNames = Arrays.asList("Arista Business Imaging Solutions, Inc.","EXECUTEAM CORPORATION", "Premier Oil & Gas Inc",
				"Best Capital Funding", "Vista Industrial Packaging, LLC", "Bema Electronic Manufacturing, Inc.",
				"S&S Quality Meats, LLC");
		
		customerNames.forEach(site -> {
			
			try {				
			
				links = DiversityDimesionsUtils.getUrlsFromGoogle(site);
				
				getLeaderNames(links);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			 
			List<String> leaders = getLeaderNames(links);
		});
		return null;
	}
	
	private List<String> getLeaderNames(HashSet<String> links) {
		try {
			for (String link: links) {
				if (!NOT_FOUND.equals(link)) {
					Document doc = DiversityDimesionsUtils.connectOrgURL(link);
					
					Elements leadershipLinks = doc.select("a:contains(Leadership)");
					Elements aboutUsLink = doc.select("a:contains(About)");
					
					
					Elements meetOutTeam = doc.select("a:contains(Meet Our Team)");
										
					if (aboutUsLink != null ) {
						  String aboutPage = aboutUsLink.attr("href"); 
						  Document aboutDoc = DiversityDimesionsUtils.connectOrgURL(link+aboutPage); 

						  for (String leaderType: DiversityDimensionConstants.LEADER_TYPES) {
							  if ( doc.select("span").contains(leaderType)) {
							  }
							  
						  }
						  
					}
						 

					 
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

