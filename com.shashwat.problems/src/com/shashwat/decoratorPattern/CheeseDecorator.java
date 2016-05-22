package com.shashwat.decoratorPattern;

import java.math.BigDecimal;

public class CheeseDecorator extends SandWichDecorator {
	private Sandwich currentSandwich;

	public CheeseDecorator(Sandwich sandwich) {
		this.currentSandwich = sandwich;
	}
	
	@Override
	public String getDescription() {
		return this.currentSandwich.getDescription() + ", Cheese";
	}

	@Override
	public BigDecimal price() {
		return this.currentSandwich.price().add(new BigDecimal("0.50"));
	}
}
