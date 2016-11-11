package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class PhotoDAOIMPL implements PhotoDAO {
	
	private List<Photo> photos = new ArrayList<>();
	int index=-1; 
	String path; 
	int count; 
	PrintWriter pw = null;
	File file=new File("NewData.csv");
	
    
	
	
	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init() {
		
		System.out.println("before first");
		 path =file.getAbsolutePath(); 
		
		try (
				
				 InputStream is =new FileInputStream(path);
	
		        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
		      ) {
			
			
			String line = buf.readLine();
			System.out.println(line);
			String[] tokens = line.split(",");
			for (String string : tokens) {
				if(string.startsWith("h")){
				photos.add(new Photo(string, count++));
				}
			}
				
					
			} catch (Exception e) {	
				
				System.out.println("saved file "+e);
				
			}	
			
		System.out.println("before second");
		
		
}
	
public Photo getPhotobyIndex(String navigate) {

			switch(navigate){
			case "back": index--; break;
			case "forward": index++; break;}
			
			if(index>photos.size()-1) {index=0;}
			else if (index<0) {index=photos.size()-1;}
			
		return photos.get(index);
}

public void addPhoto(Photo p){
	photos.add(p); 
	index=photos.indexOf(p); 
	System.out.println(photos.size());
	
	
	try {
	    pw = new PrintWriter(file);
	    path = file.getAbsolutePath();
	 System.out.println(path);
	} catch (FileNotFoundException e) {
	    System.out.println(e);
	}
	for (Photo photo : photos) {
		pw.write(photo.getImgURL()+",");
	}
	
	
	pw.close();
	System.out.println("done!");
	}
	

	


@Override
public void deletePhoto(int index) {
	
	photos.remove(index); 
	
	
	try {
	    pw = new PrintWriter(file);
	    path = file.getAbsolutePath();
	 System.out.println(path);
	} catch (FileNotFoundException e) {
	    System.out.println(e);
	}
	for (Photo photo : photos) {
		pw.write(photo.getImgURL()+",");
	}
	
	
	pw.close();
	
	
}

public List<Photo> getPhotos() {
	return photos;
}

public Photo updatePhoto(Photo p, String URL, int index){
	System.out.println(index);
			p.setImgURL(URL);
			photos.set(index,p);
			this.index=index; 
			
			
			try {
			    pw = new PrintWriter(file);
			    path = file.getAbsolutePath();
			 System.out.println(path);
			} catch (FileNotFoundException e) {
			    System.out.println(e);
			}
			for (Photo photo : photos) {
				pw.write(photo.getImgURL()+",");
			}

	return p; 
}//updatePhoto
			
}//endclass		
			
