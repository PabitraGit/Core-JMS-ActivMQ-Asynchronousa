package com.tr.producer;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueProducer {

	public static void main(String[] args) throws JMSException {
		// create a connection Factory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://s2bvdiw10dv0071:61616");
		
		//create Connection
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		//Create Session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		//Create a Queue
		Destination destination = session.createQueue("TestMQ");
		
		//Create a Producer
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
		//Create a Message
		String messgae = "Hello Wrold from a Producer";
		TextMessage textMessage = session.createTextMessage(messgae);
		
		System.out.println("Sent Message : " +messgae);
		producer.send(textMessage);
		
		producer.close();
		session.close();
		connection.close();
		
	}

}
