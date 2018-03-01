package pl.coderslab.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
	
	Collection<Message> findBySenderIdOrderByCreatedDesc(Long senderId);
	Collection<Message> findByReceiverIdOrderByCreatedDesc(Long receiverId);

}
