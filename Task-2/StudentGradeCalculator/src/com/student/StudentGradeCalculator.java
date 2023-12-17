package com.student;

import java.util.Scanner;

public class StudentGradeCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Marks of Subject-1");
		int sub1 = sc.nextInt();
		
		System.out.println("Enter the Marks of Subject-2");
		int sub2 = sc.nextInt();

		System.out.println("Enter the Marks of Subject-3");
		int sub3 = sc.nextInt();
		
		int sum = sub1 + sub2 + sub3;
		
		double avg = (double)sum / 3;
		System.out.println("---------------------------");
		System.out.println("Total Marks : "+sum);
		System.out.println("---------------------------");
		System.out.println("Average Percentage : "+avg);
		System.out.println("---------------------------");
		
		if(avg >= 75) {
			System.out.println("Grade : A+");
		}
		else if(avg >= 60 && avg < 75) {
			System.out.println("Grade : A");
		}
		else if(avg >= 40 && avg < 60) {
			System.out.println("Grade : B");
		}
		else {
			System.out.println("Fail");
		}
		System.out.println("---------------------------");
	}

}
