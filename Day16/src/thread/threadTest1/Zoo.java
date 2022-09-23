package thread.threadTest1;

public class Zoo {
	public static void main(String[] args) {
		String[] sounds = {"어흥", "우끼끼", "아아앙ㄱ!!"};
		Animal[] animals = new Animal[3];
		Thread[] threads = new Thread[3];
		
		for (int i = 0; i < animals.length; i++) {
			animals[i] = new Animal();
			threads[i] = new Thread(animals[i], sounds[i]);
			}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
			if (i!=0) {
				try {threads[i].join();}
				catch (InterruptedException e) {;}
			}
		}
	}

}
