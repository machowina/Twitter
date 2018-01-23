package pl.coderslab.controller;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TweetRepository tweetRepository;
	

	@GetMapping(path = "/")
	public String home(Model model, @SessionAttribute(name="user", required = false) User user) {
		Tweet newTweet = new Tweet();
		model.addAttribute("newTweet", newTweet);
		Collection<Tweet> tweets = tweetRepository.findByOrderByCreatedDesc();
		model.addAttribute("tweets", tweets);
		model.addAttribute("user", user);
		return "index";
	}
	@PostMapping(path = "/")
	public String registerTweet(@Valid Tweet newTweet, BindingResult bresult, 
			@SessionAttribute(name="user", required = false) User user) {
		
		if (user!=null) {
			
			if(bresult.hasErrors()) {
	            return "index";
	        } else {
	      
	        	newTweet.setCreated(LocalDateTime.now());
	        	newTweet.setUser(user);
	    		tweetRepository.save(newTweet);
	    		return "redirect:/";
	        }
		} else {
			return "user/login";
		}
		
	}
}
