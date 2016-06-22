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
			increaseTraditionalClassesCount();
		else if (type.equals("apresentações"))
			increasePresentationsCount();
		else if (type.equals("laboratório"))
			increaseLaboratoriesCount();
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
	public static void increaseTraditionalClassesCount() {
		traditionalClassesCount += 1;
	}
	public static void decreaseTraditionalClassesCount() {
		if (traditionalClassesCount > 0)
			traditionalClassesCount -= 1;
		else
			System.out.println("Não há atividades do tipo aula tradicional para remover.");
	}
	public static int getTraditionalClassesCount() {
		return traditionalClassesCount;
	}
	public static void increasePresentationsCount() {
		presentationsCount += 1;
	}
	public static void decreasePresentationsCount() {
		if (presentationsCount > 0)
			presentationsCount -= 1;
		else
			System.out.println("Não há atividades do tipo apresentações para remover.");
	}
	public static int getPresentationsCount() {
		return presentationsCount;
	}
	public static void increaseLaboratoriesCount() {
		laboratoriesCount += 1;
	}
	public static void decreaseLaboratoriesCount() {
		if (laboratoriesCount > 0)
			laboratoriesCount -= 1;
		else
			System.out.println("Não há atividades do tipo laboratório para remover.");
	}
	public static int getLaboratoriesCount() {
		return laboratoriesCount;
	}
}