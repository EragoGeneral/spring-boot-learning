package thread;

public class PrintABC {

	public static Boolean isThreadA = true;
	public static Boolean isThreadB = false;
	public static Boolean isThreadC = false;
	
	public static void main(String[] args) {
		PrintABC abc = new PrintABC();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++){
					synchronized (abc) {
						while(!isThreadA){
							try {
								abc.wait();
								Thread.sleep(100);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						System.out.print("A");
						isThreadA = false;
						isThreadB = true;
						isThreadC = false;
						abc.notifyAll();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++){
					synchronized (abc) {
						while(!isThreadB){
							try {
								abc.wait();
								Thread.sleep(100);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						System.out.print("B");
						isThreadA = false;
						isThreadB = false;
						isThreadC = true;
						abc.notifyAll();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++){
					synchronized (abc) {
						while(!isThreadC){
							try {
								abc.wait();
								Thread.sleep(100);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						System.out.print("C");
						isThreadA = true;
						isThreadB = false;
						isThreadC = false;
						abc.notifyAll();
					}
				}
			}
		}).start();
	}
	
}
