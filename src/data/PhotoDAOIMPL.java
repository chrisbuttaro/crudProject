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
import java.util.concurrent.SynchronousQueue;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class PhotoDAOIMPL implements PhotoDAO {

	private List<Photo> photos = new ArrayList<>();
	int index = 0;
	
	File photoList;
	String path;
	PrintWriter pw;

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init() {
		
		
		//if(!photoList.exists()){
		photoList= new File(wac.getServletContext().getRealPath("/WEB-INF/photoDir/photoList.csv")); 
		//}
		path=photoList.getAbsolutePath(); 
		System.out.println("*************************PATH*********************");		
		System.out.println(path);
		
		//System.out.println("path:"+path);

		try (

				InputStream is = new FileInputStream(path);

				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {

			String line = "";
			
			//System.out.println("line: " + line);
			
			while ((line = buf.readLine()) != null) {
				System.out.println("*************************LINE*********************");
				System.out.println(line);
				String[] tokens = line.split(",");
				String url=tokens[0]; 
				System.out.println("*****************************TOKENS***************************");
				System.out.println(tokens.length);
				for (String string : tokens) {
					System.out.println("url:" + string);
				}
				if (url.startsWith("h")) {
				photos.add(new Photo(url, index++));
				index=-1; 
			   }
			}
			
			System.out.println("after loop");
			
			} catch (Exception e) {

			System.out.println("saved file " + e);

			}
	}

		

	

	public Photo getPhotobyIndex(String navigate) {

		switch (navigate) {
		case "back":
			index--;
			break;
		case "forward":
			index++;
			break;
		}

//		if (index > photos.size() - 1) {
//			index = 0;
//		} else if (index < 0) {
//			index = photos.size() - 1;
//		}
		System.out.println("******************************PHOTOBYINDEX***********************");
		System.out.println(photos.get(index).imgURL);
		return photos.get(index);
	}

	public void addPhoto(Photo p) {
		photos.add(p);
		index = photos.indexOf(p);

		try {
			
			pw = new PrintWriter(path);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		for (Photo photo : photos) {
			pw.write(photo.getImgURL() + ",");
		}
		pw.close();
	}

	@Override
	public void deletePhoto(int index) {

		photos.remove(index);

		for (Photo photo : photos) {
			pw.write(photo.getImgURL() + ",");
		}

	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public Photo updatePhoto(Photo p, String URL, int index) {
		System.out.println(index);
		p.setImgURL(URL);
		photos.set(index, p);
		this.index = index;

		try {
			
			pw = new PrintWriter(path);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		pw.close();
		for (Photo photo : photos) {
			pw.write(photo.getImgURL() + ",");
		}

		return p;
	}// updatePhoto

}// endclass
