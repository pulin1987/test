package com.pulin.springbootpulin.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueueConsumerListener implements MessageListener {
	final static Logger logger = LoggerFactory.getLogger(QueueConsumerListener.class);
	public void onMessage(Message message) {
		if(message instanceof ActiveMQTextMessage){
			ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
			 try {
				logger.info("gateway-jms-cosumer-test,msg:{}",msg.getText().toString());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		
	}

}
