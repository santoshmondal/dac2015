package letmetest.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoOperations {
	private static MongoOperations ref = new MongoOperations();
	private static MongoDatabase db ; 
	static {
		MongoClient mClient = new MongoClient();
		db = mClient.getDatabase("test");
	}

	public void upsert() {
		MongoCollection<Document> coll = db.getCollection("test123");
		PersonPojo p1 = new PersonPojo();
		p1.setCity("MUMBAI");
		
		String json = JsonUtil.objectToJson(p1);
		Document doc = Document.parse(json);
		
		coll.insertOne(doc);
	}
	
	public void query() {
		MongoCollection<Document> coll = db.getCollection("test123");
		MongoCursor<PersonPojo> iterator = coll.find(PersonPojo.class).iterator();
		while(iterator.hasNext()) {
			PersonPojo p = iterator.next();
			System.out.println(p.getCity());
		}
	}

	public static void main(String[] args) {
		ref.query();
	}
}
