package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Post {
    private int id;
    private String title;
    private String content;
    private User author;
    private Categorie categorie;
    private Date createdAt;
    private Date updatedAt;
    private ArrayList<Like> likes;
    private ArrayList<Comment> comments;
    private int nbrOfLikes;
    private int nbrOfComments;
    private boolean isLiked;


    public Post(String title, String content, User author, Categorie categorie) {
		this.title = title;
		this.content = content;
		this.author = author;
		this.categorie = categorie;
		this.createdAt = new Date();
		this.updatedAt = new Date();
		this.likes = new ArrayList<Like> ();
		this.comments = new ArrayList<Comment> ();
	}
    public Post() {
    	this.createdAt = new Date();
		this.updatedAt = new Date();
		this.likes = new ArrayList<Like> ();
		this.comments = new ArrayList<Comment> ();
	}
	public int getId() {
        return id;
    }
	public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
    public Date getCreatedAt() {
        return createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public ArrayList<Like> getLikes() {
		return likes;
	}
	public void setLikes(ArrayList<Like> likes) {
		this.likes = likes;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
    public ArrayList<Comment> getComments() {
		return comments;
	}
	public void setUpdatedAt(Date updatedAt2) {
		this.updatedAt = updatedAt2;		
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public int getNbrOfLikes() {
		return nbrOfLikes;
	}
	public void setNbrOfLikes(int nbrOfLikes) {
		this.nbrOfLikes = nbrOfLikes;
	}
	public int getNbrOfComments() {
		return nbrOfComments;
	}
	public void setNbrOfComments(int nbrOfComments) {
		this.nbrOfComments = nbrOfComments;
	}
	public boolean isLiked() {
		return isLiked;
	}
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author +"]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return id == other.id;
	}
	
	
}

