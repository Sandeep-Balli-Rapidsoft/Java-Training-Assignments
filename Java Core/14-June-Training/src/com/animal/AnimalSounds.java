package com.animal;

class Animal {
	protected void makeSound() {
		System.out.println("animal is saying hello..");
	}
}

class Cat extends Animal {
	protected void makeSound() {
		System.out.println("The cat is saying meow..");
	}
}

public class AnimalSounds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat newCat = new Cat();
		newCat.makeSound();

	}

}
