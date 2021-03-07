package com.example.demo;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.demo.dao.EtudiantRepository;
import com.example.demo.entities.Etudiant;
import com.example.demo.web.EtudiantController;

@SpringBootApplication
@ComponentScan({"com.example.demo","web"})
public class GestockApplication {

	public static void main(String[] args) {
		
		String path = EtudiantController.uploadDirectory;
		new File(path).mkdir();
		ApplicationContext contexte = SpringApplication.run(GestockApplication.class, args);
		EtudiantRepository etudiantRepository = contexte.getBean(EtudiantRepository.class);
		
		
		/*
		 * Etudiant e1 = new Etudiant("PIEDJOU NANTCHOUANG", "LOIC ARNOLD", new Date(),
		 * "arnold.jpg", "694121147", "piedjouloic@gmail.com",
		 * "UNIVERSITE INTERNATIONAL DE TUNIS", "POLYTECHNIQUE",
		 * "INGENIERIE DES SYSTEMES D'INFORMATION", "Master", "2");
		 * etudiantRepository.save(e1);
		 * 
		 * Etudiant e2 = new Etudiant("DJOMO NANTCHOUANG", "BORIS ARSENE", new Date(),
		 * "arsene.jpg", "694111147", "djomoboris@gmail.com", "POINTE NOIRE",
		 * "MAINTENANCE INDUSTRIEL", "INGENIERIE DES PROCEDES INDUSTRIELS", "Master",
		 * "1"); etudiantRepository.save(e2);
		 * 
		 * Etudiant e3 = new Etudiant("NGUEDJOP NANTCHOUANG", "ANGE LAURE", new Date(),
		 * "laure.jpg", "694101147", "nguedjopange@gmail.com", "INSTITUT VOGT",
		 * "ENVIRONNEMENT ET URBANISME", "INGENIERIE DE L'ENVIRONNEMENT", "Licence",
		 * "2"); etudiantRepository.save(e3);
		 * 
		 * Etudiant e4 = new Etudiant("NJOUKAM NANTCHOUANG", "DIVINE GRACE", new Date(),
		 * "divine.jpg", "694091147", "njoukamdivine@gmail.com",
		 * "FAMILY BILINGUAL SCHOOL", "PRIMAIRE", "CLASSE NORMALE", "CE", "2");
		 * etudiantRepository.save(e4);
		 */
	    	  
		//1- Afficher tous les etudiants
		
		/*
		 * //1ere approche : Exploiter l'objet Liste 
		 * List<Etudiant> etudiants1 = etudiantRepository.findAll(); 
		 * etudiants1.forEach(e->System.out.println(e));
		 * 
		 * //2eme approche : Exploiter l'objet Pageable 
		 * Page<Etudiant> etudiants2 = etudiantRepository.findAll(PageRequest.of(0, 4));
		 * etudiants2.forEach(e->System.out.println(e));
		 */
		
		//2- Afficher les etudiants par mot clef
		
		      //1ere approche : Exploiter l'objet Liste
		
				/*
				 * List<Etudiant> etudiants3 = etudiantRepository.findByKey("%DJ%");
				 * etudiants3.forEach(e->System.out.println(e.getNom()+" "+e.getPrenom()));
				 * 
				 * //2ere approche : Exploiter l'objet Pageable Page<Etudiant> etudiants4 =
				 * etudiantRepository.findByKey("%NANT%", PageRequest.of(0, 4));
				 * etudiants4.forEach(e->System.out.println(e.getNom()+" "+e.getPrenom()));
				 */
	}

}
