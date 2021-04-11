package com.web.store.music_store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.store.music_store.model.Role;
import com.web.store.music_store.model.User;
import com.web.store.music_store.repository.RoleRepository;
import com.web.store.music_store.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //public User findUserByEmail(String email) {
    //    return userRepository.findByEmail(email);
    //}

    public User findUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRoles("USER");
        return userRepository.save(user);
    }
    
	public User findByUsername(String un){
		return userRepository.findByUsername(un);
	}
	
	public User findById(int id){
		return findByIdPrivate(id);
	}//end of 'findById(int)' 
	
	private User findByIdPrivate(int id) {
		Optional<User> acct = userRepository.findById(id);
		return acct.get();
	}//end of method 'findByIdPrivate(int)'
	
	public User VerifyLogIn(String uName, String pWord) {
		return VerifyLogInUser(uName, pWord);
	}//end of method 'VerifyLogIn(String, String)'
	
	private User VerifyLogInUser(String uName, String pWord) {
		try {
				User acct = userRepository.findByUsername(uName);
				if(acct == null) {
					return null;
				}/**end of (acct == null) 'if statment'**/else{
					if(((uName.equalsIgnoreCase(acct.getUsername())) && (pWord.equals(pWord)))) {
						acct.setActive(true);
						return acct;
					}/**end of (uName && pWord) 'if statement**/else {
						return null;
					}//end of (uName && pWord) 'else'
				}//end of (acct == null) 'else' 	
			}/**end of try block**/catch(Exception ex) {
				System.out.println("ERROR, ERROR, ERROR ---------------- " + ex);
				return null;
			}//end of 'try-catch' block
	}//end of method 'VerifyLogInUser(String, String)'
	
	public boolean logOut(User user) {
		return logOutUser(user);
	}//end of method 'logOut(User)'
	
	private boolean logOutUser(User user) {
		User acct = ((UserRepository) userRepository).findByUsername(user.getUsername());
	    acct.setActive(false);
	    return acct.getActive();
	}//end of method 'logoutUser(user)'
	
	public String findRoleById(User user) {
		return findRole(user);
	}//end of method 'findRoleById(User)'
	
	private String findRole(User user) {
		Optional<User> acct = userRepository.findById(user.getUser_id());
		//return acct.get().getRoles();
		return "USER";
//		if(acct.get().getRole().equals("admin")) {
//			return "admin";
//		}/**end of (acct.equals("admin")) 'if statment'**/else if(acct.get().getRole().equals("user")) {
//			return "user";
//		}/**end of (acct.equals("user")) 'else-if statment'**/else {
//			return null;
//		}//end of (acct.equals("admin")) 'else'
	}//end of method 'findRole(User)'
	
	public int[] getCart(User user) {
		return getCartAll(user);
	}//end of method 'getCart(String)'
	
	private int[] getCartAll(User user) {
		User foundUser = userRepository.findById(user.getUser_id()).get();
		if (foundUser.getCart().length() == 0) return new int[0];
		
		String cart = foundUser.getCart();
		int[] cartArray = new int[cart.split(",").length];
		
		int i = 0;
		for(String item : cart.split(",")) {
			cartArray[i] = Integer.parseInt(item);
			i++;
		}
		
		return cartArray;
	}
	
	public String addToCart(int item, User user) {
		return addCart(item, user);
	}//end of method 'addToCart(int, User)'
	
	private String addCart(int item, User user) {
		User foundUser = userRepository.findById(user.getUser_id()).get();
		if (foundUser.getCart().length() == 0) {
			foundUser.setCart(item + "");
			saveUser(foundUser);
			return foundUser.getCart();
		}
		
		String fixedCart = removeFromCart(item, foundUser);
		List<String> cartArray = new ArrayList<String>(Arrays.asList(fixedCart.split(",")));
		cartArray.add(item + "");
		String[] newCartArray = cartArray.toArray(new String[cartArray.size()]);
		String newCart = String.join(",", newCartArray);
		foundUser.setCart(newCart);
		saveUser(foundUser);
		return foundUser.getCart();
	}
	
	public String removeFromCart(int item, User user) {
		User foundUser = userRepository.findById(user.getUser_id()).get();
		List<String> cartArray = new ArrayList<String>(Arrays.asList(foundUser.getCart().split(",")));
		cartArray.remove(item + "");
		String[] newCartArray = cartArray.toArray(new String[cartArray.size()]);
		String newCart = String.join(",", newCartArray);
		foundUser.setCart(newCart);
		saveUser(foundUser);
		return foundUser.getCart();
	}
	
	public boolean isUserLoggedIn(User user) {
		return isLoggedIn(user);
	}//end of method 'isUserLoggedIn(User)'
	
	private boolean isLoggedIn(User user) {
		Optional<User> acct = userRepository.findById(user.getUser_id());
		return acct.get().getActive();
	}//end of method 'isLoggedIn(User)'
	
	public User verify(String username, String password) {
		List<User> userList = ((ArrayList<User>)userRepository.findAll()).stream().filter(t->t.getUsername().equals(username))
				.filter(i->i.getPassword().equals(password)).collect(Collectors.toList());
		for(User user : userList) {
			return user;
		}
		return null;
	}

}
