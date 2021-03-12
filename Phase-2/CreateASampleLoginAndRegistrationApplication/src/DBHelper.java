import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DBHelper {
	private static SessionFactory factory;
	
	public DBHelper() {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public Integer loginUser(User user) throws Exception {
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		
		Integer userID = null;
		User queriedUser = getUserByUsername(user.getUsername());
		
		if (queriedUser == null) {
			throw new Exception("Username does not exist, please try again!");
		} else if (!user.getPassword().equals(queriedUser.getPassword())) {
			throw new Exception("Password is incorrect, please try again!");
		} else {
			userID = queriedUser.getId();
		}
		
		tx.commit();
		session.close();
		
		return userID;
	}
	
	public Integer registerUser(User user) throws Exception {
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		
		Integer userID = null;
		User queriedUser = getUserByUsername(user.getUsername());
		
		if(queriedUser != null) {
			throw new Exception("This username already exists, please enter a new username!");
		} else {
			userID = (Integer) session.save(user); 
		}
		
		tx.commit();
		session.close();
		
		return userID;
	}
	
	private User getUserByUsername(String username) {
		//User queriedUser =  (User) session.get(User.class, id);
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cr = cb.createQuery(User.class);
		Root<User> root = cr.from(User.class);
		cr.select(root).where(cb.equal(root.get("username"), username));
		Query<User> query = session.createQuery(cr);
		query.setMaxResults(1);
		List<User> result = query.getResultList();
		
		tx.commit();
		session.close();
		
		if(result.size()==0) return null;
		return result.get(0);
	}
}
