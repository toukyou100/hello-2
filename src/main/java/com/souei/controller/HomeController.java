package com.souei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
    private HelloService helloService;
	
	@GetMapping("/")
	public String index(@ModelAttribute Sample sample) {
		
		return "index";
	}
	
	@PostMapping("/loginSubmit")
	public String confirm(@Validated @ModelAttribute Sample sample, BindingResult result) {
		
		if(result.hasErrors()) {
			return "index";
		}
		
		return "confirm";
	}
	
	@RequestMapping(value = "emp")
	public String init(Model model) {

		List<HelloBean> list = helloService.selectName();
		model.addAttribute("list", list);

		return "emp";
	}
}
