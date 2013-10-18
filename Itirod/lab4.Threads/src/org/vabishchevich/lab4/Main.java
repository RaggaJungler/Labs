package org.vabishchevich.lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.vabishchevich.lab4.entities.Bank;
import org.vabishchevich.lab4.entities.Cashier;
import org.vabishchevich.lab4.entities.Client;
import org.vabishchevich.lab4.entities.PendingClientOperation;

public class Main {

	private static final int CLIENT_START_MONEY = 500;

	public static void main(String[] args) {
		List<Client> clients = new ArrayList<Client>();
		Bank bank = new Bank();

		for (int i = 0; i < 10; i++) {
			Client client = new Client("Client " + (i + 1));
			client.addPurseMoney(CLIENT_START_MONEY);
			clients.add(client);
			bank.registerClient(client);
		}

		for (int i = 0; i <= 4; i++) {
			new Cashier(bank).start();
		}

		new Supervisor(bank).start();

		while (true) {
			Collections.shuffle(clients);

			bank.addOperation(PendingClientOperation.createRandom(clients
					.get(0)));

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}
