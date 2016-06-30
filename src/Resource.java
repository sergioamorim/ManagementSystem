import java.util.ArrayList;

public class Resource {
	private static ArrayList<Resource> resources = new ArrayList<Resource>();
	
	private int id;
	private String status;
	
	public Resource(int id, String status) {
		this.setId(id);
		this.setStatus(status);
		Resource.resources.add(this);
	}
	
	public String toString(){
		return super.toString()+" ID: "+this.id+" Status: "+this.status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}