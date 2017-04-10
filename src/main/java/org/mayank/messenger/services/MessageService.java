package org.mayank.messenger.services;

import java.util.ArrayList;
import java.util.List;

import org.mayank.messenger.models.Message;

public class MessageService {
	public List<Message> getAllMessages(){
		Message m1 = new Message(1L, "Hello World!", "Mayank");
		Message m2 = new Message(2L,"Hello Jersy!", "Mayank");
		List<Message> list = new ArrayList();
		list.add(m1);
		list.add(m2);
		return list;
	}
}
