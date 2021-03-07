package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="etudiant")
public class Etudiant implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="e_id")
	private int id;
	
	@Column(name="e_matricule")
	private String matricule;
	
	@Column(name="e_nom")
	private String nom;
	
	@Column(name="e_prenom")
	private String prenom;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="e_date_naissance")
	private Date dateNaissance;
	
	@Column(name="e_photo")
	private String photo;
	
	@Column(name="e_telephone")
	private String telephone;
	
	@Column(name="e_email")
	private String email;
	
	@Column(name="e_universite")
	private String universite;
	
	@Column(name="e_ecole")
	private String ecole;
	
	@Column(name="e_faculte")
	private String faculte;
	
	@Column(name="e_classe")
	private String classe;
	
	@Column(name="e_niveau")
	private String niveau;
	
	public Etudiant() {
		this.matricule = UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	public Etudiant(String nom, String prenom, Date dateNaissance, String photo, String telephone, String email,
			String universite, String ecole, String faculte, String classe, String niveau) {
		
		this.matricule = UUID.randomUUID().toString().replace("-", "").toUpperCase();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.photo = photo;
		this.telephone = telephone;
		this.email = email;
		this.universite = universite;
		this.ecole = ecole;
		this.faculte = faculte;
		this.classe = classe;
		this.niveau = niveau;
	}
	
	public Etudiant(Etudiant e) {
		this.id = e.id;
		this.matricule = e.matricule;
		this.nom = e.nom;
		this.prenom = e.prenom;
		this.dateNaissance = e.dateNaissance;
		this.photo = e.photo;
		this.telephone = e.telephone;
		this.email = e.email;
		this.universite = e.universite;
		this.ecole = e.ecole;
		this.faculte = e.faculte;
		this.classe = e.classe;
		this.niveau = e.niveau;
	}

	public Etudiant(int id, String matricule, String nom, String prenom, Date dateNaissance, String photo,
			String telephone, String email, String universite, String ecole, String faculte, String classe,
			String niveau) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.photo = photo;
		this.telephone = telephone;
		this.email = email;
		this.universite = universite;
		this.ecole = ecole;
		this.faculte = faculte;
		this.classe = classe;
		this.niveau = niveau;
	}

	public int getId() {
		return id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUniversite() {
		return universite;
	}

	public void setUniversite(String universite) {
		this.universite = universite;
	}

	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public String getFaculte() {
		return faculte;
	}

	public void setFaculte(String faculte) {
		this.faculte = faculte;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", photo=" + photo + ", telephone=" + telephone + ", email="
				+ email + ", universite=" + universite + ", ecole=" + ecole + ", faculte=" + faculte + ", classe="
				+ classe + ", niveau=" + niveau + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((ecole == null) ? 0 : ecole.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((faculte == null) ? 0 : faculte.hashCode());
		result = prime * result + id;
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((universite == null) ? 0 : universite.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (ecole == null) {
			if (other.ecole != null)
				return false;
		} else if (!ecole.equals(other.ecole))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (faculte == null) {
			if (other.faculte != null)
				return false;
		} else if (!faculte.equals(other.faculte))
			return false;
		if (id != other.id)
			return false;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		if (niveau == null) {
			if (other.niveau != null)
				return false;
		} else if (!niveau.equals(other.niveau))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (universite == null) {
			if (other.universite != null)
				return false;
		} else if (!universite.equals(other.universite))
			return false;
		return true;
	}
	
}
