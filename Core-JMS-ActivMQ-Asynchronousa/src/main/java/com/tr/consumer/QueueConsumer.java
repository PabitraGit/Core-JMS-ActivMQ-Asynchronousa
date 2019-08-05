package com.tr.consumer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueConsumer {

	public static void main(String[] args) throws JMSException {
		// create a connection Factory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://s2bvdiw10dv0071:61616");

		// create Connection
		Connection connection = connectionFactory.createConnection();
		connection.start();

		// Create Session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// Create a Queue
		Destination destination = session.createQueue("TestMQ");
		
		//create a consumer
		MessageConsumer consumer = session.createConsumer(destination);
		
		//wait for message
		Message message = consumer.receive(1000);
		
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			System.out.println("Message Received : "+ textMessage.getText());
		}else{
			System.out.println("Message Received : "+ message);
		}
		
		consumer.close();
		session.close();
		connection.close();
	}

}
