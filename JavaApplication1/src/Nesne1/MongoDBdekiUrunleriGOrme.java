package Nesne1;

import org.bson.Document;

import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;

public class MongoDBdekiUrunleriGOrme {
	
	public static void main(String Args[])
	{
		
		
		MongoIterable<String> tables = AnaMenu.database.listCollectionNames();
		
		////ListCollectionsIterable<Document> ali = AnaMenu.database.listCollections()
		///AnaMenu.database.createCollection("CepTelefonu"); ///database'e koleksiyon ekliyor
		///AnaMenu.database.createCollection("Yaz�c�");
		///AnaMenu.database.createCollection("Buzdolab�");
		///AnaMenu.database.createCollection("VersatilKalem");
		
		for(String coll : tables){
			System.out.println("\n\n"+coll);
			MongoCollection<Document> table = AnaMenu.database.getCollection(coll.toString());///Database'deki her bir koleksiyonu tek tek al�yor
			FindIterable<Document> aaa=table.find();/// her koleksiyon i�indeki documentleri listeye al�yor
			
			for (Document current : aaa) {
				///if(current.containsValue("profilo") )
				 //// table.deleteOne(current);/// Yanl�� girilen kay�tlar� silmek i�in kulland�m.
		        System.out.println(current);
		        
		        
		        
		    }
		}
		
		
		
		
		
		
		
	}
	
	
}
