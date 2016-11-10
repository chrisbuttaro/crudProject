package data;

import java.util.List;

public interface PhotoDAO {
	
	public Photo getPhotobyIndex(String s);
	public void addPhoto(Photo p); 
	public void deletePhoto(int index); 
	public List<Photo> getPhotos(); 
}
