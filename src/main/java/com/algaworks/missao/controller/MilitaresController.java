package com.algaworks.missao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.missao.model.Militar;
import com.algaworks.missao.repository.Militares;
import com.algaworks.missao.repository.Missões;

@Controller
@RequestMapping("/militares")
public class MilitaresController {

	@Autowired
	private Militares militares;
	@Autowired
	private Missões missoes;

	@GetMapping()
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaMilitares");
		List <Militar> lista = militares.findAll();
		mv.addObject("militares",lista);
		mv.addObject("todasMissoes", missoes.findAll());
		mv.addObject(new Militar());
		return mv;
	}

	@PostMapping()
	public String salvar(Militar c) {
		militares.save(c);
		return "redirect:/militares";

	}

	//URL de chamada http://.../excluir/1234				
	@RequestMapping(value = "/excluir/{id}")
	public String excluirConvidadoByPathVariable(@PathVariable Long id, RedirectAttributes attributes)	{
		this.militares.delete(id);
		attributes.addFlashAttribute("mensagem", "Militar excluído com sucesso!");
		return "redirect:/militares";
	}

	//URL de chamada http://.../alterar/1234
	@RequestMapping(value = "/alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("ListaMilitares");
		List <Militar> lista = militares.findAll();
		mv.addObject("militares",lista);
		Militar militar = militares.findOne(id);
		mv.addObject(militar);
		return mv;
	}

}
