package com.atminterface.utils;

import java.util.HashMap;

import com.atminterface.bankaccount.BankAccount;
import com.atminterface.validation.Validation;

public class Utils {
	public static HashMap<Integer,BankAccount> customers() throws Validation{
		HashMap<Integer, BankAccount> customer = new HashMap<>();
		customer.put(1, new BankAccount(1, "Rohit",454545.45));
		customer.put(2, new BankAccount(2, "Virat", 181818.18));
		customer.put(3, new BankAccount(3, "Dhoni", 707070.70));
		return customer;
	}

}
