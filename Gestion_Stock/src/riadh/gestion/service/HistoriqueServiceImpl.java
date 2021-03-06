package riadh.gestion.service;

import java.util.List;

import riadh.gestion.dao.HistoriqueDAO;
import riadh.gestion.dao.HistoriqueDAOImpl;
import riadh.gestion.dao.entity.Historique;

public class HistoriqueServiceImpl implements HistoriqueService {
	HistoriqueDAO dao = new HistoriqueDAOImpl();


	@Override
	public void add(Historique h) {
		dao.add(h);		
	}

	@Override
	public Historique edite(Historique h) {

		return dao.edite(h);
	}

	@Override
	public void delete(long id) {

		dao.delete(id);
	}

	@Override
	public List<Historique> finAll() {

		return dao.finAll();
	}

	@Override
	public Historique finById(long id) {

		return dao.finById(id);
	}

}
