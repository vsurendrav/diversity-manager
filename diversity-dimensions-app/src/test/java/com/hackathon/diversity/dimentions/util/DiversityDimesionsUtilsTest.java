package com.hackathon.diversity.dimentions.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Diversity Dimesions Utils")
class DiversityDimesionsUtilsTest {
	
	@Spy
	DiversityDimesionsUtils ddUtils;
	
	@Mock
	Connection connection;
	
	Document doc = new Document("");

	@Test
	@DisplayName("Diversity Dimesions Utils getSearchEnggUrlByTerm")
	void testGetSearchEnggUrlByTerm() throws IOException, URISyntaxException {
		
		doc.append("<link href=\"https://www.cpyi.com/\" rel=\"prerender\">");	
		
		
        Mockito.mockStatic(Jsoup.class);

        Mockito.when(connection.get()).thenReturn(doc);
        Mockito.when(connection.userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")).
        thenReturn(connection);
        
        Mockito.when(Jsoup.connect(Mockito.anyString())).
            thenReturn(connection);
        
        assertEquals("https://www.cpyi.com/", DiversityDimesionsUtils.getSearchEnggUrlByTerm("cpyi"));
		
	}

}
