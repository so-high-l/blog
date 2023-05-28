package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import metier.*;


public class PostDaoImpl implements IPostDao{
//-------------------Post-----------------------
	@Override
	public Post savePost(Post p) {
		Connection connection = SingletonConnection.getConnection();
        java.sql.Date mySQLDate = new java.sql.Date(p.getCreatedAt().getTime());
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO POST (TITLE, CONTENT, AUTHOR, CREATEDAT, UPDATEDAT, CATEGORIE) VALUES(?, ?, ?, ?, ?, ?)");
			ps.setString(1, p.getTitle());
			ps.setString(2, p.getContent());
			ps.setInt(3, p.getAuthor().getId());
			ps.setDate(4, mySQLDate);
			ps.setDate(5, mySQLDate);
			ps.setInt(6, p.getCategorie().getId());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM POST");
			ResultSet rs = ps2.executeQuery(); 
			if(rs.next()) {
				p.setId(rs.getInt("MAXID"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@Override
	public Post getPostById(int id) {
		Connection connection = SingletonConnection.getConnection();
		Post p = new Post();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM  post WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p.setId(rs.getInt("id"));
				p.setTitle(rs.getString("title"));
				p.setContent(rs.getString("content"));
				p.setAuthor(getUserById(rs.getInt("author")));
	            p.setCreatedAt(rs.getDate("createdAt"));
				p.setUpdatedAt(rs.getDate("updatedAt"));
				p.setCategorie(getCategorieById(rs.getInt("categorie")));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@Override
	public Post updatePost(int id, Post p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE post SET title=?, content=?, categorie=? WHERE id=?");
			ps.setString(1,p.getTitle());
			ps.setString(2, p.getContent());
			ps.setInt(3, p.getCategorie().getId());
			ps.setInt(4, id);
			//System.out.println(p);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return getPostById(id);
	}
	@Override
	public void deletePost(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM post WHERE id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
//-------------------User-----------------------
	@Override
	public User saveUser(User user) {
		Connection connection = SingletonConnection.getConnection();	
        java.sql.Date mySQLDate = new java.sql.Date(user.getCreatedAt().getTime());
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO USER (USERNAME, EMAIL, PASSWORD, CREATEDAT, UPDATEDAT) VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setDate(4, mySQLDate);
			ps.setDate(5, mySQLDate);
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM USER");
			ResultSet rs = ps2.executeQuery(); 
			if(rs.next()) {
				user.setId(rs.getInt("MAXID"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public User getUserById(int id) {
		Connection connection = SingletonConnection.getConnection();
		User author = new User();		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM  USER WHERE ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				author.setId(rs.getInt("id"));
				author.setUsername(rs.getString("username"));
				author.setEmail(rs.getString("email"));
				author.setPassword(rs.getString("password"));
				author.setCreatedAt(rs.getDate("createdAt"));
				author.setUpdatedAt(rs.getDate("updatedAt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return author;
	}
	@Override
	public User updateUser(int id, User u) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE user SET username=?, email=?, password=? WHERE id=?");
			ps.setString(1,u.getUsername());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	@Override
	public void deleteUser(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM user WHERE id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
//---------------------Comment----------------
	@Override
	public Comment saveComment(Comment comment) {
		Connection connection = SingletonConnection.getConnection();	
		java.sql.Date mySQLDate = new java.sql.Date(comment.getCreatedAt().getTime());	
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO comment (content, author, post, CREATEDAT, UPDATEDAT) VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, comment.getContent());
			ps.setInt(2, (int) comment.getAuthor().getId());
			ps.setInt(3, comment.getPost().getId());
			ps.setDate(4, mySQLDate);
			ps.setDate(5, mySQLDate);
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM comment");
			ResultSet rs = ps2.executeQuery(); 
			if(rs.next()) {
				comment.setId(rs.getInt("MAXID"));
			}
			ps.close();
			ps2.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comment;
	}
	@Override
	public Comment getCommentById(int id) {
		Connection connection = SingletonConnection.getConnection();
		Comment comment = new Comment(); 		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM  comment WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				comment.setId(rs.getInt("id"));
				comment.setContent(rs.getString("Content"));
				comment.setAuthor(getUserById(rs.getInt("author")));
				comment.setPost(getPostById(rs.getInt("post")));
				comment.setCreatedAt(rs.getDate("createdAt"));
				comment.setUpdatedAt(rs.getDate("updatedAt"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment;
	}
	@Override
	public Comment updateComment(int id, Comment comment) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE comment SET content=?, author=?, post=? WHERE id=?");
			ps.setString(1, comment.getContent());
			ps.setInt(2, (int) comment.getAuthor().getId());
			ps.setInt(3, (int) comment.getPost().getId());
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return getCommentById(id);
	}
	@Override
	public void deleteComment(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM comment WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
//---------------------Categorie--------------
	@Override
	public Categorie saveCategorie(Categorie categorie) {
		Connection connection = SingletonConnection.getConnection();		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO CATEGORIE (NAME, DESCRIPTION) VALUES(?, ?)");
			ps.setString(1, categorie.getName());
			ps.setString(2, categorie.getDescription());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM CATEGORIE");
			ResultSet rs = ps2.executeQuery(); 
			if(rs.next()) {
				categorie.setId(rs.getInt("MAXID"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorie;
	}
	@Override
	public Categorie getCategorieById(int id) {
		Connection connection = SingletonConnection.getConnection();
		Categorie categorie = new Categorie();		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM  categorie WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				categorie.setId(rs.getInt("id"));
				categorie.setName(rs.getString("name"));
				categorie.setDescription(rs.getString("description"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categorie;
	}
	@Override
	public Categorie updateCategorie(int id, Categorie categorie) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE categorie SET name=?, description=? WHERE id=?");
			ps.setString(1, categorie.getName());
			ps.setString(2, categorie.getDescription());
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return getCategorieById(id);
	}
	@Override
	public void deleteCategorie(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM categorie WHERE id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
//------------------------Like---------------------
	@Override
	public Like saveLike(Like like) {
		Connection connection = SingletonConnection.getConnection();
		java.sql.Date mySQLDate = new java.sql.Date(like.getCreatedAt().getTime());	
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO likes (user, post, createdat) VALUES(?, ?, ?)");
			ps.setInt(1, like.getUser().getId());
			ps.setInt(2, like.getPost().getId());
			ps.setDate(3, mySQLDate);
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAXID FROM likes");
			ResultSet rs = ps2.executeQuery(); 
			if(rs.next()) {
				like.setId(rs.getInt("MAXID"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return like;
	}
	@Override
	public void deleteLike(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM likes WHERE id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
//------------------------Others-------------------
	@Override
	public ArrayList<Post> getAllPosts() {
	    Connection connection = SingletonConnection.getConnection();
	    ArrayList<Post> posts = new ArrayList<>();
	    try {
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM POST");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Post post = new Post();
	            post.setId(rs.getInt("id"));
	            post.setTitle(rs.getString("title"));
	            post.setContent(rs.getString("content"));
	            post.setAuthor(getUserById(rs.getInt("author")));
	            post.setCategorie(getCategorieById(rs.getInt("categorie")));
	            post.setCreatedAt(rs.getDate("createdAt"));
				post.setUpdatedAt(rs.getDate("updatedAt"));
	            posts.add(post);
	        }
	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return posts;
	}
	@Override
	public ArrayList<Categorie> getAllCategories() {
	    Connection connection = SingletonConnection.getConnection();
	    ArrayList<Categorie> categories = new ArrayList<>();
	    try {
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM CATEGORIE");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	Categorie categorie = new Categorie();
	        	categorie.setId(rs.getInt("id"));
	        	categorie.setName(rs.getString("name"));
	        	categorie.setDescription(rs.getString("description"));
				categories.add(categorie);
	        }
	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return categories;
	}
	@Override
	public ArrayList<Post> getPostsByUser(int id){
		Connection connection = SingletonConnection.getConnection();
		ArrayList<Post> posts = new ArrayList<>();
	    try {
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM post WHERE author = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	Post post = new Post();
	            post.setId(rs.getInt("id"));
	            post.setTitle(rs.getString("title"));
	            post.setContent(rs.getString("content"));
	            post.setAuthor(getUserById(rs.getInt("author")));
	            post.setCreatedAt(rs.getDate("createdAt"));
				post.setUpdatedAt(rs.getDate("updatedAt"));
				post.setCategorie(getCategorieById(rs.getInt("categorie")));
	            posts.add(post);
	        }
	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return posts;
	}
	@Override
	public ArrayList<Post> getPostsByCategorie(int id){
		Connection connection = SingletonConnection.getConnection();
		ArrayList<Post> posts = new ArrayList<>();
	    try {
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM post WHERE categorie = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	Post post = new Post();
	            post.setId(rs.getInt("id"));
	            post.setTitle(rs.getString("title"));
	            post.setContent(rs.getString("content"));
	            post.setAuthor(getUserById(rs.getInt("author")));
	            post.setCreatedAt(rs.getDate("createdAt"));
				post.setUpdatedAt(rs.getDate("updatedAt"));
				post.setCategorie(getCategorieById(rs.getInt("categorie")));
	            posts.add(post);
	        }
	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return posts;
	}
	@Override
	public ArrayList<Post> getPostsByMc(String mc) {
		Connection connection = SingletonConnection.getConnection();
	    ArrayList<Post> posts = new ArrayList<>();
	    try {
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM POST WHERE title like ?");
	        ps.setString(1, mc);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Post post = new Post();
	            post.setId(rs.getInt("id"));
	            post.setTitle(rs.getString("title"));
	            post.setContent(rs.getString("content"));
	            post.setAuthor(getUserById(rs.getInt("author")));
	            post.setCreatedAt(rs.getDate("createdAt"));
				post.setUpdatedAt(rs.getDate("updatedAt"));
				post.setCategorie(getCategorieById(rs.getInt("categorie")));
	            posts.add(post);
	        }
	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return posts;
	}
	@Override
	public ArrayList<Comment> getCommentsByPost(int id) {
		Connection connection = SingletonConnection.getConnection();
		ArrayList<Comment> comments = new ArrayList<>();
	    try {
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM comment WHERE post = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Comment comment = new Comment();
	            comment.setId(rs.getInt("id"));
	            comment.setContent(rs.getString("content"));
	            comment.setAuthor(getUserById(rs.getInt("author")));
	            comment.setPost(getPostById(rs.getInt("post")));
	            comment.setCreatedAt(rs.getDate("createdAt"));
				comment.setUpdatedAt(rs.getDate("updatedAt"));
	            comments.add(comment);
	        }
	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return comments;
	}
	@Override
	public ArrayList<Comment> getCommentsByUser(int id) {
		Connection connection = SingletonConnection.getConnection();
		ArrayList<Comment> comments = new ArrayList<>();
	    try {
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM comment WHERE author = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Comment comment = new Comment();
	            comment.setId(rs.getInt("id"));
	            comment.setContent(rs.getString("content"));
	            comment.setAuthor(getUserById(rs.getInt("author")));
	            comment.setPost(getPostById(rs.getInt("post")));
	            comment.setCreatedAt(rs.getDate("createdAt"));
				comment.setUpdatedAt(rs.getDate("updatedAt"));
	            comments.add(comment);
	        }
	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return comments;
	}
	@Override
	public boolean verifyLogin(String username, String password, HttpSession session) {
		Connection connection = SingletonConnection.getConnection();
		boolean flag = false;		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM  user WHERE username = ? && password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				session.setAttribute("id", rs.getInt("id"));
				session.setAttribute("username", rs.getString("username"));
				session.setAttribute("email", rs.getString("email"));
				session.setAttribute("password", rs.getString("password"));
				flag = true;
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public User getUserByCredentials(String username, String password) {
		Connection connection = SingletonConnection.getConnection();	
		User user = new User();		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM  user WHERE username = ? && password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setCreatedAt(rs.getDate("createdAt"));
				user.setUpdatedAt(rs.getDate("updatedAt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public ArrayList<Post> mostLikes(){
		Connection connection = SingletonConnection.getConnection();
		ArrayList<Post> posts = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT *,COUNT(l.post) AS like_count FROM post JOIN likes l ON post.id = l.post GROUP BY post.id ORDER BY like_count DESC LIMIT 3");
			ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Post post = new Post();
	            post.setId(rs.getInt("id"));
	            post.setTitle(rs.getString("title"));
	            post.setContent(rs.getString("content"));
	            post.setAuthor(getUserById(rs.getInt("author")));
	            post.setCategorie(getCategorieById(rs.getInt("categorie")));
	            post.setCreatedAt(rs.getDate("createdAt"));
				post.setUpdatedAt(rs.getDate("updatedAt"));
	            posts.add(post);
	        }
	        rs.close();
	        ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posts;
	}
	public ArrayList<Like> getLikesByPost(int id) {
	    Connection connection = SingletonConnection.getConnection();
	    ArrayList<Like> likes = new ArrayList<>();
	    try {
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM likes WHERE post = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            User user = getUserById(rs.getInt("user"));
	            Like like = new Like(user,this.getPostById(id));
	            like.setId(rs.getInt("id"));
	            likes.add(like);
	        }
	        rs.close();
	        ps.close();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return likes;
	}
	public int getNbrLikesOfPost(int id) {
	    Connection connection = SingletonConnection.getConnection();
	    int count = 0;
	    try {
	    	PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM likes WHERE post = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next())
	           count = rs.getInt(1);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	public int getNbrCommentsOfPost(int id) {
		Connection connection = SingletonConnection.getConnection();
	    int count = 0;
	    try {
	    	PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM comment WHERE post = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next())
	           count = rs.getInt(1);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	public ArrayList<Post> getPostsLikedByUser(int id){
		Connection connection = SingletonConnection.getConnection();
		ArrayList<Post> posts = new ArrayList<Post>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * From likes WHERE user = ?");
			ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            posts.add(getPostById(rs.getInt("post")));
	        }
	        rs.close();
	        ps.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return posts;
	}
	public int getLikeByUserAndPost(User user,Post post) {
		Connection connection = SingletonConnection.getConnection();
		int id=-1;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * From likes WHERE user = ? AND post= ?");
			ps.setInt(1, user.getId());
			ps.setInt(2, post.getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id=rs.getInt("id");
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public ArrayList<Post> getPosts(int limit) {
		Connection connection = SingletonConnection.getConnection();
	    ArrayList<Post> posts = new ArrayList<>();
	    try {
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM POST LIMIT ?");
	        ps.setInt(1, limit);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Post post = new Post();
	            post.setId(rs.getInt("id"));
	            post.setTitle(rs.getString("title"));
	            post.setContent(rs.getString("content"));
	            post.setAuthor(getUserById(rs.getInt("author")));
	            post.setCategorie(getCategorieById(rs.getInt("categorie")));
	            post.setCreatedAt(rs.getDate("createdAt"));
				post.setUpdatedAt(rs.getDate("updatedAt"));
	            posts.add(post);
	        }
	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return posts;
	}
}
