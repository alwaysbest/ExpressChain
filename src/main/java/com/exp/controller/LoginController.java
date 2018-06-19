package com.exp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.model.Employer;
import com.exp.model.User;
import com.exp.service.EmpService;
import com.exp.service.UserService;

import net.sf.json.JSONObject;

@RestController
public class LoginController {
	@Autowired
	private EmpService empService;
	@RequestMapping(value="logincheck")
	public JSONObject getLogin(@RequestParam("userid") int userid) {
		JSONObject jsonObject=new JSONObject();
		Employer employer  = empService.getEmpById(userid);
		if(employer!=null) {
			jsonObject.put("id", employer.geteId());
			jsonObject.put("type", employer.getType());
			jsonObject.put("address", employer.getaId());
			return jsonObject;
		}else {
			return null;
		}
		
		
	}
}
