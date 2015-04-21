package bank;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import bank.security.AccountAddress;
import security.Password;

public abstract class Account {

	protected double balance;
	protected Password pin;
	public AccountAddress accountNumber;
	protected Customer owner;
	protected ArrayList<Transaction> transactions;
	protected File transactionsFile;
	
	public void withdrawal(double amount, String pin){
		if(this.pin.toString().equals(pin)){
			this.balance -= amount;
			double bal = this.balance+amount;
			double diff = amount;
			String type = "withdrawal";
			this.transactions.add(new Transaction(bal, diff, type));
		}
	}
	
	public void deposit(double amount){
		this.balance += amount;
		double bal = this.balance-amount;
		double diff = amount;
		String type = "deposit";
		this.transactions.add(new Transaction(bal, diff, type));
	}
	
	public double getBal(){
		return this.balance;
	}
	
	public String printBal(){
		DecimalFormat balFormat = new DecimalFormat("##00.00");
		return balFormat.format(this.balance);
	}
	
	public Object[] setPin(String old, String pin, String confirm){
		if(old.equals(this.pin.toString())){
			if(pin.equals(confirm)){
				this.pin = new Password(pin);
				return new Object[]{true, "Pin set to " + this.pin};
			}
			else{
				return new Object[]{false, "Sorry, the new pin and the confirmation pin must be the same."};
			}
		}
		else{
			return new Object[]{false, "Sorry, that is not the correct pin."};
		}
	}
	
	public Customer getOwner(){
		return this.owner;
	}
	
	public boolean transfer(double amount, String pin, Account target){
		try{
			this.withdrawal(amount, pin);
			target.deposit(amount);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean checkPin(String pinToCheck){
		if(pinToCheck.equals(this.pin.toString())){
			return true;
		}
		else {
			return false;
		}
	}
}
