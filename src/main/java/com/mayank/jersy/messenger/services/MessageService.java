package com.mayank.jersy.messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.mayank.jersy.messenger.databases.Database;
import com.mayank.jersy.messenger.models.Message;

public class MessageService {
	
	public MessageService(){
		Message m1 = new Message(1L, "Hello World!", "Mayank");
		if(m1.getId() == 1){
			m1.setCreated(new Date());
		}
		messages.put(1L, m1);
	}
	
	private Map<Long, Message> messages = Database.getMessages();
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesByYear(int year){
		List<Message> list = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				list.add(message);
			}
		}
		return list;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int end){
		ArrayList<Message> list = new ArrayList<>(messages.values());
		if(start + end > list.size()){
			return new ArrayList<Message>();
		}
		return list.subList(start, start + end);
	}
	
	public Message getMessageById(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message deleteMessage(Long id){
		return messages.remove(id);
	}
	
	
}
