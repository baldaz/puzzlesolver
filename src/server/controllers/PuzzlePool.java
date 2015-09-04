package puzzlesolver;

import java.util.HashMap;

public class PuzzlePool {

	private HashMap<Integer, Puzzle> pool = new HashMap<Integer, Puzzle>();

	public synchronized void add(int i, Puzzle p) {
		pool.put(i, p);
	}

	public synchronized Puzzle get(int i) {
		Puzzle p = pool.get(i);
		return p;
	}
}
