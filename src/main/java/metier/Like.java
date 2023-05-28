package metier;
import java.util.Date;

public class Like {
    private int id;
    private User user;
    private Post post;
    private Date createdAt;

    public Like(User user, Post post) {
		this.user = user;
		this.post = post;
		this.createdAt = new Date();
	}
    public Like() {
    	
    }
	public int getId() {
        return id;
    }
	public void setId(int id) {
		this.id = id;
	}
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Post getPost() {
        return post;
    }
    public void setPost(Post Post) {
        this.post = Post;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

	@Override
	public String toString() {
		return "Like [id=" + id + ", user=" + user.getUsername() + ", Post=" + post.getTitle() + ", createdAt=" + createdAt + "]";
	}
    
}
