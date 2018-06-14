import java.util.ArrayList;
import java.util.Collections;

public class Program {

    public static void main(String[] args) throws Exception {
	final int LIMIT = 3000;

	// one NextNumber object that will be shared by all threads
	NextNumber nn = new NextNumber(1, LIMIT);
	// one ArrayList for results that will be shared by all threads
	ArrayList<Integer> results = new ArrayList<Integer>();
	ArrayList<Thread> threads = new ArrayList<Thread>();

	// can choose to use different numbers of threads based on what is best in any
	// configuration
	final int NUM_THREADS = 10;

	for (int i = 0; i < NUM_THREADS; i++) {
	    Thread t = new Thread(new PrimeFindingThread(nn, results));
	    threads.add(t);
	    t.start();
	}

	// Wait for all threads to finish before displaying results
	for (Thread t : threads)
	    t.join();

	// Numbers may have been added out of order, comment out the sort
	// to see the order in which they were actually added
	Collections.sort(results);
	;
	for (int i : results)
	    System.out.println(i);

    }

}