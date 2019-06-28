package com.ufc.web.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufc.web.restaurante.domain.Cliente;
import com.ufc.web.restaurante.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	public ClienteService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		return "/cliente/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cliente", service.findAll());
		
		return "/cliente/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cliente cliente, RedirectAttributes attr) {
		service.save(cliente);
		attr.addFlashAttribute("success", "Cliente cadastrado com sucesso.");
		
		return "redirect:/clientes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar( @PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cliente", service.findById(id));
		
		return "/cliente/cadastro";
	}
	
	@PostMapping("/editar")
	public String  editar(Cliente cliente, RedirectAttributes attr) {
		service.update(cliente);
		attr.addFlashAttribute("success", "Cliente editado com sucesso.");
		
		return "redirect:/clientes/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.delete(id);
		model.addAttribute("success", "CLiente removido com sucesso");
		
		return "redirect:/clientes/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String getByName(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("cliente", service.findByName(nome));
		
		return "/cliente/lista";
	}
	
	@GetMapping("/buscar/email")
	public String getByEmail(@RequestParam("email") String email, ModelMap model) {
		model.addAttribute("cliente", service.findByEmail(email));
		
		return "/cliente/lista";
	}

}
