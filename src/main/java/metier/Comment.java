package metier;

import java.util.Date;

public class Comment {
    private int id;
    private String content;
    private User author;
    private Post post;
    private Date createdAt;
    private Date updatedAt;
    
    public Comment() {
    	this.createdAt = new Date();
		this.updatedAt = new Date();
    }
    public Comment(String content, Post post, User author) {
		this.content = content;
		this.author = author;
		this.post = post;
		this.createdAt = new Date();
		this.updatedAt = new Date();
		post.getComments().add(this);
	}

	public int getId() {
        return id;
    }
	public void setId(int id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date date) {
		this.createdAt = date;		
	}
    public Date getUpdatedAt() {
        return updatedAt;
    }

	public void setUpdatedAt(Date date) {
		this.updatedAt = date;		
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", author=" + author.getUsername() + ", blogPost=" + post.getTitle()
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
