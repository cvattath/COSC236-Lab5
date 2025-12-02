package lab5;

public class EBook implements Book{
	
	private String title;
	private boolean isAvailable;
	
	public EBook(String title) {
		this.title = title;
		this.isAvailable = true;
	}

	@Override
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
		
	}

	@Override
	public boolean getIsAvailable() {
	
		return this.isAvailable;
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
		return "EBook: " + this.title; 
	}
}
