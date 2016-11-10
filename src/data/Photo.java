package data;

public class Photo {
	public Photo(){
		
	}

	public Photo(String imgURL, int count){
		this.index=count;
		this.imgURL=imgURL; 
	}
	
	public int getIndex() {
		return index;
	}

	public void setCount(int count) {
		this.index = count;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	int index; 
	String imgURL; 
	


}
