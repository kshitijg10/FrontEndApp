package com.kshitij.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.kshitij.web.LoginResponse;
import com.kshitij.web.Message;
import com.kshitij.web.States;
import com.kshitij.web.User;

@Controller
public class FrontEndController {
	
	private static RestTemplate restTemplate = new RestTemplate();
	private static final String systemUrl = "http://localhost:8888/";
	
	static {
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/state/{state}", method = RequestMethod.GET)
	public ModelAndView state(@PathVariable String state) {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("stateDetails");
		try {
			ResponseEntity<States> states = getStates(state);
			Map<String, Object> model = modelView.getModel();
			model.put("state", states.getBody());
		} catch (Exception e) {
		}
		return modelView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="user", required=false) String user, 
	        @RequestParam(value="pass", required=false) String pass, HttpServletResponse servletResponse) {
		User login = new User();
		login.setUser(user);
		login.setPassword(pass);
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		try {
			HttpEntity<User> entity = new HttpEntity<User>(login, header);
			restTemplate.exchange(systemUrl + "login", HttpMethod.POST, entity, LoginResponse.class);
		} catch (Exception e) {
			ModelAndView model = new ModelAndView();
			model.setViewName("error");
			return model;
		}
		Cookie cookie = new Cookie("login", user);
		servletResponse.addCookie(cookie);
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("login");
		try {
			ResponseEntity<States[]> states = getStates(100);
			Map<String, Object> model = modelView.getModel();
			model.put("states", states.getBody());
		} catch (Exception e) {
		}
		return modelView;

	}
	
	@RequestMapping(value = "/states", method = RequestMethod.GET)
	public ModelAndView states() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("login");
		try {
			ResponseEntity<States[]> states = getStates(100);
			Map<String, Object> model = modelView.getModel();
			model.put("states", states.getBody());
		} catch (Exception e) {
		}
		return modelView;

	}
	
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public ModelAndView messages() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("messages");
		try {
			HttpHeaders header = new HttpHeaders();
		    HttpEntity<User> entity = new HttpEntity<User>(header);
			ResponseEntity<List> messages = restTemplate.exchange(systemUrl + "read", HttpMethod.GET, entity, List.class);
			Map<String, Object> model = modelView.getModel();
			model.put("messages", messages.getBody());
		} catch (Exception e) {
		}
		return modelView;

	}
	
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public ModelAndView message(@RequestParam(value="phone", required=false) String phone, 
	        @RequestParam(value="message", required=false) String message, HttpServletRequest request) {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("messages");
		Message msg = new Message();
		msg.setPhone(phone);
		msg.setMessage(message);
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", "application/json");
			for(Cookie cookie : request.getCookies() ) {
				if("login".equals(cookie.getName())) {
					header.add("Cookie", "login="+cookie.getValue());					
				}
			}
		    HttpEntity<Message> entity = new HttpEntity<Message>(msg,header);
			ResponseEntity<List> messages = restTemplate.exchange(systemUrl + "write", HttpMethod.POST, entity, List.class);
			Map<String, Object> model = modelView.getModel();
			model.put("messages", messages.getBody());
		} catch (Exception e) {
		}
		return modelView;

	}

	private ResponseEntity<States[]> getStates(int limit) {
		HttpHeaders header = new HttpHeaders();
	    HttpEntity<User> entity = new HttpEntity<User>(header);
	    ResponseEntity<States[]> states = restTemplate.exchange(systemUrl + "states?limit="+limit, HttpMethod.GET, entity, States[].class);
	    return states;
    }
	
	private ResponseEntity<States> getStates(String state) {
		HttpHeaders header = new HttpHeaders();
	    HttpEntity<User> entity = new HttpEntity<User>(header);
	    ResponseEntity<States> states = restTemplate.exchange(systemUrl + "states/"+state, HttpMethod.GET, entity, States.class);
	    return states;
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		try {
			MultiValueMap<String, String> header = new HttpHeaders();
			HttpEntity entity = new HttpEntity(header);
			restTemplate.exchange(systemUrl + "logout", HttpMethod.GET, entity, String.class);
		} catch (Exception e) {
			ModelAndView model = new ModelAndView();
			model.setViewName("login");
			return model;
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;

	}

}