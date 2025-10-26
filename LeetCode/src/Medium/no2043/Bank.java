package Medium.no2043;

class Bank {

	long[] balance;

	public Bank(long[] balance) {
		this.balance = balance;
	}

	public boolean transfer(int account1, int account2, long money) {
		if (isValidAccount(account1, account2)) {
			if (withdraw(account1, money)) {
				return deposit(account2, money);
			}
		}
		return false;
	}

	public boolean deposit(int account, long money) {
		if (isValidAccount(account)) {
			balance[account - 1] += money;
			return true;
		}
		return false;
	}

	public boolean withdraw(int account, long money) {
		if (isValidAccount(account) && balance[account - 1] >= money) {
			balance[account - 1] -= money;
			return true;
		}
		return false;
	}

	private boolean isValidAccount(int... accounts) {
		boolean result = true;
		for (int account : accounts) {
			result &= 0 <= account - 1 && account - 1 < balance.length;
		}
		return result;
	}
}