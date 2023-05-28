package dao;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import metier.*;
public interface IPostDao {
	// Post
	public Post savePost(Post post); 
	public Post getPostById(int id);
	public Post updatePost(int id, Post post);
	public void deletePost(int id);
	// User
	public User saveUser(User user);
	public User getUserById(int id);
	public User updateUser(int id, User u);
	public void deleteUser(int id);
	// Comment
	public Comment saveComment(Comment  comment);
	public Comment getCommentById(int id);
	public Comment updateComment (int id, Comment  comment);
	public void deleteComment (int id);
	// Categorie
	public Categorie saveCategorie(Categorie  categorie);
	public Categorie getCategorieById(int id);
	public Categorie updateCategorie(int id, Categorie categorie);
	public void deleteCategorie(int id);
	// Like
	public Like saveLike(Like like);
	public void deleteLike(int id);
	// Others 
	public ArrayList<Post> getPosts(int limit);
	public ArrayList<Post> getAllPosts();
	public ArrayList<Categorie> getAllCategories();
	public ArrayList<Post> getPostsByUser(int id);
	public ArrayList<Post> getPostsByCategorie(int id);
	public ArrayList<Post> getPostsByMc(String mc);
	public ArrayList<Post> getPostsLikedByUser(int id);
	
	public ArrayList<Comment> getCommentsByUser(int id);
	public ArrayList<Comment> getCommentsByPost(int id);
	
	public boolean verifyLogin(String username, String password, HttpSession session);
	public User getUserByCredentials(String username, String password);
	
	public ArrayList<Post> mostLikes();
	public ArrayList<Like> getLikesByPost(int id);
	
	public int getNbrLikesOfPost(int id);
	public int getNbrCommentsOfPost(int id);
	public int getLikeByUserAndPost(User user,Post post);
}