package com;

import com.alibaba.fastjson.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = com.pulin.springbootpulin.run.WebRun.class)
@WebAppConfiguration
public class MongodbTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Before
	public void setUp() {

	}

	//@org.junit.Test
	public void test() throws Exception {
//		Query query = new Query(Criteria.where("_id").is("573c39d11212a6eb0f6dc025"));
//		Object obj = mongoTemplate.find(query,Object.class);

		BasicDBObject dbObject = new BasicDBObject();
		dbObject.append("_id","573c39d11212a6eb0f6dc025");
		DBCursor dbCursor = mongoTemplate.getDb().getCollection("order").find(dbObject);
		String json = JSON.toJSON(dbCursor).toString();
		System.out.println(json);
	}
	

	

	

}
