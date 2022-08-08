package com.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafio.entidades.Casa;
import com.desafio.repository.CasaRepository;

@Controller
@RequestMapping("/")

public class CasaController {
	
	@Autowired
	private CasaRepository repo;	

	@GetMapping
	public String index() {
		return "index";
	}

	@GetMapping("/cadastro")
	public String formCadastro() {
		return "cadastro";
	}

	@GetMapping("/consulta")
	public String formConsulta(Model model) {
		Iterable<Casa> itens = repo.findAll();
		model.addAttribute("itens", itens);
		return "consulta";
	}
	
	@GetMapping("/consulta/{iditem}")
	public String formEditar(@PathVariable ("iditem") int id, Model model) {
		Casa item = repo.findById(id).get();
		model.addAttribute("item", item);
		return "edicao";
	}
	
	@PostMapping("/cadastro")
	public String salvar (Casa item) {
		repo.save(item);
		return "redirect:/consulta";
	}
	
	
	@GetMapping("/delete/{iditem}")
	public String delete(@PathVariable ("iditem") int id) {
		repo.deleteById(id);
		return "redirect:/consulta";
	}
}
