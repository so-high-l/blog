package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import metier.Categorie;
import metier.Comment;
import metier.Post;
import metier.User;




@WebServlet(name="Controller", urlPatterns="*.do")
public class Controller extends HttpServlet {
	private IPostDao metier;
	@Override
	public void init() throws ServletException {
		metier = new PostDaoImpl();
	}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//        response.setHeader("Expires", "0"); // Proxies.
        	if(path.equals("/index.do")) {
        		HttpSession session = request.getSession(false); // Get the session without creating a new one

	        	if (session == null || session.getAttribute("id") == null) {
	        	    
	        	    response.sendRedirect("index.jsp"); 
	        	} else {
	        		Model userModel = new Model();
	                int loggedId = (int) session.getAttribute("id");
	                String loggedUsername = (String) session.getAttribute("username");
	                String loggedPassword = (String) session.getAttribute("password");
	                String loggedEmail = (String) session.getAttribute("email");
	                userModel.setUser(metier.getUserByCredentials(loggedUsername, loggedPassword));
	                ArrayList<Post> posts = metier.getAllPosts();
	                ArrayList<Post> postsLikedByUser = metier.getPostsLikedByUser(userModel.getUser().getId());

	                for (Post post : posts) {
	                    post.setNbrOfLikes(metier.getNbrLikesOfPost(post.getId()));
	                    post.setNbrOfComments(metier.getNbrCommentsOfPost(post.getId()));
	                    boolean likedFlag = postsLikedByUser.contains(post);
	                    post.setLiked(likedFlag);
	                }

	                userModel.setPosts(posts);
	                userModel.setTrendingPosts(metier.mostLikes());
	                
	                request.setAttribute("userModel", userModel);
	        		request.getRequestDispatcher("home.do").forward(request, response);
	        	}
        } else if (path.equals("/home.do")) {
            HttpSession session = request.getSession(false); // Get the session without creating a new one

            if (session == null || session.getAttribute("id") == null) {
                response.sendRedirect("index.jsp");
            } else {
                Model userModel = new Model();
                int loggedId = (int) session.getAttribute("id");
                String loggedUsername = (String) session.getAttribute("username");
                String loggedPassword = (String) session.getAttribute("password");
                String loggedEmail = (String) session.getAttribute("email");
                userModel.setUser(metier.getUserByCredentials(loggedUsername, loggedPassword));
                ArrayList<Post> posts = metier.getAllPosts();
                ArrayList<Post> postsLikedByUser = metier.getPostsLikedByUser(userModel.getUser().getId());

                for (Post post : posts) {
                    post.setNbrOfLikes(metier.getNbrLikesOfPost(post.getId()));
                    post.setNbrOfComments(metier.getNbrCommentsOfPost(post.getId()));
                    boolean likedFlag = postsLikedByUser.contains(post);
                    post.setLiked(likedFlag);
                }

                userModel.setPosts(posts);
                userModel.setTrendingPosts(metier.mostLikes());
                
                request.setAttribute("userModel", userModel);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        } else if(path.equals("/logout.do")) {
        	HttpSession session = request.getSession(false); // Get the session without creating a new one
            
            if (session != null) {
                session.removeAttribute("id");
                session.removeAttribute("username");
                session.removeAttribute("email");
                session.removeAttribute("password");
                session.invalidate(); // Destroy the session
            }
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if(path.equals("/login.do")) {
        	HttpSession session = request.getSession(false); // Get the session without creating a new one
        	 if (session == null || session.getAttribute("id") == null) {
                 request.getRequestDispatcher("index.jsp").forward(request, response);
             } else {
            	 response.sendRedirect("home.do"); 
            	 
             }
        } else if(path.equals("/profile.do")) {
        	HttpSession session = request.getSession(false); // Get the session without creating a new one
       	 	if (session == null || session.getAttribute("id") == null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
           	 Model userModel = new Model();
           	 int loggedId = (int) session.getAttribute("id");
           	 String username = (String) session.getAttribute("username");
           	 String email = (String) session.getAttribute("email");
           	 String password = (String) session.getAttribute("password");
	            ArrayList<Post> postsByLoggedUser = metier.getPostsByUser(loggedId);
                ArrayList<Post> postsLikedByUser = metier.getPostsLikedByUser(loggedId);
                ArrayList<Categorie> categories = metier.getAllCategories();
                
	            int nbrOfPosts = postsByLoggedUser.size();
	            int nbrOfLikes = 0;
	            for(Post post: metier.getPostsByUser(loggedId)) {
	            	nbrOfLikes = nbrOfLikes + metier.getLikesByPost(post.getId()).size();
	            }
	            for (Post post : postsByLoggedUser) {
                    post.setNbrOfLikes(metier.getNbrLikesOfPost(post.getId()));
                    post.setNbrOfComments(metier.getNbrCommentsOfPost(post.getId()));
                    boolean likedFlag = postsLikedByUser.contains(post);
                    post.setLiked(likedFlag);
                }
	            for (Post post : postsLikedByUser) {
                    post.setNbrOfLikes(metier.getNbrLikesOfPost(post.getId()));
                    post.setNbrOfComments(metier.getNbrCommentsOfPost(post.getId()));
                    boolean likedFlag = postsLikedByUser.contains(post);
                    post.setLiked(likedFlag);
                }
	            userModel.setCategories(categories);
	            userModel.setPostsByLoggedUser(postsByLoggedUser);
	            userModel.setPostsLikedByLoggedUser(postsLikedByUser);
	            userModel.setNbrOfPostsByUser(nbrOfPosts);
	            userModel.setNbrOfLikes(nbrOfLikes);
	            request.setAttribute("userModel", userModel);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            }
        } else if(path.equals("/postDetails.do")) {
        	HttpSession session = request.getSession(false); // Get the session without creating a new one
       	 	if (session == null || session.getAttribute("id") == null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
            	Model userModel = new Model();
              	int loggedId = (int) session.getAttribute("id");
             	int postId =  Integer.parseInt(request.getParameter("id"));
             	ArrayList<Post> postsLikedByUser = metier.getPostsLikedByUser(loggedId);
             	ArrayList<Comment> postComments = metier.getCommentsByPost(postId);
             	Post post = metier.getPostById(postId);
             	post.setNbrOfLikes(metier.getNbrLikesOfPost(postId));
                post.setNbrOfComments(metier.getNbrCommentsOfPost(postId));
                
                boolean likedFlag = postsLikedByUser.contains(post);
                post.setLiked(likedFlag);
             	
                userModel.setPostComments(postComments);
             	userModel.setPost(post);
             	request.setAttribute("userModel", userModel);
                request.getRequestDispatcher("postDetails.jsp").forward(request, response);
            }   	    	
        } else if(path.equals("/deletePost.do")){
        	HttpSession session = request.getSession(false); 
       	 	if (session == null || session.getAttribute("id") == null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
            	int loggedId = (int) session.getAttribute("id");
            	int postId = Integer.parseInt(request.getParameter("id"));
            	if(loggedId==metier.getPostById(postId).getAuthor().getId()) {
            		metier.deletePost(postId);
            		response.sendRedirect("profile.do"); 
            	}else {
            		response.sendRedirect("home.do");
            	}
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    	response.setHeader("Expires", "0"); // Proxies.
    	String path = request.getServletPath(); 
    	  if(path.equals("/login.do")) {
    		HttpSession session = request.getSession();
        	String username = request.getParameter("username");
        	String password = request.getParameter("password");

        	boolean flag = metier.verifyLogin(username, password, session);
        	if(flag) {
        		Model userModel = new Model();
                int loggedId = (int) session.getAttribute("id");
                String loggedUsername = (String) session.getAttribute("username");
                String loggedPassword = (String) session.getAttribute("password");
                String loggedEmail = (String) session.getAttribute("email");
                userModel.setUser(metier.getUserByCredentials(loggedUsername, loggedPassword));
                ArrayList<Post> posts = metier.getAllPosts();
                ArrayList<Post> postsLikedByUser = metier.getPostsLikedByUser(userModel.getUser().getId());
                
                
                for (Post post : posts) {
                    post.setNbrOfLikes(metier.getNbrLikesOfPost(post.getId()));
                    post.setNbrOfComments(metier.getNbrCommentsOfPost(post.getId()));
                    boolean likedFlag = postsLikedByUser.contains(post);
                    post.setLiked(likedFlag);
                }
               
                userModel.setPosts(posts);
                userModel.setTrendingPosts(metier.mostLikes());
                
                request.setAttribute("userModel", userModel);
                request.getRequestDispatcher("home.jsp").forward(request, response);
        	} else {
        		response.sendRedirect("index.jsp");  
        	}
        } else if(path.equals("/signup.do")) {
        	String username = request.getParameter("username");
        	String email = request.getParameter("email");
        	String password = request.getParameter("password");
        	String passwordConfirmation = request.getParameter("passwordConfirmation");
        	if(password.equals(passwordConfirmation)) {
        		metier.saveUser(new User(username, email, password));
    		 	Model userModel = new Model();
    		 	userModel.setUser(metier.getUserByCredentials(username, password));
	    		request.setAttribute("userModel", userModel);
	    		request.getRequestDispatcher("index.jsp?msg=success").forward(request, response);
        	} else {
        		request.getRequestDispatcher("index.jsp?msg=passConfirmError").forward(request, response);  
        	}
        } else if ( path.equals("/like-post.do")) {
        	
        	request.getRequestDispatcher("login.jsp?msg=success").forward(request, response);
        } else if ( path.equals("/dislike-post.do")) {
        	metier.deleteLike(181);
        	request.getRequestDispatcher("login.jsp?msg=success").forward(request, response);
        }else if(path.equals("/savePost.do")) {
        	HttpSession session = request.getSession(false); // Get the session without creating a new one
       	 	if (session == null || session.getAttribute("id") == null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
       	 	} else {
       	 		String postTitle = request.getParameter("postTitle");
       	 		String postContent = request.getParameter("postContent");
       	 		int postCategorie = Integer.parseInt(request.getParameter("postCategorie"));
       	 		int loggedId = (int) session.getAttribute("id");
       	 		metier.savePost(new Post(postTitle,postContent,metier.getUserById(loggedId),metier.getCategorieById(postCategorie)));
       	 		response.sendRedirect("home.do"); 
       	 	}
        } else if (path.equals("/addComment.do")) {
        	HttpSession session = request.getSession(false); // Get the session without creating a new one
       	 	if (session == null || session.getAttribute("id") == null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
       	 	} else {
       	 		String commentContent = request.getParameter("commentContent");
       	 		int postId = Integer.parseInt(request.getParameter("postId"));
       	 		int loggedId = (int) session.getAttribute("id");
       	 		metier.saveComment(new Comment(commentContent, metier.getPostById(postId), metier.getUserById(loggedId)));
       	 		response.sendRedirect("postDetails.do?id="+postId); 
       	 	}
        }
    }
}