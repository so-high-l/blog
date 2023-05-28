package web;

import java.util.ArrayList;

import metier.*;


public class Model {
	private Post post;
	private ArrayList<Post> posts;
	private ArrayList<Comment> postComments;
	private ArrayList<Post> trendingPosts;
	private User user;
    private int loggedId;
    private String loggedUsername;
    private String loggedPassword;
    private String loggedEmail;
	private ArrayList<Post> postsLikedByLoggedUser;
	private ArrayList<Post> postsByLoggedUser;
	private int nbrOfPostsByUser;
	private int nbrOfLikes;
	private ArrayList<Categorie> categories;
	public Model() {
		posts = new ArrayList<Post>();
		setCategories(new ArrayList<Categorie>());
		postsByLoggedUser = new ArrayList<Post>();
	}


	public ArrayList<Post> getPosts() {
		return posts;
	}


	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public ArrayList<Post> getTrendingPosts() {
		return trendingPosts;
	}


	public void setTrendingPosts(ArrayList<Post> trendingPosts) {
		this.trendingPosts = trendingPosts;
	}


	public int getLoggedId() {
		return loggedId;
	}


	public void setLoggedId(int loggedId) {
		this.loggedId = loggedId;
	}


	public String getLoggedUsername() {
		return loggedUsername;
	}


	public void setLoggedUsername(String loggedUsername) {
		this.loggedUsername = loggedUsername;
	}


	public String getLoggedPassword() {
		return loggedPassword;
	}


	public void setLoggedPassword(String loggedPassword) {
		this.loggedPassword = loggedPassword;
	}


	public String getLoggedEmail() {
		return loggedEmail;
	}


	public void setLoggedEmail(String loggedEmail) {
		this.loggedEmail = loggedEmail;
	}


	public ArrayList<Post> getPostsByLoggedUser() {
		return postsByLoggedUser;
	}


	public void setPostsByLoggedUser(ArrayList<Post> postsByLoggedUser) {
		this.postsByLoggedUser = postsByLoggedUser;
	}


	public int getNbrOfPostsByUser() {
		return nbrOfPostsByUser;
	}


	public void setNbrOfPostsByUser(int nbrOfPostsByUser) {
		this.nbrOfPostsByUser = nbrOfPostsByUser;
	}


	public int getNbrOfLikes() {
		return nbrOfLikes;
	}


	public void setNbrOfLikes(int nbrOfLikes) {
		this.nbrOfLikes = nbrOfLikes;
	}


	public ArrayList<Post> getPostsLikedByLoggedUser() {
		return postsLikedByLoggedUser;
	}


	public void setPostsLikedByLoggedUser(ArrayList<Post> postsLikedByLoggedUser) {
		this.postsLikedByLoggedUser = postsLikedByLoggedUser;
	}


	public ArrayList<Categorie> getCategories() {
		return categories;
	}


	public void setCategories(ArrayList<Categorie> categories) {
		this.categories = categories;
	}


	public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}


	public ArrayList<Comment> getPostComments() {
		return postComments;
	}


	public void setPostComments(ArrayList<Comment> postComments) {
		this.postComments = postComments;
	}
	
	
}
