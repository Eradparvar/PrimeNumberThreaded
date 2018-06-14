
/* The class that is the thread itself */

import java.util.ArrayList;

public class PrimeFindingThread implements Runnable {
    public static Boolean isPrime(int n) {
	if (n == 0 || n == 1)
	    return false;
	if (n == 2)
	    return true;

	Boolean prime = true;
	for (int i = 2; i <= Math.sqrt(n); i++)
	    if (n % i == 0) {
		prime = false;
		break;
	    }

	return prime;
    }

    private NextNumber nextNumber; // Passed in to ctor, shared by all threads

    private ArrayList<Integer> results; // Passed in to ctor, shared by all threads

    public PrimeFindingThread(NextNumber nextNumber, ArrayList<Integer> results) {
	this.nextNumber = nextNumber;
	this.results = results;
    }

    @Override
    public void run() {
	Boolean goAgain = true;

	do {
	    int num;
	    // could have made local variable nextNumber..()
	    num = nextNumber.getNext();

	    if (num > nextNumber.getLimit())
		break;

	    // Next line is for testing/debugging, uncomment it to see which threads gets
	    // which numbers
	    // System.out.println("Thread " + Thread.currentThread().getId() + " examining "
	    // + num);

	    if (isPrime(num)) {
		synchronized (results) {
		    results.add(num);
		}
	    }
	} while (goAgain);

    }

}