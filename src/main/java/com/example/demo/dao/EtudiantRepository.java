package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Etudiant;
 
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

	public List<Etudiant> findByNom(String nom);
	public Page<Etudiant> findByNom(String nom, Pageable pageable);
	public List<Etudiant> findByPrenom(String prenom);
	public Page<Etudiant> findByPrenom(String prenom, Pageable pageable);
	public List<Etudiant> findByDateNaissance(Date date);
	public Page<Etudiant> findByDateNaissance(Date date, Pageable pageable);
	public List<Etudiant> findByFaculte(String faculte);
	public Page<Etudiant> findByFaculte(String faculte, Pageable pageable);
	public List<Etudiant> findByEcole(String ecole);
	public Page<Etudiant> findByEcole(String ecole, Pageable pageable);
	public List<Etudiant> findByClasse(String classe);
	public Page<Etudiant> findByClasse(String classe, Pageable pageable);
	public List<Etudiant> findByNiveau(String niveau);
	public Page<Etudiant> findByNiveau(String niveau, Pageable pageable);
	
	@Query("select e from Etudiant e where e.nom like :x")
	public List<Etudiant> findByKey(@Param("x") String key);
	@Query("select e from Etudiant e where e.nom like :x")
	public Page<Etudiant> findByKey(@Param("x") String key, Pageable pageable);
	
	@Query("select e from Etudiant e where e.dateNaissance > :y and e.dateNaissance < :z")
	public List<Etudiant> findByDates(@Param("y") Date d1, @Param("z") Date d2);
	@Query("select e from Etudiant e where e.dateNaissance > :y and e.dateNaissance < :z")
	public Page<Etudiant> findByDates(@Param("y") Date d1, @Param("z") Date d2, Pageable pageable);
}
