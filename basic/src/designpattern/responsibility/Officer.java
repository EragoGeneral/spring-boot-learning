package designpattern.responsibility;

public abstract class Officer {

	protected String name;
	
	protected Officer successor;

	public Officer(String name) {
		super();
		this.name = name;
	}

	public void setSuccessor(Officer successor) {
		this.successor = successor;
	}
	
	public abstract void handleMission(Mission mission);
}
