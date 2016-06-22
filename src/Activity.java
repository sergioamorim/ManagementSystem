import java.io.File;
import java.util.ArrayList;

public class Activity {
	private static int traditionalClassesCount = 0;
	private static int presentationsCount = 0;
	private static int laboratoriesCount = 0;
	
	String title;
	String description;
	String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if (type.equals("aula tradicional"))
			setTraditionalClassesCount(getTraditionalClassesCount() + 1);
		else if (type.equals("apresentações"))
			setPresentationsCount(getPresentationsCount() + 1);
		else if (type.equals("laboratório"))
			setLaboratoriesCount(getLaboratoriesCount() + 1);
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
	public static int getTraditionalClassesCount() {
		return traditionalClassesCount;
	}
	public static void setTraditionalClassesCount(int traditionalClassesCount) {
		Activity.traditionalClassesCount = traditionalClassesCount;
	}
	public static int getPresentationsCount() {
		return presentationsCount;
	}
	public static void setPresentationsCount(int presentationsCount) {
		Activity.presentationsCount = presentationsCount;
	}
	public static int getLaboratoriesCount() {
		return laboratoriesCount;
	}
	public static void setLaboratoriesCount(int laboratoriesCount) {
		Activity.laboratoriesCount = laboratoriesCount;
	}
}