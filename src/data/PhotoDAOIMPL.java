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
	int index = -1;
	int count;
	File file;
	String path;
	PrintWriter pw;

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init() {
		
		
		path="/Users/christopher/eclipse/jee-neon/Eclipse.app/Contents/MacOS/data.csv"; 
		
		System.out.println(path);

		try (

				InputStream is = new FileInputStream(path);

				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {

			String line = buf.readLine();
			System.out.println("line: " + line);
			String[] tokens = line.split(",");
			for (String string : tokens) {
				if (string.startsWith("h")) {
					photos.add(new Photo(string, count++));
				}
			}

		} catch (Exception e) {

			System.out.println("saved file " + e);

		}

		System.out.println("before second");

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

		if (index > photos.size() - 1) {
			index = 0;
		} else if (index < 0) {
			index = photos.size() - 1;
		}

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
