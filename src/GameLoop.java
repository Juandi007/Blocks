public class GameLoop {
	public static boolean running = true;
	
	public static void main(String[] args) {
		final int FPS = 60;
		
		long startTime = -1;
		long endTime = -1;
		double totalTimeMS = -1;
		
		while (running) {
			startTime = System.nanoTime();
			
			update();
			render();
			
			endTime = System.nanoTime();
			
			while ( (endTime - startTime) < (1000000000 / FPS) ) {
				Thread.yield();
				
				endTime = System.nanoTime();
			}
			
			
			totalTimeMS = (endTime - startTime) / 1000000000.;
			//System.out.println("startTime = " + startTime);
			//System.out.println("endTime   = " + endTime);
			System.out.println("Total time in loop: " + totalTimeMS + " s");
		}
	}
	
	public static void update() {
		System.out.println("Updating game...");
	}
	
	public static void render() {
		System.out.println("Rendering game...");
	}
}