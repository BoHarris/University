package com.solvd.university;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Deadlock {
	public String lostChild = "daughter";
	public String lostMother = "mom";

	private static final Logger LOG = LogManager.getLogger(Deadlock.class.getName());

	Thread t1 = new Thread() {
		public void run() {
			while (true) {
				synchronized (lostMother) {
					try {
						LOG.debug(Thread.currentThread().getName() + " " + lostMother + " cannot find her " + lostChild + " Locked");
						Thread.sleep(100);
					} catch (InterruptedException e) {
						LOG.error(e.getMessage());
					}

					synchronized (lostChild) {
						LOG.debug(Thread.currentThread().getName()  + " " + lostChild + " cannot find her " + lostMother + " Locked");
						LOG.debug(lostChild + lostMother);
					}
				}
			}
		}
	};

	Thread t2 = new Thread() {
		public void run() {
			while (true) {
				synchronized (lostChild) {
					LOG.debug(Thread.currentThread().getName() + " " + lostChild + " cannot find her " + lostMother + " Locked");
					synchronized (lostMother) {
						LOG.debug(Thread.currentThread().getName() + " " + lostMother + " cannot find her " + lostChild + " Locked");
						LOG.debug(lostMother + lostChild);
					}
				}
			}
		}
	};
}
