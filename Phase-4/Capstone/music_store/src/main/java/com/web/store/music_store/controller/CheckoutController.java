package com.web.store.music_store.controller;

import java.text.ParseException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.web.store.music_store.model.AlbumGenre;
import com.web.store.music_store.model.User;
import com.web.store.music_store.service.AlbumGenreService;
import com.web.store.music_store.service.UserService;

@Controller
public class CheckoutController {

	@Autowired
	UserService uService;

	@Autowired
	AlbumGenreService service;

	@PostMapping(value="/addToCart")
	public String addToCart(@RequestParam int id, ModelMap model, HttpServletRequest request, Principal principal) throws ParseException {
		String n = principal.getName();
		User user = uService.findByUsername(n);
		String newCart = uService.addToCart(id, user);
	    String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}

	@PostMapping(value="/removeFromCart")
	public String removeFromCart(@RequestParam int id, ModelMap model, HttpServletRequest request, Principal principal) throws ParseException {
		String n = principal.getName();
		User user = uService.findByUsername(n);
		String newCart = uService.removeFromCart(id, user);
	    String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}

	@GetMapping(value="/cart")
	public String showCart(ModelMap model, Principal principal) throws ParseException {
		String n = principal.getName();
		User user = uService.findByUsername(n);
		int[] cart = uService.getCart(user);
		List<AlbumGenre> list = new ArrayList<>();
		for(int i=0; i<cart.length; i++) {
			//System.out.println(cart[i]);
			list.add(service.find(cart[i]));
		}
		List<AlbumGenre> listCopy = new ArrayList<>();
		listCopy.addAll(list);
		Iterator<AlbumGenre> it = list.iterator();
		Iterator<AlbumGenre> it2 = listCopy.iterator();
		model.put("albums", it);
		model.put("cart", it2);
		return "cart";
	}

	@GetMapping(value="/checkout")
	public String showCheckout(ModelMap model, Principal principal) throws ParseException {
		String n = principal.getName();
		User user = uService.findByUsername(n);
		int[] cart = uService.getCart(user);
		List<AlbumGenre> list = new ArrayList<>();
		for(int i=0; i<cart.length; i++) {
			//System.out.println(cart[i]);
			list.add(service.find(cart[i]));
		}
		List<AlbumGenre> listCopy = new ArrayList<>();
		listCopy.addAll(list);
		Iterator<AlbumGenre> it = list.iterator();
		Iterator<AlbumGenre> it2 = listCopy.iterator();
		model.put("albums", it);
		model.put("cart", it2);
		return "checkout";
	}

	@GetMapping(value="/checkout/success")
	public String showCheckoutSuccess() throws ParseException {
		return "checkout_success";
	}

	@PostMapping(path="/checkout", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String postCheckout(@RequestParam MultiValueMap<String,String> paramMap, ModelMap model, Principal principal) throws ParseException, UnsupportedEncodingException {
		String n = principal.getName();
		User user = uService.findByUsername(n);
		user.setCart("");
		String fullName = paramMap.getFirst("fullName");
		String billingAddress = paramMap.getFirst("billingAddress");
		String cardNumber = paramMap.getFirst("cardNumber");

		String notice = "";
		//check for empty input
		if (fullName.length() == 0) notice += "Error: missing full name<br>";
		if (billingAddress.length() == 0) notice += "Error: missing billing address<br>";
		if (cardNumber.length() == 0) notice += "Error: missing card number<br>";
		if (notice.length() > 0) {
			notice = notice.substring(0, notice.length() - 4);
			notice = Base64.getEncoder().encodeToString(notice.getBytes());
			notice = URLEncoder.encode(notice, "UTF-8");
			return "redirect:/checkout?error=" + notice;
		}

		user.setFullName(fullName);
		user.setBilling(billingAddress);
		user.setCardNum(cardNumber);
		uService.saveUser(user);
		return "checkout_success";
	}

}
