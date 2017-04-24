package riadh.gestion.presentation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import riadh.gestion.dao.entity.Fournisseur;
import riadh.gestion.dao.entity.Historique;
import riadh.gestion.dao.entity.Produit;
import riadh.gestion.service.FournisseurService;
import riadh.gestion.service.FournisseurServiceImpl;
import riadh.gestion.service.HistoriqueService;
import riadh.gestion.service.HistoriqueServiceImpl;

@ManagedBean
@RequestScoped
public class FournisseurBean {
	private FournisseurService service_fournisseur = new FournisseurServiceImpl();
	private HistoriqueService service_historique = new HistoriqueServiceImpl();


	
	private String nom_fournisseur;
	private String adresse_mail_fournisseur;
	private String adresse_fournisseur;
	private String num_tel_fournisseur;
	private String description_fournisseur;
	
	private int success;
	//select *************
	private List<Fournisseur> list_fournisseur;
	
	//request****************
	//private String id;
	
	
	@PostConstruct
	public void initBean()
	{
		
		//table***********************
		list_fournisseur = service_fournisseur.finAll();
		
		// modif ***************************
		/*if(getParam("id_produit")!=null)	{
			modif_produit = service_produit.finById(Integer.parseInt(getParam("id_produit")));
			setId(getParam("id_produit"));
			System.out.println(modif_produit.getNom_produit());
			System.out.println(modif_produit.getId_produit());

		}
		System.out.println("id_produit :"+getParam("id_produit"));
		System.out.println("nom_produit :"+getParam("nom_produit"));
*/
	}
	
	
	//geter et settet *****************
	
	
	public int getSuccess() {
		return success;
	}
	public List<Fournisseur> getList_fournisseur() {
		return list_fournisseur;
	}


	public void setList_fournisseur(List<Fournisseur> list_fournisseur) {
		this.list_fournisseur = list_fournisseur;
	}


	public void setSuccess(int success) {
		this.success = success;
	}
	public String getNom_fournisseur() {
		return nom_fournisseur;
	}
	public void setNom_fournisseur(String nom_fournisseur) {
		this.nom_fournisseur = nom_fournisseur;
	}
	public String getAdresse_mail_fournisseur() {
		return adresse_mail_fournisseur;
	}
	public void setAdresse_mail_fournisseur(String adresse_mail_fournisseur) {
		this.adresse_mail_fournisseur = adresse_mail_fournisseur;
	}
	public String getAdresse_fournisseur() {
		return adresse_fournisseur;
	}
	public void setAdresse_fournisseur(String adresse_fournisseur) {
		this.adresse_fournisseur = adresse_fournisseur;
	}
	public String getNum_tel_fournisseur() {
		return num_tel_fournisseur;
	}
	public void setNum_tel_fournisseur(String num_tel_fournisseur) {
		this.num_tel_fournisseur = num_tel_fournisseur;
	}
	public String getDescription_fournisseur() {
		return description_fournisseur;
	}
	public void setDescription_fournisseur(String description_fournisseur) {
		this.description_fournisseur = description_fournisseur;
	}
	
	
	public void AddFournisseur(ActionEvent e)
	{
		Fournisseur f = new Fournisseur();
		
		f.setNom_fournisseur(nom_fournisseur);
		f.setAdresse_mail_fournisseur(adresse_mail_fournisseur);
		f.setAdresse_fournisseur(adresse_fournisseur);
		f.setNum_tel_fournisseur(num_tel_fournisseur);
		f.setDescription_fournisseur(description_fournisseur);
		
		service_fournisseur.add(f);
		
		// ajout de historique ***************
		Historique h= new Historique();
		h.setNom_produit_historique(nom_fournisseur);
		// date************
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+01:00"), Locale.FRANCE);
		Date date1=calendar.getTime();
		String dateString=new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date1);
		//*******
		h.setDescription_historique("ajout fournisseur"+nom_fournisseur+" au base ");
		h.setDate_historique(dateString);
		service_historique.add(h);
		// ajout de produit avec success *************
		success=1;
		nom_fournisseur="";
		adresse_mail_fournisseur="";
		adresse_fournisseur="";
		num_tel_fournisseur="";
		description_fournisseur="";
		
	}
	
	
	
	
	public void suppFournisseur()
	{
		
		service_fournisseur.delete(Integer.parseInt(getParam("id_fournisseur")));
		
		list_fournisseur = service_fournisseur.finAll();
		
		
		// ajout de historique ***************
		
				Historique h= new Historique();
				h.setNom_produit_historique(getParam("nom_fournisseur"));
				// date************
				Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+01:00"), Locale.FRANCE);
				Date date1=calendar.getTime();
				String dateString=new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date1);
				//*******
				h.setDescription_historique("supprime fournisseur "+getParam("nom_fournisseur"));
				h.setDate_historique(dateString);
				service_historique.add(h);
				// ajout de produit avec success *************
				success=1;
		
	}
	
public String getParam(String name){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		
		return params.get(name);
		
	}
	
	

	
	

}
