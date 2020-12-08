package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
	private IDao dao;
	public double calcul() {
		double nb = dao.getValue();
		return nb * 6;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
	}
}
