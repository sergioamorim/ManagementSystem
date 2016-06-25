import java.io.File;
import java.util.ArrayList;

public class Activity {
	public static Counter traditionalClassesCount = new Counter("atividades de aula tradicional");
	public static Counter presentationsCount = new Counter("atividades de apresentações");
	public static Counter laboratoriesCount = new Counter("atividades de laboratório");
	
	String title;
	String description;
	String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if (type.equals("aula tradicional"))
			Activity.traditionalClassesCount.increase();
		else if (type.equals("apresentações"))
			Activity.presentationsCount.increase();
		else if (type.equals("laboratório"))
			Activity.laboratoriesCount.increase();
		else {
			System.out.println("Tipo de atividade inválido.");
			return;
		}
		this.type = type;
	}
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