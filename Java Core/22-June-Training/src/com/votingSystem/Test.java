// .Write a program ,here we define an enum called AgeCategory which represents the eligibility for voting. 
// It has two enum values: ELIGIBLE and INELIGIBLE, each with a corresponding message. 
// The checkVotingEligibility() method takes an age as input and returns the appropriate AgeCategory based on the age.
// create a  method, we set an age value (in this case, 20) and call the checkVotingEligibility() method to determine the eligibility. 
// Finally, we print the age and the eligibility message based on the results.

package com.votingSystem;
import java.util.Scanner;

enum AgeCategory {
	ELIGIBLE, INELIGIBLE;
}

class VotingSystem {
	int ageValue = 20;
	
	public void checkEligibility(int age) {
		if(age < ageValue) {
			System.out.println(AgeCategory.INELIGIBLE);
		} else {
			System.out.println(AgeCategory.ELIGIBLE);
		}
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		VotingSystem vts = new VotingSystem();
		System.out.println("Enter your age: ");
		int age = scn.nextInt();
		vts.checkEligibility(age);

	}

}
