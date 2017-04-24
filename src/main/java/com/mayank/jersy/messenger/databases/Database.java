package com.mayank.jersy.messenger.databases;

import java.util.HashMap;
import java.util.Map;

import com.mayank.jersy.messenger.models.Message;
import com.mayank.jersy.messenger.models.Profile;

public class Database {
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
}
