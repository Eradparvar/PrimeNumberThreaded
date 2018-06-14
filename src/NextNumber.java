/*
 * This is a class that controls the numbers the threads work on
 * so each one gets the "next number". The main reason I made 
 * this class is so that each thread will have a reference to
 * the class instead of a copy. There may have been better ways
 * to do this (although I have run into issues doing this with
 * Integer..) but this definitely works. 
 */

public class NextNumber {
    private int curr;
    private int limit; // Store the limit in this class too

    public NextNumber(int start, int limit) {
	this.curr = start;
	this.limit = limit;
    }

    public int getLimit() {
	return limit;
    }

    public synchronized int getNext() {
	return curr++;
    }
}