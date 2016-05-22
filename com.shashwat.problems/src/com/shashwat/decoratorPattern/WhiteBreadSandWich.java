package com.shashwat.decoratorPattern;

import java.math.BigDecimal;

public class WhiteBreadSandWich extends Sandwich {

	public WhiteBreadSandWich(String desc) {
		this.description = desc;
	}
	
	@Override
	public BigDecimal price() {
		return new BigDecimal("3.0");
	}

}
