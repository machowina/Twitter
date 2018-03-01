package pl.coderslab.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(nullable = false, unique = true)
	private String username;
	
	@NotEmpty
	@Column(nullable = false)
	private String password;
	
	private boolean enabled;
	
	@NotEmpty
	@Email
	@Column(nullable = false, unique = true)
	private String email;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_user")
	private Collection<Tweet> tweets;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_id")
	private Collection<Comment> comments;
	
	@OneToMany
	@JoinColumn(name = "sender_id")
	private Collection<Message> sendMessages;
	
	@OneToMany
	@JoinColumn(name = "recipient_id")
	private Collection<Message> recievedMessages;
	
	
	
	public Collection<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(Collection<Tweet> tweets) {
		this.tweets = tweets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", email=" + email + "]";
	}
}
