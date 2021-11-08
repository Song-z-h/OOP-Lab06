package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
/**
 * JUnit test to test {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

	/**
	 * Used to test Exceptions on {@link StrictBankAccount}.
	 */
	@Test
	public void testBankOperations() {
		/*
		 * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a scelta,
		 * con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
		 * 
		 * 2) Effetture un numero di operazioni a piacere per verificare che le
		 * eccezioni create vengano lanciate soltanto quando opportuno, cioè in presenza
		 * di un id utente errato, oppure al superamento del numero di operazioni ATM
		 * gratuite.
		 */

		BankAccount acc2 = new StrictBankAccount(2, 10000, 10);
		BankAccount acc1 = new StrictBankAccount(1, 10000, 10);

		try {
			acc1.deposit(3, 1);
			fail();
		} catch (WrongAccountHolderException | NotEnoughFundsException | TransactionsOverQuotaException e1) {
			assertNotNull(e1);
		}

		try {
			acc1.withdraw(1, 1000000);
			fail();
		}  catch (WrongAccountHolderException | NotEnoughFundsException | TransactionsOverQuotaException e2) {
			assertNotNull(e2);
		}

		try {
			for (int i = 0; i < 11; i++) {
				acc2.depositFromATM(2, 1);
			}
			fail("exceeded the maximum amount of ATM transactions");

		}  catch (WrongAccountHolderException | NotEnoughFundsException | TransactionsOverQuotaException e3) {
			assertNotNull(e3);
		}

	}
}
