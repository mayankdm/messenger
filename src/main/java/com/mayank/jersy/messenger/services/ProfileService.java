package com.mayank.jersy.messenger.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.mayank.jersy.messenger.databases.Database;
import com.mayank.jersy.messenger.models.Profile;

public class ProfileService {
	
	public ProfileService(){
		profiles.put("mank", new Profile(1L, "mank", "Mayank", "Dwivedi"));
	}
	
	private Map<String, Profile> profiles = Database.getProfiles();
	
	public ArrayList<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfileByProfileName(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1L);
		profile.setCreated(new Date());
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile deleteProfile(String profileName){
		return profiles.remove(profileName);
	}
}
