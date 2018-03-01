package pl.coderslab.controller;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.coderslab.entity.Message;
import pl.coderslab.entity.User;
import pl.coderslab.repository.MessageRepository;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping(path = "/messages")
public class MessageController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TweetRepository tweetRepository;
	@Autowired
	private MessageRepository messageRepository;
	
	
	// USER MESSAGES
	@GetMapping(path = "/{id}")
	public String showUserMessages(@PathVariable Long id, Model model,
			@SessionAttribute(name="user", required = true) User user) {
		
		model.addAttribute("user", user);
		Collection<Message> recievedMessages = messageRepository.findByReceiverIdOrderByCreatedDesc(id);
		model.addAttribute("recievedMessages", recievedMessages);
		Collection<Message> sendMessages = messageRepository.findBySenderIdOrderByCreatedDesc(id);
		model.addAttribute("sendMessages", sendMessages);
		return "messages/userMessages";
	}
	
	// SEND MESSAGE
	@GetMapping(path = "/send/{id}")
	public String sendMessage(@PathVariable Long id, Model model) {

		model.addAttribute("newMessage", new Message());
		User sendTo = userRepository.findOne(id);
		model.addAttribute("sendTo", sendTo);
		return "messages/newMessage";
	}
	@PostMapping(path = "/send/{id}")
	public String registerComment(Message newMessage, User sendTo,
			@SessionAttribute(name = "user", required = false) User user) {

		if (user != null) {
			
			newMessage.setCreated(LocalDateTime.now());
			newMessage.setSender(user);
			newMessage.setReceiver(sendTo);
			newMessage.setNotReadYet(true);
			messageRepository.save(newMessage);
			
			return "redirect:/messages/"+user.getId();
		} else {
			return "user/login";
		}
	}
	
	// MESSAGE DETAILS
	@GetMapping(path = "/messageDetails/{id}")
	public String messageDetails(@PathVariable Long id, Model model) {

		Message message = messageRepository.findOne(id);
		message.setNotReadYet(false);
		messageRepository.saveAndFlush(message);
		model.addAttribute("message", message);
		
		
		
		return "messages/messageDetails";
	}	

}
