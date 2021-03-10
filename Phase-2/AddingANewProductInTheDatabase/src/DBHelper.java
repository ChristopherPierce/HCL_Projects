import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBHelper {
	private static SessionFactory factory;
	
	public DBHelper() {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public Integer addProduct(Product product) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer productID = null;
		
		tx = session.beginTransaction();
		productID = (Integer) session.save(product); 
		tx.commit();
		session.close();
		
		return productID;
		//return 0;
	}
}
