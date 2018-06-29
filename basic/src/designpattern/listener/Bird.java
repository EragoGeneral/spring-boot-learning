package designpattern.listener;

public class Bird implements Observer {
	private int num;

	public Bird(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public void breakfast(){
		System.out.println("Bird" + getNum() + " do the breakfast time.");
	}
	
	@Override
	public void bed(){
		System.out.println("Bird" + getNum() + " do the bed time.");
	}
}
