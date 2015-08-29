package puzzlesolver;

/**
 * Shared sort status class, represent a shared object to communicate the sort
 * status of the puzzle of every thread
 */

public class SharedSortStat {

		private boolean top_done = false;
		private boolean bot_done = false;
		private boolean top_writ = false;

		/**
		 * @return true if top thread has finished his job sorting top half of
		 * the puzzle, otherwise false
		 */

		public synchronized boolean topDone() {
			return top_done;
		}

		/**
		 * @return true if bottom thread has finished his job sorting bottom half of
		 * the puzzle, otherwise false
		 */

		public synchronized boolean botDone() {
			return bot_done;
		}

		/**
		 * @return true if top thread has written his result into the shared
		 * reference of the puzzle, otherwise false
		 */

		public synchronized boolean topWritten() {
			return top_writ;
		}

		// setter for top sorting job

		public synchronized void setTopDone() {
			top_done = true;
		}

		// setter for bottom sorting job

		public synchronized void setBotDone() {
			bot_done = true;
		}

		// setter for written status of top thread

		public synchronized void setTopWritten() {
			top_writ = true;
		}
}
