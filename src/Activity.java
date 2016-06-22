import java.io.File;
import java.util.ArrayList;

public class Activity {
	String title;
	String description;
	ArrayList<User> participants;
	ArrayList<File> supportMaterial;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<User> getParticipants() {
		return participants;
	}
	public void setParticipants(ArrayList<User> participants) {
		this.participants = participants;
	}
	public ArrayList<File> getSupportMaterial() {
		return supportMaterial;
	}
	public void setSupportMaterial(ArrayList<File> supportMaterial) {
		this.supportMaterial = supportMaterial;
	}
}