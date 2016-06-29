import java.io.File;
import java.util.ArrayList;

public class Activity {
	public static Counter traditionalClassesCounter = new Counter("atividades de aula tradicional");
	public static Counter presentationsCounter = new Counter("atividades de apresentações");
	public static Counter laboratoriesCounter = new Counter("atividades de laboratório");
	
	private String title;
	private String description;
	private String type;
	private ArrayList<User> participants;
	private ArrayList<File> supportMaterial;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if (type.equals("aula tradicional"))
			Activity.traditionalClassesCounter.increase();
		else if (type.equals("apresentações"))
			Activity.presentationsCounter.increase();
		else if (type.equals("laboratório"))
			Activity.laboratoriesCounter.increase();
		else {
			System.out.println("Tipo de atividade inválido.");
			return;
		}
		this.type = type;
	}
	
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