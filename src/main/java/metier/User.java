package metier;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private Date createdAt;
    private Date updatedAt;
    private ArrayList<Post> posts;
    private ArrayList<Like> likes;

    public User(String username,String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.posts = new ArrayList<Post>();
		createdAt = new Date();
		updatedAt = new Date();

	}

	public User() {
		this.posts = new ArrayList<Post>();
		createdAt = new Date();
		updatedAt = new Date();	}

	public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

	public ArrayList<Post> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}
	
	public void addPost(Post post) {
		if(!posts.contains(post)){
			posts.add(post);
		}
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	public void setId(int id) {
        this.id = id;
		
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public ArrayList<Like> getLikes() {
		return likes;
	}
}

