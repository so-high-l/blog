package metier;

import java.util.ArrayList;

public class Categorie {
	private int id;
	private String name;
	private String description;
	ArrayList<Post> posts;
	
	public Categorie() {
		posts = new ArrayList<Post>();
	}
	public Categorie(String name, String description) {
		this.name = name;
		this.description = description;
		posts = new ArrayList<Post>();

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Post> getPosts() {
		return posts;
	}
	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}
	public void addPost(Post post) {
		if(!posts.contains(post)) {
			posts.add(post);
		}
	}
	public void deletePost(int id) {
		for(int i = 0; i < posts.size(); i++) {
			if(posts.get(i).getId()==(id)) {
				posts.remove(posts.get(i));
			}
		}
	}
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
}
