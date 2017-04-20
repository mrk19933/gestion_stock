package riadh.gestion.presentation;

 import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import riadh.gestion.dao.entity.Fournisseur;
import riadh.gestion.dao.entity.Historique;
import riadh.gestion.dao.entity.Produit;
import riadh.gestion.service.FournisseurService;
import riadh.gestion.service.FournisseurServiceImpl;
import riadh.gestion.service.HistoriqueService;
import riadh.gestion.service.HistoriqueServiceImpl;
import riadh.gestion.service.ProduitService;
import riadh.gestion.service.ProduitServiceImpl;

import javax.faces.bean.RequestScoped;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


@ManagedBean
@RequestScoped
public class ProduitBean {
	// nista3mil fihom bech n3ayat lil les methode**************************** 
	private ProduitService service_produit = new ProduitServiceImpl();
	private FournisseurService service_fournisseur = new FournisseurServiceImpl();
	private HistoriqueService service_historique = new HistoriqueServiceImpl();

	// affichage message ********************************
	private int success;
	//attribut class *********************************
	private String nom_produit;
	private int quantite_produit=0;
	private String nom_fournisseur_produit;
	private int seuil_min_produit=0;
	private int seuil_max_produit=0;
	private String description_produit;
	// select ***************************
	private List<SelectItem> nom_fournisseur_list;
	private List<Produit> list_produit;

@PostConstruct
public void initBean()
{
	//select ************************
nom_fournisseur_list = new ArrayList<>();
List<Fournisseur> list_fourniseur = service_fournisseur.finAll();

nom_fournisseur_list.add(new SelectItem("",""));
for (Fournisseur o : list_fourniseur) {
	nom_fournisseur_list.add(new SelectItem(o.getNom_fournisseur(),o.getNom_fournisseur()));
	
}	
	//table***********************
	list_produit = service_produit.finAll();
	
	

}




	
	
	public List<Produit> getList_produit() {
	return list_produit;
}






public void setList_produit(List<Produit> list_produit) {
	this.list_produit = list_produit;
}






	public int getSuccess() {
	return success;
}






public void setSuccess(int success) {
	this.success = success;
}






	public List<SelectItem> getNom_fournisseur_list() {
	return nom_fournisseur_list;
}




public void setNom_fournisseur_list(List<SelectItem> nom_fournisseur_list) {
	this.nom_fournisseur_list = nom_fournisseur_list;
}




	public String getNom_produit() {
		return nom_produit;
	}




	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}




	public int getQuantite_produit() {
		return quantite_produit;
	}




	public void setQuantite_produit(int quantite_produit) {
		this.quantite_produit = quantite_produit;
	}




	public String getNom_fournisseur_produit() {
		return nom_fournisseur_produit;
	}




	public void setNom_fournisseur_produit(String nom_fournisseur_produit) {
		this.nom_fournisseur_produit = nom_fournisseur_produit;
	}




	public int getSeuil_min_produit() {
		return seuil_min_produit;
	}




	public void setSeuil_min_produit(int seuil_min_produit) {
		this.seuil_min_produit = seuil_min_produit;
	}




	public int getSeuil_max_produit() {
		return seuil_max_produit;
	}




	public void setSeuil_max_produit(int seuil_max_produit) {
		this.seuil_max_produit = seuil_max_produit;
	}




	public String getDescription_produit() {
		return description_produit;
	}




	public void setDescription_produit(String description_produit) {
		this.description_produit = description_produit;
	}




	public void saveadd(ActionEvent e)
	{
		System.out.println(nom_produit);
		System.out.println(quantite_produit);
		
	}
	// rederection page ***********************
	public String utilisateur_page()
	{
		return "utilisateur";	
	}
	public String produit_page()
	{
		return "produit";	
	}
	
	public void AddProduit(ActionEvent e)
	{
		Produit p = new Produit();
		p.setNom_produit(nom_produit);
		p.setNom_fournisseur_produit(nom_fournisseur_produit);
		p.setSeuil_max_produit(seuil_max_produit);
		p.setSeuil_min_produit(seuil_min_produit);
		p.setDescription_produit(description_produit);
		p.setQuantite_produit(quantite_produit);
		
		service_produit.add(p);
		
		// ajout de historique ***************
		Historique h= new Historique();
		h.setNom_produit_historique(nom_produit);
		// date************
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+01:00"), Locale.FRANCE);
		Date date1=calendar.getTime();
		String dateString=new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date1);
		//*******
		h.setDescription_historique("ajout produit"+nom_produit+" au base ");
		h.setDate_historique(dateString);
		service_historique.add(h);
		// ajout de produit avec success *************
		success=1;
		nom_produit="";
		nom_fournisseur_produit="";
		seuil_min_produit=0;
		seuil_max_produit=0;
		description_produit="";
		quantite_produit=0;
		
	}
	
	

}
