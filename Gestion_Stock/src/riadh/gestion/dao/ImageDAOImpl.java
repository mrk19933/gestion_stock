package riadh.gestion.dao;

import java.util.List;

import org.hibernate.Session;

import riadh.gestion.dao.entity.Image;
import riadh.gestion.dao.entity.Produit;
import riadh.gestion.util.HibernateUtil;

public class ImageDAOImpl implements ImageDAO {

	 static Session sesion = HibernateUtil.openSession();

	@Override
	public void add(Image i) {
		
		sesion.beginTransaction();
		sesion.save(i);
		sesion.getTransaction().commit();
		
	}

	@Override
	public Image edite(Image i) {

		sesion.beginTransaction();
		Image i1= (Image)sesion.merge(i);
		sesion.getTransaction().commit();
		return i1;
	}

	@Override
	public void delete(long id) {
		sesion.beginTransaction();
		Image i =finById(id);
		sesion.delete(i);
		sesion.getTransaction().commit();
		
	}

	@Override
	public List<Image> finAll() {

		return sesion.createQuery("select o from Image o").list();

	}

	@Override
	public Image finById(long id) {

		return (Image)sesion.get(Image.class, id);

	}

}
