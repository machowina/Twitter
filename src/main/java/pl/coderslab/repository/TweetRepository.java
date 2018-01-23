package pl.coderslab.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
	
	Collection<Tweet> findByUser(User user);
	Collection<Tweet> findByUserId(long userId);
	Collection<Tweet> findByOrderByCreatedDesc();
   
}
