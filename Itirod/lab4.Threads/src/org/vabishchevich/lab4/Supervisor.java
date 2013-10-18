package org.vabishchevich.lab4;

import org.apache.log4j.Logger;
import org.vabishchevich.lab4.entities.Account;
import org.vabishchevich.lab4.entities.Bank;
import org.vabishchevich.lab4.entities.Client;

public class Supervisor extends Thread {
	
	private static final int SUPERVISOR_SLEEP = 2000;
	private Bank bank;
	private static Logger log = Logger.getLogger(Supervisor.class
			.getSimpleName());

	public Supervisor(Bank bank) {
		this.bank = bank;
	}

	private int getTotalAmount() {
		bank.getSupervisorLock().lock();
		int total = 0;
		for (Account account : bank.getAccounts())
			total += account.getSumm();
		for (Client client : bank.getClients())
			total += client.getPurse();
		bank.getSupervisorLock().unlock();
		return total;
	}

	@Override
	public void run() {
		int amount = getTotalAmount();
		while (true) {
			try {
				Thread.sleep(SUPERVISOR_SLEEP);
			} catch (InterruptedException e) {
				break;
			}
			int newAmount = getTotalAmount();
			log.info(String.format("--- Status: %s, total: %d\n",
					newAmount == amount ? "OK" : "error!", newAmount));

		}
	}
}
