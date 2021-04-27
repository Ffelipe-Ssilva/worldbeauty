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
	
	@GetMapping(value = "/cadastrocli")
	public String cadastro() {
		return "cadastro";
	}
	
	@GetMapping(value = "/mediaidade")
	public String avgcliente() {
		return "idadeavg";
	}
	
	@GetMapping(value = "/listacli")
	public String listcliente() {
		return "listacli";
	}
	
	@GetMapping(value = "/listacligen")
	public String listclientegen() {
		return "listacligen";
	}
	
	@GetMapping(value = "/servpopgen")
	public String servpopgen() {
		return "servpopgen";
	}
	
	@GetMapping(value = "/servpop")
	public String servpop() {
		return "servpop";
	}
	
	@GetMapping(value = "/editarcli")
	public String editcli() {
		return "editarcli";
	}
	
	@GetMapping(value = "/agendar")
	public String agendar() {
		return "agendar";
	}
}
 