package prime;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class PrimeThread implements Runnable {

	/** Declare variables */
	private long cpu = -1;
	private int number;
	private int notPrimeNumber;
	private int size;
	private int countCol;
	private long ThreadID;

	public PrimeThread(int number, int size) {
		this.number = number;
		this.size = size;
	}

	@Override
	public void run() {
		long cpuTimeBegin = getCpuTime();
		/** call method isPrime for check prime number */
		if (isPrime(number)) {
			/** if method return true, this number is prime number */
			System.out.println("number: " + number + " is Prime number");
		} else {
			/** if method return false, this number isn't prime number */
			System.out.println("number: " + number + " isn't Prime number ");
			System.out.println("Devided number is: ");
			/** Loop for check divisible numbers */
			for (int i = 1; i < size; i++) {
				/** If divisible then print that number */
				if (notPrimeNumber % i == 0) {
					System.out.print(i + "\t");
					/** count column of number */
					countCol++;
					/** new line when number stay full in column */
					if (countCol == 20) {
						/** reset count column */
						countCol = 0;
						System.out.print("\n");
					}
				}
			}
		}
		
		
		
		
		/** Show CPU Time each threads */
		long cputimeEnd = getCpuTime() - cpuTimeBegin;
		System.out.println("\nCPU Time: " + cputimeEnd  +  " nano seconds");
		System.out.print("\n\n");
		
           
	}

	/** Method check Prime Number **/
	public boolean isPrime(int num) {
		/** Declare variables */
		int i;
		

		/** make sure that number must not be an even number */
		if (num % 2 == 0) {
			/** collect even number value for check all divided that even number */
			notPrimeNumber = num;
			return false;
		}
		/** Loop check Prime number step by two */
		for (i = 3; i * i <= num; i += 2) {
			/** If number mod I and equal zero this number isn't prime number */
			if (num % i == 0) {
				/** collect number value for check all divided that number */
				notPrimeNumber = num;
				return false;
			}
		}
		
		
		return true;
	}

	/** Get CPU time in nanoseconds. */
	public long getCpuTime() {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		return bean.isCurrentThreadCpuTimeSupported() ? bean.getCurrentThreadCpuTime() : 0L;
	}

}
