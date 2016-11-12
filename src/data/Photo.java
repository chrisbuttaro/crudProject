package data;

public class Photo {
	public Photo(){
		
	}
	int index; 
	String imgURL;
	public Photo(String imgURL, int index){
		this.index=index; 
		this.imgURL=imgURL; 
	}
	

	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	 
	


}
