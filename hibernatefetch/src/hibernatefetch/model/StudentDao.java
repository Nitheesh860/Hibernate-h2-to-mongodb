package hibernatefetch.model;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class StudentDao {

	public static void main(String[] args) {
try {
	MongoClientURI uri = new MongoClientURI(
			"mongodb+srv://Nitheesh:Atlas123@cluster0.q7oseyn.mongodb.net/?retryWrites=true&w=majority");
	MongoClient mongoclient = new MongoClient(uri);
	DB db = mongoclient.getDB("Studentfetch");
	DBCollection col = db.getCollection("Sample_fetch");
	
	/*
	 * student.setStdId(101); student.setName("Nitheesh"); student.setDept("CSE");
	 * student.setCollegeyear("iv");
	 */
	
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the id : ");
			int stdId = sc.nextInt();
			
			
			Configuration cfg = new Configuration();
			cfg.configure("department.html.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			
			List li = session.createQuery("from StudentDept where stdId=" + stdId).list();
			Iterator it = li.iterator();
			
			while(it.hasNext()) {
				Object obj = (Object)it.next();
				StudentDept student = (StudentDept) obj;
				/*
				 * System.out.println(student.getStdId());
				 * System.out.println(student.getName()); System.out.println(student.getDept());
				 * System.out.println(student.getCollegeyear());
				 */
				Gson gson = new Gson();
				String json = gson.toJson(student);
				BasicDBObject basicDBObject = new BasicDBObject("Studentdata", json);
				col.save(basicDBObject);
			}
			session.close();
			factory.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
