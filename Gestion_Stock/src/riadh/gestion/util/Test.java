package riadh.gestion.util;

import java.util.List;

import org.hibernate.Session;

import riadh.gestion.dao.ProduitDAO;
import riadh.gestion.dao.entity.Produit;
import riadh.gestion.dao.ProduitDAOImpl;
public class Test {
	
 static Session sesion = HibernateUtil.openSession();

	public static void main(String[] args) {
		
		//sesion.createQuery("select o From Produit o").list();
	//List<Produit> result = (List<Produit>) sesion.createQuery("from Produit").list();

		ProduitDAO dao= new ProduitDAOImpl();
			Produit p= new Produit();
			p.setNom("amira");
			p.setQuantite("10");
			dao.add(p);
	}

}