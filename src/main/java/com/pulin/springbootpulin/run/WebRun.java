package com.pulin.springbootpulin.run;

import com.alibaba.fastjson.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.pulin.springbootpulin.bean.Person;
import com.pulin.springbootpulin.config.MyProperties;
import com.pulin.springbootpulin.utils.EncryptUtils;
import com.pulin.springbootpulin.utils.SortJsonUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.TreeMap;

@Controller
//@EnableAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableZuulProxy
@ComponentScan("com.pulin")//组件扫描
@EnableDiscoveryClient
@EnableEurekaClient
@ImportResource(value = {"classpath:application-boot-start.xml"}) // 导入配置文件
//@Slf4j
public class WebRun {
	
	 @Autowired
	 Environment environment;
	 
	 @Autowired
	 Person person;
	 
	 @Autowired
	 MyProperties myProperties;
	 
	 @Autowired
	 private ServerProperties serverProperties;
	 
	 @Autowired
	 private MongoTemplate mongoTemplate;
	
	@RequestMapping("/sort")
	@ResponseBody
	public Object sort(@RequestBody String request) {
		// request = SortJsonUtils.chinaToUnicode(request);
		 long s = System.currentTimeMillis();
		 TreeMap map = JSON.parseObject(request, TreeMap.class);
		 map = SortJsonUtils.treemap(map);
		 long e = System.currentTimeMillis();
		 System.out.println(e-s);
		 String json = JSON.toJSONString(map);
		 json = SortJsonUtils.chinaToUnicode(json);
		 System.out.println(EncryptUtils.md5(json));
		 return map;
	}
	
	@RequestMapping("/home")
	@ResponseBody
	public Object home() {
		/*System.out.println("myProperties.getPort():"+myProperties);
		 mongoTemplate.save(myProperties, "ttt");
		return "ok";*/

		BasicDBObject dbObject = new BasicDBObject();
		dbObject.append("_id",new ObjectId("573c39d11212a6eb0f6dc025"));
		dbObject.append("source",4);
		DBCursor dbCursor = mongoTemplate.getDb().getCollection("order").find(dbObject);
		while(dbCursor.hasNext()){
			String json = JSON.toJSON(dbCursor.next()).toString();
			System.out.println(json);
		}

		return System.currentTimeMillis()+"";

	}

	@RequestMapping("/home2")
	@ResponseBody
	public Object home2() {
		Query query = new Query(Criteria.where("_id").is("573c39d11212a6eb0f6dc025"));
        Order  obj = mongoTemplate.findOne(query,Order.class);
        String json = JSON.toJSON(obj).toString();
        System.out.println(json);
        return System.currentTimeMillis()+"";

	}


    public static class Order{
        private String _id;
        private Integer source;
        private String thirdTranNo;
        private Object content;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public Integer getSource() {
            return source;
        }

        public void setSource(Integer source) {
            this.source = source;
        }

        public String getThirdTranNo() {
            return thirdTranNo;
        }

        public void setThirdTranNo(String thirdTranNo) {
            this.thirdTranNo = thirdTranNo;
        }
        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }
    }



	
	
    public static void main(String[] args) throws Exception{
    	System.getProperties().setProperty("server.port", "8888");
        SpringApplication.run(WebRun.class, args);

		System.out.println("=================================");

    }
}


