
public class Counter {
	
	private int counter;
	private String name;
	
	public Counter(String name) {
		this.name = name;
		this.counter = 0;
	}

	public void increase(){
		this.counter += 1;
	}
	
	public void decrease(){
		this.counter -= 1;
	}
	
	public int getCount(){
		return this.counter;
	}
	
	public String getName(){
		return this.name;
	}

}
