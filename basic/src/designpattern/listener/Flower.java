package designpattern.listener;

public class Flower extends Subject {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		notifyBirds(status);
	}
}
