package riadh.gestion.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@RequestScoped
public class UtilisateurBean {
	
	private String nom_utilisateur="riadh";
	private String adresse_utilisateur;
	private String num_tel_utilisateur;
	private String user_name_utilisateur;
	private String mdp_utilisateur;
	private String adresse_mail_utilisateur;
	
	
	
	public String getNom_utilisateur() {
		return nom_utilisateur;
	}
	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}
	public String getAdresse_utilisateur() {
		return adresse_utilisateur;
	}
	public void setAdresse_utilisateur(String adresse_utilisateur) {
		this.adresse_utilisateur = adresse_utilisateur;
	}
	public String getNum_tel_utilisateur() {
		return num_tel_utilisateur;
	}
	public void setNum_tel_utilisateur(String num_tel_utilisateur) {
		this.num_tel_utilisateur = num_tel_utilisateur;
	}
	public String getUser_name_utilisateur() {
		return user_name_utilisateur;
	}
	public void setUser_name_utilisateur(String user_name_utilisateur) {
		this.user_name_utilisateur = user_name_utilisateur;
	}
	public String getMdp_utilisateur() {
		return mdp_utilisateur;
	}
	public void setMdp_utilisateur(String mdp_utilisateur) {
		this.mdp_utilisateur = mdp_utilisateur;
	}
	public String getAdresse_mail_utilisateur() {
		return adresse_mail_utilisateur;
	}
	public void setAdresse_mail_utilisateur(String adresse_mail_utilisateur) {
		this.adresse_mail_utilisateur = adresse_mail_utilisateur;
	}
	
	public void saveadd(ActionEvent e)
	{
		System.out.println(nom_utilisateur);
		//System.out.println(adresse_utilisateur);
		
	}
	public String page_produit()
	{
		return "produit";
		
	}
	

}
