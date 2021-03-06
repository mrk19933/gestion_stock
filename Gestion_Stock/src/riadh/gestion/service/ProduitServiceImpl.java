package riadh.gestion.service;

import java.util.List;

import riadh.gestion.dao.ProduitDAO;
import riadh.gestion.dao.ProduitDAOImpl;
import riadh.gestion.dao.entity.Produit;

public class ProduitServiceImpl implements ProduitService {
	
	ProduitDAO dao = new ProduitDAOImpl();

	@Override
	public void add(Produit p) {
		dao.add(p);		
	}

	@Override
	public Produit edite(Produit p) {
		return dao.edite(p);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);		
	}

	@Override
	public List<Produit> finAll() {
		
		return dao.finAll();
	}

	@Override
	public Produit finById(long id) {
		
		return dao.finById(id);
	}

}
