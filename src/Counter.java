
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
		if (this.counter < 1) {
			System.out.print("ERRO! O contador de ");
			System.out.print(this.name);
			System.out.println(" está zerado e houve uma requisição para decrementá-lo!");
		}
		else {
			this.counter -= 1;
		}
	}
	
	public int getCount(){
		return this.counter;
	}
	
	public String getName(){
		return this.name;
	}

}
