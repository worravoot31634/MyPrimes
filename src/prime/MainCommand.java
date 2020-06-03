package prime;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class MainCommand {

	public static void main(String[] args) throws InterruptedException {

		/** check arguments not less than zero */
		if (args.length > 0) {
			/** make sure that arguments not empty */
			if (args[0].isEmpty()) {
				System.err.println(args[0] + " is empty");

			} else { /** if arguments not empty */

				/** Declare variables */
				int FindFrom = Integer.parseInt(args[0]);
				int FindTo = Integer.parseInt(args[1]);
				int SIZE = FindTo - FindFrom;
				int numThread = 0;
				int i = 0;

				/** Declare and Initial array size of Thread */
				Thread[] thrd = new Thread[SIZE + 1];

				/** make sure that start number will not equal zero */
				if (FindFrom == 0) {
					FindFrom = FindFrom + 1;
				}

				/** Start count wall clock time in nano seconds */
				long startTimeNano = System.nanoTime();

				/** Create each Thread for each number */
				for (i = 0; i <= SIZE; i++) {
					/** Initial Threads */
					thrd[i] = new Thread(new PrimeThread(FindFrom++, SIZE));
					/** run thread */
					thrd[i].start();
					
					/** join thread */
					thrd[i].join();
				}
				
		       
				
				

				/** Stop count wall clock time in nano seconds */
				long taskTimeNano = System.nanoTime() - startTimeNano;
				System.out.print("Wall Clock Time: " + taskTimeNano + " nano seconds");

			}

		}

	}

	/** Get CPU time in nanoseconds. */
	public static long getCpuTime(long thrdID) {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		return bean.isCurrentThreadCpuTimeSupported() ? bean.getThreadCpuTime(thrdID) : 0L;
	}

}


class MyThread extends Thread {
    public void run() {
        int sum = 0;
        for (long i = 0; i < 1000000; ++i) {
            sum += i;
        }
        sum = sum + 1;
    }
}
