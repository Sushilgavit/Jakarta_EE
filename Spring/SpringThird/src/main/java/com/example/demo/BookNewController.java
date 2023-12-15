package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
@Controller
public class BookNewController
{
	@GetMapping("person")
	public String before()
	{
 		return "view";
	}
	
	
	@PostMapping("person")
	public String afterSubmit(@RequestParam("Name") String Name,@RequestParam("age") int age,@RequestParam("address") String address ,Model model) 
	{
		person p=new person();
		p.setName(Name);
		p.setAge(age);
		p.setAddress(address);
		model.addAttribute("person",p);
		//session.setAttribute("sushil" , p);
		return "success";
	}
}
