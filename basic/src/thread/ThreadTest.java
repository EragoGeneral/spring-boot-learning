package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
	private Lock lock = new ReentrantLock();
	private Condition conditionA = lock.newCondition();
	private Condition conditionB = lock.newCondition();
	private Condition conditionC = lock.newCondition();
	private String threadName = "A";

	class ThreadA implements Runnable {
		@Override
		public void run() {
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					while (!Thread.currentThread().getName().equals(threadName)) {
						conditionA.await();
					}
					System.out.print(Thread.currentThread().getName());
					threadName = "B";
					conditionB.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	class ThreadB implements Runnable {
		@Override
		public void run() {
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					while (!Thread.currentThread().getName().equals(threadName)) {
						conditionB.await();
					}
					System.out.print(Thread.currentThread().getName());
					threadName = "C";
					conditionC.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	class ThreadC implements Runnable {
		@Override
		public void run() {
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					while (!Thread.currentThread().getName().equals(threadName)) {
						conditionC.await();
					}
					System.out.print(Thread.currentThread().getName());
					threadName = "A";
					conditionA.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		ThreadTest threadTest = new ThreadTest();
		Thread threadA = new Thread(threadTest.new ThreadA());
		Thread threadB = new Thread(threadTest.new ThreadB());
		Thread threadC = new Thread(threadTest.new ThreadC());
		threadA.setName("A");
		threadB.setName("B");
		threadC.setName("C");
		threadA.start();
		threadB.start();
		threadC.start();
	}

}
