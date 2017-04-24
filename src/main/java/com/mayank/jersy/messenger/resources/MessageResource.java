package com.mayank.jersy.messenger.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mayank.jersy.messenger.models.Message;
import com.mayank.jersy.messenger.services.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
			@QueryParam("start") int start,@QueryParam("end") int end){
		if(year > 0){
			return messageService.getAllMessagesByYear(year);
		}
		if((start >= 0) &&(end >= 0) ){
			return messageService.getAllMessagesPaginated(start, end);
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{id}")
	public Message getMessage(@PathParam("id") Long messageId){
		return messageService.getMessageById(messageId);
	}
	
	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{id}")
	public Message updateMessages(@PathParam("id") Long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{id}")
	public Message deleteMessages(@PathParam("id") Long id){
		return messageService.deleteMessage(id);
	}
}
