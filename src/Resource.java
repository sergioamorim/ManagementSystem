
public class Resource {
	private String status;
	private String activity;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		if (this.isValidActivity(activity))
			this.activity = activity;
	}
	
	public boolean isValidActivity(String activity){
		return true;
	}
}

