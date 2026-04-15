public class StopwatchApp {

    // Output: 
    // Stopwatch Started...
    //Stopwatch Stopped...
    //Elapsed Time: 2502 ms
    //Resuming Stopwatch...
    //Stopwatch Started...
    //Stopwatch Stopped...
    //Elapsed Time: 4007 ms
    //Stopwatch Reset.
    //Elapsed Time: 0 ms


    // Inner Stopwatch class (Encapsulation)
    static class Stopwatch {
        private long startTime;
        private long elapsedTime;
        private boolean isRunning;

        public Stopwatch() {
            startTime = 0;
            elapsedTime = 0;
            isRunning = false;
        }

        public void start() {
            if (!isRunning) {
                startTime = System.currentTimeMillis();
                isRunning = true;
                System.out.println("Stopwatch Started...");
            } else {
                System.out.println("Already running!");
            }
        }

        public void stop() {
            if (isRunning) {
                elapsedTime += System.currentTimeMillis() - startTime;
                isRunning = false;
                System.out.println("Stopwatch Stopped...");
                } else {
                System.out.println("Not running!");
            }
        }

        public void reset() {
            startTime = 0;
            elapsedTime = 0;
            isRunning = false;
            System.out.println("Stopwatch Reset.");
        }

        public long getElapsedTime() {
            if (isRunning) {
                return (System.currentTimeMillis() - startTime) + elapsedTime;
            }
            return elapsedTime;
        }
    }

    // Main method (Simulation)
    public static void main(String[] args) {

        Stopwatch sw = new Stopwatch();

        try {
            // Start
            sw.start();
            Thread.sleep(2500);


             // Stop
            sw.stop();
            System.out.println("Elapsed Time: " + sw.getElapsedTime() + " ms");

            // Resume
            System.out.println("Resuming Stopwatch...");
            sw.start();
            Thread.sleep(1500);

            sw.stop();
            System.out.println("Elapsed Time: " + sw.getElapsedTime() + " ms");

            // Reset
            sw.reset();
            System.out.println("Elapsed Time: " + sw.getElapsedTime() + " ms");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
