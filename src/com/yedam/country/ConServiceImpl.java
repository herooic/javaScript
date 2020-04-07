package com.yedam.country;

import java.util.List;

public class ConServiceImpl implements ConService {
	
	ConDAO dao = new ConDAO();

	@Override
	public List<Country> getConList() {
		return dao.getConList();
	}
	

}
