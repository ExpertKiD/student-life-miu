//package bank.repository;
//
//import bank.domain.Account;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Repository("accountRepository")
//public class AccountRepositoryImpl implements AccountRepository  {
//	Collection<Account> accountlist = new ArrayList<>();
//
//	public void saveAccount(Account account) {
//		// System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
//		accountlist.add(account); // add the new
//	}
//
//	public void updateAccount(Account account) {
//		// System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
//		Account accountexist = loadAccount(account.getAccountNumber());
//		if (accountexist != null) {
//			accountlist.remove(accountexist); // remove the old
//			accountlist.add(account); // add the new
//		}
//
//	}
//
//	public Account loadAccount(long accountNumber) {
//		// System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
//		for (Account account : accountlist) {
//			if (account.getAccountNumber() == accountNumber) {
//				return account;
//			}
//		}
//		return null;
//	}
//
//	public Collection<Account> getAccounts() {
//		return accountlist;
//	}
//
//}
