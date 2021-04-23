package com.world.beauty.resource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PathController {

	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
	@GetMapping(value = "/cadlistcliente")
	public String cadlistcliente() {
		return "cadlistcliente";
	}
	
}
 