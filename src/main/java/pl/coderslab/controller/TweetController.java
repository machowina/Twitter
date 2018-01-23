package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;

@Controller
@RequestMapping(path = "/tweet")
public class TweetController {
	
	@Autowired
	private TweetRepository tweetRepository;

	// TWEET PAGE
		@GetMapping(path = "/{id}")
		public String showTweetDetails(@PathVariable Long id, Model model) {
			
			Tweet tweet = tweetRepository.findOne(id);
			model.addAttribute("tweet", tweet);
		
			return "tweet/tweetDetails";
			
		}
}
