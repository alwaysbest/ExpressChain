package com.exp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
	@RequestMapping("/")
	String home() {
		return "hello world";
	}
}
