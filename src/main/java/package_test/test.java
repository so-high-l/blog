package package_test;
import java.util.ArrayList;

import dao.PostDaoImpl;
import metier.*;

public class test {

	public static void main(String[] args) {
		
		PostDaoImpl metier = new PostDaoImpl();
//		//Create Categoties in java
//		ArrayList<Categorie> categories = new ArrayList<>();
//		for(int i=1;i<=3;i++) {
//			categories.add(new Categorie("categorie"+i,"description"+i));
//		}
//		//Create users
//		ArrayList<User> users = new ArrayList<>();
//		for(int i=1;i<=5;i++) {
//			users.add(new User("nom"+i,"email"+i+"@gmail.com","pass"+i));
//		}
//		//Create Posts
//		ArrayList<Post> posts = new ArrayList<>();
//		for(int i=1;i<=4;i++) {
//			posts.add(new Post("title"+i,"content"+i,users.get(0),categories.get(0)));
//		}
//		for(int i=5;i<=6;i++) {
//			posts.add(new Post("post"+i,"content"+i,users.get(1),categories.get(2)));
//		}
//		for(int i=7;i<=8;i++) {
//			posts.add(new Post("title"+i,"content"+i,users.get(2),categories.get(1)));
//		}
//		posts.add(new Post("title"+9,"content"+9,users.get(3),categories.get(0)));
//		posts.add(new Post("title"+10,"contentpost"+10,users.get(4),categories.get(2)));
//		//Create likes
//		ArrayList<Like> likes = new ArrayList<>();
//		for(int i=1;i<=3;i++) {
//			likes.add(new Like(users.get(4),posts.get(0)));
//		}
//		for(int i=4;i<=13;i++) {
//			likes.add(new Like(users.get(3),posts.get(4)));
//		}
//		for(int i=14;i<=21;i++) {
//			likes.add(new Like(users.get(1),posts.get(3)));
//		}
//		for(int i=22;i<=28;i++) {
//			likes.add(new Like(users.get(0),posts.get(1)));
//		}
//		likes.add(new Like(users.get(2),posts.get(4)));
//		likes.add(new Like(users.get(0),posts.get(8)));
//		//create comments
//		ArrayList<Comment> comments = new ArrayList<>();
//		for(int i=1;i<=7;i++) {
//			comments.add(new Comment("content"+i,posts.get(2),users.get(4)));
//		}
//		for(int i=8;i<=15;i++) {
//			comments.add(new Comment("content"+i,posts.get(0),users.get(2)));
//		}
//		for(int i=16;i<=20;i++) {
//			comments.add(new Comment("content"+i,posts.get(3),users.get(0)));
//		}
//		comments.add(new Comment("content"+16,posts.get(6),users.get(1)));
//		//create
//		for(int i=0;i<categories.size();i++) {
//			metier.saveCategorie(categories.get(i));
//		}
//		for(int i=0;i<users.size();i++) {
//			metier.saveUser(users.get(i));
//		}
//		for(int i=0;i<posts.size();i++) {
//			metier.savePost(posts.get(i));
//		}
//		for(int i=0;i<likes.size();i++) {
//			metier.saveLike(likes.get(i));
//		}
//		for(int i=0;i<comments.size();i++) {
//			metier.saveComment(comments.get(i));
//		}
//		//read
//		System.out.println(metier.getCategorieById(categories.get(1).getId()));
//		System.out.println(metier.getUserById(users.get(0).getId()));
//		System.out.println(metier.getPostById(posts.get(7).getId()));
//		System.out.println(metier.getCommentById(149));
//		//getallposts
//		System.out.println("----------------------tous les posts-----------------");
//		for(Post p : metier.getAllPosts() )
//			System.out.println(p);
//		//getPostsByUser
//		System.out.println("----------------------posts de user1------------------");
//		for(Post p : metier.getPostsByUser(users.get(0).getId()))
//			System.out.println(p);
//		//getPostsByCategorie
//		System.out.println("----------------------posts de categorie3-------------");
//		for(Post p : metier.getPostsByCategorie(categories.get(1).getId()) )
//			System.out.println(p);
//		//getPostsByMc
//		System.out.println("----------------------posts contient le mot 'post'-------");
//		for(Post p : metier.getPostsByMc("%post%"))
//			System.out.println(p);
//		//getCommentsByPost
//		System.out.println("----------------------comments on post4-----------");
//		for(Comment c : metier.getCommentsByPost(posts.get(3).getId()))
//			System.out.println(c);
//		//getCommentsByUser
//		System.out.println("----------------------comments de user3-----------");
//		for(Comment c : metier.getCommentsByUser(users.get(2).getId()))
//			System.out.println(c);
//		//mostLikes()
//		System.out.println("----------------------posts de most likes");
//		for(Post p : metier.mostLikes())
//			System.out.println(p);
		Post p = new Post("yassine","yassinepost",metier.getUserById(48),metier.getCategorieById(28));
		metier.savePost(p);
	}
}