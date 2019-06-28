package com.ufc.web.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufc.web.restaurante.domain.Chefe;
import com.ufc.web.restaurante.domain.Prato;
import com.ufc.web.restaurante.service.ChefeService;
import com.ufc.web.restaurante.service.PratoService;

@Controller
@RequestMapping("/prato")
public class PratoController {
	
	@Autowired
	private PratoService pratoService;
	@Autowired
	private ChefeService chefeService;

	@GetMapping("/cadastrar")
	public String cadastrar(Prato prato) {
		return "/prato/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pratos", pratoService.findAll());
		
		return "/prato/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Prato prato, RedirectAttributes attr) {
		pratoService.save(prato);
		attr.addFlashAttribute("success", "Prato cadastrado com sucesso!");
		
		return "redirect:/prato/cadastrar";
	}
	
	@ModelAttribute("chefes")
	public List<Chefe> listaChefes() {
		return chefeService.findAll();
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar( @PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("prato", pratoService.findById(id));
		
		return "/prato/cadastro";
	}
	
	@PostMapping("/editar")
	public String  editar( Prato prato, RedirectAttributes attr) {
		pratoService.update(prato);
		attr.addFlashAttribute("success", "Prato editado com sucesso!");
		
		return "redirect:/prato/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pratoService.delete(id);
		attr.addFlashAttribute("success", "Prato removido com sucesso!");
		
		return "redirect:/prato/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String getByName(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("pratos", pratoService.findByName(nome));
		
		return "/prato/lista";
	}
}
