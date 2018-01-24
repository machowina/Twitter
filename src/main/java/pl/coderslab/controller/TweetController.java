package pl.coderslab.controller;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.validation.Valid;

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

import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.TweetRepository;

@Controller
@RequestMapping(path = "/tweet")
public class TweetController {

	@Autowired
	private TweetRepository tweetRepository;
	@Autowired
	private CommentRepository commentRepository;

	// TWEET PAGE
	@GetMapping(path = "/{id}")
	public String showTweetDetails(@PathVariable Long id, Model model) {

		Tweet tweet = tweetRepository.findOne(id);
		model.addAttribute("tweet", tweet);
		Collection<Comment> comments = commentRepository.findByTweetOrderByCreatedDesc(tweet);
		model.addAttribute("comments", comments);
		model.addAttribute("newComment", new Comment());
		return "tweet/tweetDetails";
	}
	@PostMapping(path = "/{id}")
	public String registerComment(Comment newComment, Tweet tweet,
			@SessionAttribute(name = "user", required = false) User user) {

		if (user != null) {
			Comment commentToSave = new Comment();
			commentToSave.setText(newComment.getText());
			commentToSave.setCreated(LocalDateTime.now());
			commentToSave.setUser(user);
			commentToSave.setTweet(tweet);
			commentRepository.save(commentToSave);
			
			return "redirect:/tweet/"+tweet.getId();
		} else {
			return "user/login";
		}
	}
}
