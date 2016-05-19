package com.pulin.springbootpulin.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.Arrays;

//http://stackoverflow.com/
//http://www.programcreek.com
//http://www.programcreek.com/java-api-examples/index.php?api=org.springframework.data.authentication.UserCredentials
@Configuration
public class Mongodb3Configuration {
	
	private final static Logger logger = LoggerFactory.getLogger(Mongodb3Configuration.class);

    public MongoDbFactory mongoDbFactory() throws Exception {
        // Set credentials
        MongoCredential credential = MongoCredential.createCredential("mg_qa_calm_gateway", "calm_gateway_test", "elTA5xVD9KiPWfmSesjF".toCharArray());

        ServerAddress serverAddress = new ServerAddress("dds-bp1c359e21a920441.mongodb.rds.aliyuncs.com", 3717);
        ServerAddress serverAddress2 = new ServerAddress("dds-bp1c359e21a920442.mongodb.rds.aliyuncs.com", 3717);

        // Mongo Client
        MongoClient mongoClient = new MongoClient(Arrays.asList(serverAddress,serverAddress2), Arrays.asList(credential));

       /* MongoClientOptions.builder();
        mongoClient.setOptions(1);
        mongoClient.getReplicaSetStatus();*/

        // Mongo DB Factory
        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "calm_gateway_test");
        return simpleMongoDbFactory;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
