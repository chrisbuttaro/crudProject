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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class PhotoDAOIMPL implements PhotoDAO {

	private List<Photo> photos = new ArrayList<>();
	
	
	File photoList;
	File sizeList; 
	String path;
	String sizePath; 
	PrintWriter pw;
	

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init() {
		
		
		
		photoList= new File(wac.getServletContext().getRealPath("/WEB-INF/photoDir/photoList.csv")); 
		sizeList= new File(wac.getServletContext().getRealPath("/WEB-INF/photoDir/sizeList.csv"));
		sizePath=sizeList.getAbsolutePath(); 
		
		path=photoList.getAbsolutePath(); 
		System.out.println("*************************PATH*********************");		
		System.out.println(path);
		


		try (
				InputStream is = new FileInputStream(path);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {

				String line = "";
				line = buf.readLine();
				int count=0; 
				String[] tokens = line.split(",");
				for (String string : tokens) {
				 if (string.startsWith("h")) {
				  photos.add(new Photo(string,count++));		
					}
			     }
			
			} catch (Exception e) {
			System.out.println("read in failed" + e);
			}
		
		try (
				InputStream is = new FileInputStream(sizePath);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {

				String line = "";
				line = buf.readLine();
				int count=0; 
				String[] tokens = line.split(",");
				for (String string: tokens) {
					photos.get(count++).setSize(Integer.parseInt(string));
			     }
			
			} catch (Exception e) {
			System.out.println("size read in failed" + e);
			}
	}

		

	
	 int index=-1;
	public Photo getPhotobyIndex(String navigate) {
		
		switch (navigate) {
		case "back":
			index--;
			break;
		case "forward":
			
			index++;
			
		
			break;
		}
			
		if (index > photos.size() - 1) {
			index = 0;
		} else if (index < 0) {
			index = photos.size() - 1;
		}
		System.out.println("******************************"+index+"***********************");
		
		return(photos.get(index));
		
	}

	public Photo addPhoto(Photo p) {
		
		for (Photo photo : photos) {
			if(photo.getIndex()>=p.getIndex())
				photo.setIndex(photo.getIndex()+1);
			
		}
		photos.add(p.getIndex(), p);
		
		
		
		
		try {
			
			pw = new PrintWriter(path);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		for (Photo photo : photos) {
			pw.write(photo.getImgURL() + ",");
		}
		pw.close();
		return p; 
	}

	@Override
	public void deletePhoto(int index) {

		photos.remove(index);

		for (Photo photo : photos) {
			pw.write(photo.getImgURL() + ",");
		}
		
try {
			
			pw = new PrintWriter(sizePath);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
		for (Photo photo : photos) {
			pw.write(photo.getSize() + ",");
		}
		pw.close();
		

	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public Photo updatePhoto(Photo p, String URL, int index) {
		System.out.println(index);
		p.setImgURL(URL);
		photos.set(index, p);

		try {
			
			pw = new PrintWriter(path);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
		for (Photo photo : photos) {
			pw.write(photo.getImgURL() + ",");
		}
		pw.close();
		return p;
	}// updatePhoto

	@Override
	public Photo setSize(int index, int size) {
		photos.get(index).setSize(size);
		
try {
			
			pw = new PrintWriter(sizePath);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
		for (Photo photo : photos) {
			pw.write(photo.getSize() + ",");
		}
		pw.close();
		
		return photos.get(index); 
	}

}// endclass