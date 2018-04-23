package mongo;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class None {
	public static void main(String[] args)  {

		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		MongoClient mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());

		TestBean testBean =new TestBean();
		MongoDatabase database=mongoClient.getDatabase("test");
		
		MongoCollection<TestBean> collection=database.getCollection("TestBean",TestBean.class);
//		collection=collection.withCodecRegistry(pojoCodecRegistry);
		testBean.setObj("xx");
//		collection.insertOne(testBean);
		collection.find().forEach(new Consumer<TestBean>() {

			@Override
			public void accept(TestBean t) {
				System.out.println(t.getObj());
				
			}
			
		}
		);
	}

 
}
