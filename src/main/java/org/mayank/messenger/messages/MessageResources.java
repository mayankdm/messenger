package org.mayank.messenger.messages;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mayank.messenger.models.Message;
import org.mayank.messenger.services.MessageService;

@Path("messages")
public class MessageResources {

	MessageService service = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage() {
		return service.getAllMessages();

	}
}
