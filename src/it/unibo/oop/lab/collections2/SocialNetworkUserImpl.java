package it.unibo.oop.lab.collections2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */
	Map<String, Set<U>> followedUers;
	
    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        followedUers = new HashMap<String, Set<U>>();
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */
    private boolean groupAlreadyExist(final String circle) {
    	return followedUers.containsKey(circle);
    }
    
//    private boolean friendAlreadyExist(final U user) {
//    	for(var entry : followedUers.entrySet()) {
//    		 for(var friend: entry.getValue()) {
//    			 if(friend.equals(user)) {
//    				 return true;
//    			 }
//    		 }
//    	}
//    	return false;
//    }
    
    
    //true if person exists, false otherwise
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
    	boolean alreadyFriend = false;
    	if(groupAlreadyExist(circle)) {
    		Set<U> friends = new HashSet<U>(followedUers.get(circle));
    		alreadyFriend = friends.add(user);
    		followedUers.put(circle, friends);
    	}else {
    		followedUers.put(circle, Set.of(user));
    	}
    		return alreadyFriend;
        
    }

 
	@Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
       if(groupAlreadyExist(groupName)) {
    	   return new HashSet<U>(followedUers.get(groupName));
       }
       return Collections.emptyList();
    }

    @Override
    public List<U> getFollowedUsers() {
       Set<U> allfriends = new HashSet<U>();
       for(var entry : followedUers.entrySet()) {
    	   allfriends.addAll(entry.getValue());
       }
       return List.copyOf(allfriends);
    }

}
