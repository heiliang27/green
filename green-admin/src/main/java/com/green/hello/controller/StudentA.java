package com.green.hello.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentA {
	@Autowired
	StudentB studentB;
	
	public void sortList(List<String> list){
		 Collections.sort(list);  
	}

}
