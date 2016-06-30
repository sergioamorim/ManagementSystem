public class User {
	public static Counter counter = new Counter("usuários");
	
	public User (int id, String name, String email){
		User.counter.increase();
	}
	
	
	public String toString() {
		return super.toString()+" ID: "+this.id+
				"Nome: "+this.name;
	}
	
	private int id;
	private String name;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}