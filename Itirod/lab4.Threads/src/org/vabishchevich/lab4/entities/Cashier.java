package org.vabishchevich.lab4.entities;

import org.apache.log4j.Logger;

public class Cashier extends Thread {

	private static final int CASHIER_SLEEP = 500;
	private Bank bank;
	private static Logger log = Logger.getLogger(Cashier.class.getSimpleName());

	public Cashier(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (bank.getQueue()) {
					bank.getQueue().wait();
				}
				PendingClientOperation operation = bank.getQueue().remove();
				Thread.sleep(CASHIER_SLEEP);
				boolean success = bank.performOperation(operation);
				log.info(String.format("%s: %s\n", operation.toString(),
						success ? "success" : "rejected"));
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}
