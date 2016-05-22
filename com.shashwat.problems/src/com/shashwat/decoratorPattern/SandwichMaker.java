package com.shashwat.decoratorPattern;

public class SandwichMaker {
	public static void main(String[] args) {
		Sandwich sandwich = new WhiteBreadSandWich("White bread sandwich");
		System.out.printf("Price of %s is $%.2f %n", sandwich.getDescription(),
				sandwich.price());
		
		sandwich = new CheeseDecorator(sandwich);
		System.out.printf("Price of %s is $%.2f %n", sandwich.getDescription(),
				sandwich.price());
	}
}
