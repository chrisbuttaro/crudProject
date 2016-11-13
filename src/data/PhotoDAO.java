package data;

import java.util.List;

public interface PhotoDAO {
	
	public Photo getPhotobyIndex(String s);
	public Photo addPhoto(Photo p); 
	public void deletePhoto(int index); 
	public List<Photo> getPhotos(); 
	public Photo updatePhoto(Photo p, String URL, int index);
	public Photo setSize(int index, int size); 
	public Photo getPhotoPassword(String password); 
}
