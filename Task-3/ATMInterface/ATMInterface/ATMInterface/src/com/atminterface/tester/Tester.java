package com.atminterface.tester;

import java.util.HashMap;
import java.util.Scanner;

import com.atminterface.bankaccount.BankAccount;
import com.atminterface.utils.Utils;
import com.atminterface.validation.ValidationRules;

public class Tester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			HashMap<Integer, BankAccount> map = Utils.customers();
			int choice = 0;
			Double amt;
			do {
				System.out.printf("1. Create Account\n2. Display all Accounts\n3. Withdraw Amount\n4. Deposite Amount\n5. Exit\n");
				choice = sc.nextInt();
				
				switch(choice) {
				case 1: //Create Account
					
					//Account Number, Account Holder Name, Account Min Balance
					System.out.println("Enter the Account Number : ");
					int acNo = sc.nextInt();
					
					ValidationRules.checkForAcNo(map, acNo);
					
					System.out.println("Enter the Account Holder Name : ");
					String nm = sc.next();
					
					System.out.println("Enter the Account Min Balance : ");
					Double bal = sc.nextDouble();
					
					ValidationRules.checkForMinBalance(bal);
					
					map.put(acNo, new BankAccount(acNo, nm, bal));
					
					System.out.println("Data Added Successfully");
					
					break;
					
				case 2: //Display All Accounts
					
					for(Object b : map.keySet()) {
						System.out.println(map.get(b));
					}
					break;
					
				case 3: //Withdraw Amount
					System.out.println("Enter the Account Number : ");
					int aN = sc.nextInt();
					
					System.out.println("Enter the Amount to be Withdraw : ");
					amt = sc.nextDouble();
					
					int x = 0;
					
					if(map.containsKey(aN)) {
						double val = map.get(aN).withdrawAmount(amt);
						ValidationRules.checkForMinBalance(val);
						System.out.println(amt+" is debited from your account "+aN);
						x = 1;
					}
					
					if(x == 0) {
						System.out.println("Amount is not Debited from your account please check your Account number and Amount");
					}
					break;
					
				case 4: //Deposite Amount
					
					System.out.println("Enter the Account Number : ");
					int aN1 = sc.nextInt();
					
					System.out.println("Enter the Amount to be Deposite : ");
					amt = sc.nextDouble();
					
					int y = 0;
					
					if(map.containsKey(aN1)) {
						double val = map.get(aN1).depositeAmount(amt);
						ValidationRules.checkForMinBalance(val);
						System.out.println(amt+" is added into your account "+aN1);
						y = 1;
					}
					if(y == 0) {
						System.out.println("Amount is not credited into your account please check your Account number and Amount");
					}
					break;
				case 5: //exit
					choice = 0;
					System.out.println("Thank You for using ATM Service... Visit again!");
					break;
				}
			}while(choice != 0);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
