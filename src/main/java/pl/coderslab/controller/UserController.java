package pl.coderslab.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TweetRepository tweetRepository;
	
	//USER LOGGING
	@GetMapping(path = "/login")
	public String showLoginForm() {
		return "user/login";
	}
	@PostMapping(path = "/login")
	public String processLoginRequest(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model, HttpSession session) {
		
		User user = userRepository.findOneByUsername(username);
		
		if(user != null) {
			if (BCrypt.checkpw(password, user.getPassword())) {
				session.setAttribute("user", user);
				model.addAttribute("username", username);
				return "redirect:/";
			} else {
				return "user/login";
			}
		} else {
			return "user/login";
		}
	}
	//LOGOUT
	@GetMapping(path = "/logout")
	public String processLogoutRequest(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	//REGISTER
	@GetMapping(path = "/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "user/register";
	}
	@PostMapping(path = "/register")
	public String processRegistartionRequest(@Valid User user, BindingResult bresult, HttpSession session) {
		
		if(bresult.hasErrors()) {
			return "user/register";
		
		} else {
			String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashedPassword);
			userRepository.save(user);
			session.setAttribute("user", user);
			return "redirect:/";
		}
	}
	// USER PAGE
	@GetMapping(path = "/userPage/{id}")
	public String showUserPage(@PathVariable Long id, Model model) {
		
		Collection<Tweet> tweets = tweetRepository.findByUserId(id);
		User user = userRepository.findOne(id);
		
		model.addAttribute("tweets", tweets);
		model.addAttribute("user", user);
	
		return "user/userPage";
		
	}
	
}