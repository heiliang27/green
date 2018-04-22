package com.green.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentB {
	@Autowired
	StudentA studentA;
}
