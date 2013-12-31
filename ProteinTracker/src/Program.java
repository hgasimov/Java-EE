import java.util.Date;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.example.model.GoalAlert;
import com.example.model.ProteinData;
import com.example.model.User;
import com.example.model.UserHistory;
import com.example.model.UserTotal;
import com.example.repository.HibernateUtilities;

public class Program {
	public static void main(String[] args) {
		System.out.println("OK");
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		//addUser(session);
		//printUserAndUpdate(session, 3);
		//populateData(session);
		//printUsers(session);
		//printGoalAlerts(session);
		//printTotals(session);
		//printUsers_withCriteria(session);
		printUsers_manualBatching(session);
		//printUsers_nativeSQL(session);
		
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
	
	private static void printUsers_nativeSQL(Session session) {
		Query query = session.createSQLQuery("SELECT * FROM protein_tracker.users").addEntity(User.class);
		List<User> users = query.list();
		for (User user: users) 
			System.out.println(user.getName());
	}
	
	private static void printUsers_manualBatching(Session session) {
		session.beginTransaction();
		
		Criteria crt = session.createCriteria(User.class);
		ScrollableResults scr_users = crt.setCacheMode(CacheMode.IGNORE).scroll();
		
		int ucount = 0;
		while(scr_users.next()) {
			User user = (User) scr_users.get(0);
			user.setProteinData(new ProteinData());
			if (++ucount % 2 == 0){
				session.flush();
				session.clear();
			}
			
			System.out.println(user.getName());
		}
		
		session.getTransaction().commit();		
	}
	
	private static void printUsers_withCriteria(Session session) {
		Criteria crt = session.createCriteria(User.class)
				.add(Restrictions.or(
						Restrictions.eq("name", "Nash"), 
						Restrictions.eq("name", "Jersey")
					));
		
		List<User> users = crt.list();		
		for (User user: users) System.out.println(user.getName());
	}
	
	private static void printTotals(Session session) {
		Query query = session.createQuery("select new com.example.model.UserTotal(user.name, user.proteinData.total) "
				+ "from User user");
		List<UserTotal> userTotals = query.list();
		
		for (UserTotal userTotal: userTotals) System.out.println(userTotal.getName() + " " + userTotal.getTotal());
	}
	
	private static void printUsers(Session session) {
		Query query = session.createQuery("select user from User as user where user.name = :name").setString("name", "Nash");
		List<User> users = query.list();
		
		for (User user: users) System.out.println(user.getName());
	}
	
	private static void printGoalAlerts(Session session) {
		System.out.println("All goal alerts [using the named query 'AllGoalAlerts']: ");
		for (GoalAlert alert: (List<GoalAlert>) session.getNamedQuery("AllGoalAlerts").list())
			System.out.println(alert.getMessage());
		
		System.out.println("\nPaged goal alerts: ");
		Query query = session.createQuery("from GoalAlert")
				.setFirstResult(2)
				.setMaxResults(1);
		List<GoalAlert> alerts = query.list();
		
		for (GoalAlert alert: alerts) System.out.println(alert.getMessage());
	}
	
	private static void populateData(Session session) {
		addUser(session, "HeyHey", 50, "Congrats!!!");
		addUser(session, "Nash", 100, "You did it!!!");
		addUser(session, "Jersey", 500, "You are a man!!!");
	}
	
	
	private static void addUser(Session session, String name, int goal, String ... alerts) {
		session.beginTransaction();
		
		User user = new User();
		user.setName(name);
		user.getProteinData().setGoal(goal);
		user.addHistory(
				new UserHistory(new Date(), "add: name = " + user.getName() + 
						", goal = " + user.getProteinData().getGoal()));
		
		for (String alert : alerts)
			user.addGoalAlert(new GoalAlert(alert));
		
		session.save(user);
		
		session.getTransaction().commit();		
	}
	
	private static void printUserAndUpdate(Session session, int id) {
		session.beginTransaction();
		
		User user = (User) session.get(User.class, id);
		System.out.println(user.getName() + " " + user.getProteinData().getGoal());
		
		user.getProteinData().setTotal(user.getProteinData().getTotal() + 100);
		user.addHistory(new UserHistory(new Date(), "update: increase " + user.getName() + " total by 100"));
		
		session.getTransaction().commit();		
	}
}
