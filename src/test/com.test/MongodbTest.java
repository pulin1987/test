package com;

import com.keruyun.gateway.push.biz.core.cater.service.CaterOrderAutoCompleteBaseService;
import com.keruyun.gateway.push.biz.core.takeout.baidu.to.OrderAutoCompleteTO;
import com.keruyun.gateway.validation.request.Request;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = com.keruyun.gateway.api.core.boot.run.WebRun.class)
@WebAppConfiguration
public class MongodbTest {
	
	@Resource
	private CaterOrderAutoCompleteBaseService caterOrderAutoCompleteBaseService;

	@Before
	public void setUp() {

	}

	@org.junit.Test
	public void orderAutoComplete() throws Exception {
		Request<OrderAutoCompleteTO> request = new Request<OrderAutoCompleteTO>();
		OrderAutoCompleteTO to = new OrderAutoCompleteTO();
		to.setKey("gateway:dev:orderautocomplete:4:100");
		caterOrderAutoCompleteBaseService.orderAutoComplete(request);
	}
	
	//@org.junit.Test
	public void execOrderComplete() throws Exception {
		caterOrderAutoCompleteBaseService.execOrderComplete(1000l);
	}
	
	//@org.junit.Test
	public void scan() throws Exception {
		caterOrderAutoCompleteBaseService.scan();
	}
	

}
