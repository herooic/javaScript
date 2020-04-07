package com.yedam.country;

import java.util.List;

public class ConMain {

	public static void main(String[] args) {
		
		ConService service = new ConServiceImpl();
		List<Country> list = service.getConList();
		
		for(Country c : list) {
			System.out.println(c.toString());
		}
	}
}
