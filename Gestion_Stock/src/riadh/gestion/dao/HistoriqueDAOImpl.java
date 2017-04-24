package riadh.gestion.dao;

import java.util.List;

import org.hibernate.Session;

import riadh.gestion.dao.entity.Historique;
import riadh.gestion.dao.entity.Produit;
import riadh.gestion.util.HibernateUtil;

public class HistoriqueDAOImpl implements HistoriqueDAO {
	
	 static Session sesion = HibernateUtil.openSession();


	@Override
	public void add(Historique h) {
		
		sesion.beginTransaction();
		sesion.save(h);
		sesion.getTransaction().commit();
		
	}

	@Override
	public Historique edite(Historique h) {
		sesion.beginTransaction();
		Historique h1= (Historique)sesion.merge(h);
		sesion.getTransaction().commit();
		return h1;
	}

	@Override
	public void delete(long id) {

		sesion.beginTransaction();
		Historique h =finById(id);
		sesion.delete(h);
		sesion.getTransaction().commit();		
	}

	@Override
	public List<Historique> finAll() {
		return sesion.createQuery("from Historique h order by h.id_historique DESC").list();

	}

	@Override
	public Historique finById(long id) {
		return (Historique)sesion.get(Historique.class, id);

	}

}
