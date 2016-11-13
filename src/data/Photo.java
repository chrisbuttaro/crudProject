package data;

public class Photo {
	public Photo(){
		
	}
	int index; 
	private String imgURL;
	private int size=400; 
	public Photo(String imgURL, int index){
		this.index=index; 
		this.imgURL=imgURL; 
		
	}
	

	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
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
