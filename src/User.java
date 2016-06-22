
public class User {
	private static int count = 0;
	
	public User (){
		increaseCount();
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

	public static int getCount() {
		return count;
	}

	public static void increaseCount() {
		count += 1;
	}
	
	public static void decreaseCount() {
		if (count > 0)
			count -= 1;
		else
			System.out.println("Não há usuários para remover.");
	}
	
}