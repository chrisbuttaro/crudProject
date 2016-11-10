package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class PhotoDAOIMPL implements PhotoDAO {
	
	private static final String FILE_NAME = "/WEB-INF/photos.csv";
	private List<Photo> photos = new ArrayList<>();
	int index=-1; 
	
	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init() {
		
	
		try (
		        InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
		        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
				
		      ) {
			
			String line = buf.readLine();
			int count=0; 
			
			while ((line = buf.readLine()) != null) {
				
				String[] tokens = line.split(",");
				String url=tokens[0]; 
				photos.add(new Photo(url, count++));
			 }
			
			} catch (Exception e) {	System.err.println(e);}
}
	
public Photo getPhotobyIndex(String navigate) {
		System.out.println("got here");
			switch(navigate){
			case "back": index--; break;
			case "forward": index++; break;
			}
			
		return photos.get(index);
}
	
}