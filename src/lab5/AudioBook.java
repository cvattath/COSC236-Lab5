package lab5;

public class AudioBook implements Book{

	
	private String title;
	private boolean isAvailable;
	
	public AudioBook(String title) {
		this.title = title;
		this.isAvailable = true;
	}
	
	@Override
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
		
	}

	@Override
	public boolean getIsAvailable() {
		
		return isAvailable;
	}

	@Override
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "AudioBook: " + this.title; 
	}

}
