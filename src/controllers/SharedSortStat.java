package puzzlesolver;

public class SharedSortStat {

		private boolean top_done = false;
		private boolean bot_done = false;
		private boolean top_writ = false;
		private boolean bot_writ = false;

		public synchronized boolean topDone() {
			return top_done;
		}

		public synchronized boolean botDone() {
			return bot_done;
		}

		public synchronized boolean topWritten() {
			return top_writ;
		}

		public synchronized boolean botWritten() {
			return bot_writ;
		}

		public synchronized void setTopDone() {
			top_done = true;
		}

		public synchronized void setBotDone() {
			bot_done = true;
		}

		public synchronized void setTopWritten() {
			top_writ = true;
		}

		public synchronized void setBotWritten() {
			bot_writ = true;
		}
	}
