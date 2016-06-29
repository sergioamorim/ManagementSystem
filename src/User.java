import java.util.ArrayList;

public class User {
	public static Counter counter = new Counter("usuários");
	private static ArrayList<User> users = new ArrayList<User>();
	
	public User (){
		User.users.add(this);
		User.counter.increase();
	}
	
	public User findById(int id){
		for (User user : User.users) {
			if (user.getId() == id) {
				return user;
			}
		}
		System.out.println("Usuário não encontrado.");
		return null;
	}
	
	public String toString() {
		return super.toString()+" ID: "+this.id+
				"Nome: "+this.name;
	}
	
	private int id;
	private String name;

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
	
}