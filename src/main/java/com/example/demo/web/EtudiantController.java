package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.dao.EtudiantRepository;
import com.example.demo.entities.Etudiant;

@Controller
@RequestMapping(value="/Etudiant")
public class EtudiantController {

	@Autowired
	private EtudiantRepository etudiantRepository;

	public EtudiantController() {}
	
	@RequestMapping(value="/index")
	public String Index(Model model, @RequestParam(name="page", defaultValue="0") int p, 
									@RequestParam(name="motClef", defaultValue="") String mc) {
		
		Page<Etudiant> list_etudiants = etudiantRepository.findByKey("%"+mc+"%", PageRequest.of(p, 4));
		
		int pagesCount = list_etudiants.getTotalPages();
		int[] pages = new int[pagesCount];
		
		for(int i = 0; i<pagesCount;i++) {
			pages[i] = i;
		}
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motClef", mc);
		model.addAttribute("etudiants",  list_etudiants); 
		return "etudiants";
	}
}
