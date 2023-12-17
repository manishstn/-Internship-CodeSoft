package com.atminterface.validation;

import java.util.HashMap;

import com.atminterface.bankaccount.BankAccount;

public class ValidationRules {

	public static void checkForAcNo(HashMap<Integer, BankAccount> map, int num) throws Validation{
		if(map.containsKey(num)) {
			throw new Validation("Duplicate Account Found");
		}
		else {
			System.out.println("continue...");
		}
	}
	
	public static boolean checkForMinBalance(double amt) throws Validation{
		if(amt < 500) {
			throw new Validation("Sufficiant Balance is not available");
		}
		return true;
	}
}
