package com.main.app;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatFact {

	String fact;
	int length;
	
	@Override
	public String toString() {
		return "CatFact [fact=" + fact + ", length=" + length + "]";
	}
	
}