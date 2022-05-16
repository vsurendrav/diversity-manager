package com.hackathon.diversity.manager.constants;

import java.util.ArrayList;
import java.util.List;

public class DiversityDimensionConstants {
	public static final String NOT_FOUND = "NOT_FOUND";
	
	public static List<String> LEADER_TYPES;
	
	static {
		
		LEADER_TYPES = new ArrayList<String>();
		LEADER_TYPES.add("Chief Executive Officer");
		LEADER_TYPES.add("Chief Operating Officer");
		LEADER_TYPES.add("Chief Financial Officer");
		LEADER_TYPES.add("Treasurer/Director of Finance");
		LEADER_TYPES.add("Director of Finance");
		LEADER_TYPES.add("Treasurer of Finance");
	}
	
	
	public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";
}
