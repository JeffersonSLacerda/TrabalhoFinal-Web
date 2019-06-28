package com.ufc.web.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufc.web.restaurante.domain.Chefe;
import com.ufc.web.restaurante.service.ChefeService;

@Controller
@RequestMapping("/chefe")
public class ChefeController {
	
	@Autowired
	private ChefeService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Chefe chefe) {
		return "/chefe/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("chefe", service.findAll());
		
		return "/chefe/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Chefe chefe, RedirectAttributes attr) {
		service.save(chefe);
		attr.addFlashAttribute("success", "Chefe inserido com sucesso.");
		
		return "redirect:/chefe/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar( @PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("chefe", service.findById(id));
		
		return "/chefe/cadastro";
	}
	
	@PostMapping("/editar")
	public String  editar( Chefe chefe, RedirectAttributes attr) {
		service.update(chefe);
		attr.addFlashAttribute("success", "Chefe editado com sucesso.");
		
		return "redirect:/chefe/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		if(service.chefeTemPrato(id)){
			model.addAttribute("fail", "Chefe não removido. Possui prato(s) vinculado(s)");
		} else {
			service.delete(id);
			model.addAttribute("success", "Chefe removido com sucesso");
		}
		
		return listar(model);
	}
}
