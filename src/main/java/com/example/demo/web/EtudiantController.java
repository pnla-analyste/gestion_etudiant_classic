package com.example.demo.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;

import com.example.demo.dao.EtudiantRepository;
import com.example.demo.entities.Etudiant;

@Controller
@RequestMapping(value="/Etudiant")
public class EtudiantController {

	@Autowired
	private EtudiantRepository etudiantRepository;

	public static String uploadDirectory = System.getProperty("user.home")+"/uploads/";
	
	public EtudiantController() {}
	
	@RequestMapping(value={"/","/index"})
	public String Index(Model model,  @RequestParam(name = "p", defaultValue = "0") int p,  
															   @RequestParam(name = "mc", defaultValue = "") String mc) {
		
		Page<Etudiant> list_etudiants = etudiantRepository.findAll(PageRequest.of(p, 4));
		
		int pagesCount = list_etudiants.getTotalPages();
		int[] pages = new int[pagesCount];
		
		for(int i = 0; i<pagesCount;i++) {
			pages[i] = i;
		}
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motClef", mc);
		
		if (!mc.equalsIgnoreCase("")) {
			list_etudiants = etudiantRepository.findByKey("%"+mc+"%", PageRequest.of(p, 4));
		}
		
		model.addAttribute("etudiants",  list_etudiants); 
		return "etudiants";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String formAddEtudiant(Model model) {
		model.addAttribute("etudiant", new Etudiant());
		return "formAddEtudiant";
	}
	
	@RequestMapping(value="/addEtudiant", method=RequestMethod.POST)
	public String create(Etudiant e,  @RequestParam(name = "image") MultipartFile file) throws Exception {
	
		//1- Ecriture logique (Inserer dans la table etudiant un enregistrement de type etudiant avec le nom de sa photo)
		if (!(file.isEmpty())) { 
			 e.setPhoto(file.getOriginalFilename());
		}
		
		Etudiant et = etudiantRepository.save(e);
		 
		if (!(file.isEmpty())) { 
			
			//2- Ecriture physique (Mettre dans le dossier upload l'image)
			   //2.1- Nom du fichier (Nom du flux : contenant)
			 		StringBuilder fileName = new StringBuilder();
			 		String name = String.valueOf(et.getId());
			 		fileName.append(name);
			 		Path fileNameAndPath = Paths.get(uploadDirectory, fileName.toString());
			  //2.2- Contenu du fichier (Flux physique : contenu)
			 		Files.write(fileNameAndPath, file.getBytes());	
		}
		
		 return "redirect:index";
	}
	
	@RequestMapping(value="/getPhoto", 
			produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getEtudiantPhoto(Long id) throws Exception {
		String name = uploadDirectory+id;
		File f = new File(name);
		
		return IOUtils.toByteArray(new FileInputStream(f));
	}
}
