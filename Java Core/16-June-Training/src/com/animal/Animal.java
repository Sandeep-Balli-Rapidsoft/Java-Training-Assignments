// Create a class called "Animal" with a method "sound()". 
// Create two subclasses, "Cat" and "Dog", that inherit from the "Animal" class and override the "sound()" 
// method to make different sounds for each subclass.

package com.animal;

class AnimalSuperClass {
	public void sound() {
		System.out.println("Animal is making sound");
	}
}

class Cat extends AnimalSuperClass {
	@Override
	public void sound() {
		System.out.println("Cat is saying Meow..");
	}
}

class Dog extends AnimalSuperClass {
	@Override
	public void sound() {
		System.out.println("Dog is barking..");
	}
}

public class Animal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalSuperClass cat = new Cat();
		cat.sound();
		AnimalSuperClass dog = new Dog();
		dog.sound();

	}

}
