package com.exp.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	@RequestMapping(value="/hello")
	public String getHelloView() {
		return "hello";
	}
	@RequestMapping(value="/login")
	public String getLoginView() {
		return "login";
	}
	@RequestMapping(value="/checkOrder")
	public String getCheckOrderView() {
		return "checkOrder";
	}
	@RequestMapping(value="/access")
	public String getAccessView() {
		return "access";
	}
	@RequestMapping(value="/bankAccount")
	public String getAccountView() {
		return "bankAccount";
		
	}
	@RequestMapping(value="/buildOrder")
	public String getBuildOrderView() {
		return "buildOrder";
	}
	@RequestMapping(value="/checkinBOrder")
	public String getCheckinBOrderView() {
		return "checkinBOrder";
	}
	@RequestMapping(value="/checkinWOrder")
	public String getCheckinWOrderView() {
		return "checkinWOrder";
	}
	@RequestMapping(value="/checkoutBOrder")
	public String getCheckoutBOrderView() {
		return "checkoutBOrder";
	}
	@RequestMapping(value="/checkoutWOrder")
	public String getCheckoutWOrderView() {
		return "checkoutWOrder";
	}
	@RequestMapping(value="/manageEmployer")
	public String getManageEmployer() {
		return "manageEmployer";
	}
	@RequestMapping(value="/bill")
	public String getBillView() {
		return "bill";
	}
	@RequestMapping(value="/manageShelf")
	public String getManageShelfView() {
		return "manageShelf";
	}
	@RequestMapping(value="/memberLogin")
	public String getMemberLoginView() {
		return "memberLogin";
	}
	@RequestMapping(value="/buildpreOrder")
	public String getBuildpreOrderView() {
		return "buildpreOrder";
	}
	@RequestMapping(value="/managePreOrder")
	public String getManagePreOrderView() {
		return "managePreOrder";
	}
	@RequestMapping(value="/checkmemOrder")
	public String getCheckMemOrderView() {
		return "checkmemOrder";
	}
	
	
	


}
