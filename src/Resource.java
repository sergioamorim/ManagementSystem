import java.time.LocalDateTime;
import java.util.ArrayList;

public class Resource {
	private static ArrayList<Resource> resources = new ArrayList<Resource>();
	
	private int id;
	private String status;
	
	public Resource() {
		Resource.resources.add(this);
	}
	
	public static Resource findById(int id) {
		for (Resource resource : Resource.resources) {
			if (resource.getId() == id) {
				return resource;
			}
		}
		System.out.println("Recurso não encontrado.");
		return null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}