package designpattern.listener;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		Flower flower = new Flower();
		
		Bird b1 = new Bird(1);
		Bird b2 = new Bird(2);
		Bird b3 = new Bird(3);
		flower.addListener(b1);
		flower.addListener(b2);
		flower.addListener(b3);
		
		flower.setStatus("open");
		
		Thread.sleep(3000);
		
		flower.setStatus("close");
	}
}
