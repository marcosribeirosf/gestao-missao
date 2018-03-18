package com.algaworks.missao.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.missao.model.Missao;
import com.algaworks.missao.repository.Missões;

@Controller
@RequestMapping("/missoes")
public class MissoesController {

	@Autowired
	private Missões missoes;

	@GetMapping()
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaMissoes");
		List <Missao> lista = missoes.findAll();
		mv.addObject("missoes",lista);
		mv.addObject(new Missao());
		return mv;
	}
	
	//Salvar imagem em diretorio
	
	private static String UPLOADED_FOLDER = "C:\\Users\\Marcos\\Documents\\workspace-sts\\GestaoMissao\\src\\main\\resources\\static\\images";

	@PostMapping()
	public String salvar(Missao f, HttpServletRequest request, @RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) throws IOException{
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile files =  multipartRequest.getFile("file");
		
		byte[] bytes = file.getBytes();
		Path path = Paths.get (UPLOADED_FOLDER + file.getOriginalFilename());
		Files.write(path, bytes);
		
		f.setIntinerario(files.getOriginalFilename());
		missoes.save(f);

/*		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Selecione uma foto");
			return "missoes";
		}

		try {

			byte[] bytes = file.getBytes();
			Path path = Paths.get (UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

			redirectAttributes.addFlashAttribute("message",
					"Upload feito com sucesso! '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}*/

		return "redirect:/missoes";
	}
	
	
	//	Recuperar imagem em diretorio
		
/*	@RequestMapping(value = "/image/{image_id}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> getImage(@PathVariable("image_id") Long imageId) throws IOException {
		byte[] imageContent = festas.findOne(imageId).getImage();
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}*/
		

	//URL de chamada http://.../excluir/1234				
	@RequestMapping(value = "/excluir/{id}")
	public String excluirFestaByPathVariable(@PathVariable Long id, RedirectAttributes attributes)	{
		this.missoes.delete(id);
		attributes.addFlashAttribute("mensagem", "Missão excluída com sucesso!");
		return "redirect:/missoes";
	}

	//URL de chamada http://.../alterar/1234
	@RequestMapping(value = "/alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("ListaMissoes");
		List <Missao> lista = missoes.findAll();
		mv.addObject("missoes",lista);
		Missao missao = missoes.findOne(id);
		mv.addObject(missao);
		return mv;
	}

}