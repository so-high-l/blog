<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ensa Blog</title>	
    <link href=" <c:url value='/assets/profile.css' /> " rel="stylesheet">
    <script
      src="https://kit.fontawesome.com/08e63ab518.js"
      crossorigin="anonymous"
    ></script>
    <style>
    
    </style>
  </head>

  <body>
       <div class="header">
      <div class="navigation">
        <ul>
          <a href="index.do" >Home</a>
          <a href="profile.do" class="active">Profile</a>
          <a href="#" target="">About</a>
          <a href="#" target="">Contact</a>
        </ul>
      </div>
      <div class="top--right">
        <div class="theme-switch">
          <div class="switch"></div>
        </div>
        <div>
          <a class="log--out" href="logout.do">LOG OUT</a>
        </div>
      </div>
    </div>


    <div class="main">
      <div class="sidebar leftsidebar">
        <div class="leftsidebar--topsection">
          <p class="sidebar--section--title">FEEDS</p>
          <a href="" class="sidebar--link--container">
            <i class="fa-regular fa-fire"></i>
            <p class="sidebar--link--text">Home</p></a
          >
          <a href="" class="sidebar--link--container">
            <i class="fa-regular fa-fire"></i>
            <p>Popular</p></a
          >
          <br />
          <p class="sidebar--section--title">TOPICS</p>
          <a href="" class="sidebar--link--container">
            <i class="fa-regular fa-fire"></i>
            <p>Programming</p></a
          >
          <a href="" class="sidebar--link--container">
            <i class="fa-regular fa-fire"></i>
            <p class="sidebar--link--text">Gaming</p></a
          >
          <a href="" class="sidebar--link--container">
            <i class="fa-regular fa-fire"></i>
            <p>Sports</p></a
          >
          <a href="" class="sidebar--link--container">
            <i class="fa-regular fa-fire"></i>
            <p>Football</p></a
          >
          <a href="" class="sidebar--link--container">
            <i class="fa-regular fa-fire"></i>
            <p>Studies</p></a
          >
          <a href="" class="sidebar--link--container">
            <i class="fa-regular fa-fire"></i>
            <p>More topics</p></a
          >
        </div>
        <div class="leftsidebar--botsection">
          <p>
            Lorem ipsum dolor sit amet, consectetur adipisicing elit.
            Consequuntur, vitae.
          </p>
          <button class="leftsidebar--button">Join ENSABlog</button>
         
        </div>
      </div>
      <div class="content1">
        <div class="header__wrapper">
          <div class="background-container"></div>
          <div class="cols__container">
            <div class="left__col">
              <div class="img__container">
                <img src="img/user.jpeg" alt="User Image" />
                <span></span>
              </div>
              <h2> <%= session.getAttribute("username") %></h2>
              <p>Front End</p>
              <p><%= session.getAttribute("email") %></p>

              <ul class="about">
                <li><span>${userModel.getNbrOfPostsByUser()}</span>Posts</li>
                <li><span>${userModel.getNbrOfLikes()}</span>Likes</li>
              </ul>
              <div class="content"></div>
            </div>
            <div class="right__col">
              <nav>
                <ul>
                  <li class="tabTitle active">
                    <a href="#" id="tab1Button">Add Post</a>
                  </li>
                  <li class="tabTitle">
                    <a href="#" id="tab2Button">My Posts</a>
                  </li>
                  <li class="tabTitle">
                    <a href="#" id="tab3Button">Liked Posts</a>
                  </li>
                  <li class="tabTitle">
                    <a href="#" id="tab4Button">Edit profile</a>
                  </li>
                </ul>
              </nav>
              <div class="tab tab1">
                <p>Create a new post</p>
                <form action="savePost.do" method="POST">
                  <fieldset>
                    <div class="profile_input">
                      <tr class="create--post--row">
                        <td><label >Post title</label></td>
                        <td><input type="text" name="postTitle" required /></td>
                      </tr>
                      <tr class="create--post--row">
                        <td><label for="old password">Post Content</label></td>
                        <br />
                        <td>
                          <textarea
                            class="create--post--content"
                            required
                            rows="7"
                            cols="60"
                            id="old_password"
                            name="postContent"
                          ></textarea>
                        </td>
                      </tr>
                      <tr class="create--post--row">
                        <br />
                        <td><label for="new password">Categorie</label></td>
                        <br />
                        <td>
                          <select class="create--post--option" name="postCategorie" id="">
                            <option class="create--post--select" >
                              Select Your categorie
                            </option>
                            <c:forEach items="${userModel.getCategories() }" var="categorie">
                            	<option class="create--post--select" value="${categorie.getId()}">
                              	${categorie.getName()}
                            	</option>
                            </c:forEach>
                          </select>
                        </td>
                      </tr>
                    </div>
                    <button type="submit" class="profile--post--save">
                      Save
                    </button>
                  </fieldset>
                </form>
              </div>
              <div class="tab tab2 photos">
                <div>
                  <div class="row">
                   <c:forEach items="${userModel.getPostsByLoggedUser()}" var="post">
		            <div class="popular--post">
		              <div class="popular--post--side">
			             <c:choose> 
						  <c:when test="${post.isLiked()}"> 
			               	<span class="alreadyLiked" ><i class="fa fa-heart dislikePostBtn"></i></span> 
						  </c:when> 
						  <c:otherwise> 
			           		<span class="notLiked"><i class="fa fa-heart likePostBtn"></i></span> 
						  </c:otherwise> 
					  	</c:choose> 
		                <p class="popular--post--likes">${post.getNbrOfLikes()} Likes</p>
		              </div>
		              <div class="popular--post--main">
		                <div class="popular--post--topsection">
		                  <a href="" class="popular--post--categorie">/${post.getCategorie().getName()}</a>
		                  <p class="popular--post--author">
		                    
		                    <input type="hidden" value="${post.getId()}" /> 
		                  </p>
		                  <p class="popular--post--date">${post.getCreatedAt()}</p>
		                </div>
		                <div class="popular--post--midsection">
		                  <a class="popular--post--title" href="postDetails.do?id=${ post.getId()}">
		                    ${post.getTitle()}
		                  </a>
		                  <p class="popular--post--subtitle">
		                    ${post.getContent()}
		                  </p>
		                </div>
		                <div class="popular--post--EditSection">
                          <a type="button" class="popular--post--edit" href="editPost.do?id=${ post.getId()}">
                            Edit Post
                          </a>
                          <a type="button" class="popular--post--delete" href="deletePost.do?id=${ post.getId()}">
                            Delete
                          </a>
                        </div>
		                <div class="popular--post--botsection">
		                  <a href="postDetails.do?id=${ post.getId()}" class="popular--post--comment--link"
		                    ><i class="fa fa-comment"></i>
		                    <p class="popular--post--nbcomments">${post.getNbrOfComments()} Comments</p></a
		                  >
		                </div>
		              </div>
		            </div>
		          </c:forEach>
                   
                  
                    
                  </div>
                </div>
              </div>
              <div class="tab tab3 likedPosts">
				  <div class="popularPostsContainer">
				    <div class="popularPosts">
				    	<c:forEach items="${userModel.getPostsLikedByLoggedUser()}" var="post">
				    		<div class="popular--post">
                        <div class="popular--post--side">
                          <c:choose>
                            <c:when test="${post.isLiked()}">
                              <span class="alreadyLiked"
                                ><i class="fa fa-heart dislikePostBtn"></i
                              ></span>
                            </c:when>
                            <c:otherwise>
                              <span class="notLiked"
                                ><i class="fa fa-heart likePostBtn"></i
                              ></span>
                            </c:otherwise>
                          </c:choose>
                          <p class="popular--post--likes">
                            ${post.getNbrOfLikes()} Likes
                          </p>
                        </div>
                        <div class="popular--post--main">
                          <div class="popular--post--topsection">
                            <a href="" class="popular--post--categorie"
                              >/${post.getCategorie().getName()}</a
                            >
                            <p class="popular--post--author">
                              <input type="hidden" value="${post.getId()}" />
                            </p>
                            <p class="popular--post--date">
                              ${post.getCreatedAt()}
                            </p>
                          </div>
                          <div class="popular--post--midsection">
                            <a
                              class="popular--post--title"
                              href="postDetails.do?id=${ post.getId()}"
                            >
                              ${post.getTitle()}
                            </a>
                            <p class="popular--post--subtitle">
                              ${post.getContent()}
                            </p>
                          </div>
                          <div class="popular--post--botsection">
                            <a
                              href="postDetails.do?id=${ post.getId()}"
                              class="popular--post--comment--link"
                              ><i class="fa fa-comment"></i>
                              <p class="popular--post--nbcomments">
                                ${post.getNbrOfComments()} Comments
                              </p></a
                            >
                          </div>
                        </div>
                      </div>
				    	</c:forEach>
				    </div>
				  </div>
				</div>
              <div class="tab tab4">
                <form action="updateProfile.do" method="POST">
                  <fieldset>
                    <div class="profile_input">
                      <tr>
                        <td><label for="User_name">Username</label></td>
                        <td>
                          <input
                            value="<%= session.getAttribute("username") %>"
                            type="text"
                          />
                        </td>
                      </tr>
                      <tr>
                        <td><label for="old password">Old Password</label></td>
                        <td><input id="old_password " type="password" /></td>
                      </tr>
                      <tr>
                        <td><label for="new password">New Password</label></td>
                        <td><input id="new_password " type="password" /></td>
                      </tr>
                      <tr>
                        <td><label for="email">Email</label></td>
                        <td>
                          <input
                            id="email"
                            type="email"
                            value="<%= session.getAttribute("email") %>"
                          />
                        </td>
                      </tr>
                    </div>
                    <button type="submit" class="profile--post--save">
                      Save
                    </button>
                  </fieldset>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
	<script src="https://kit.fontawesome.com/08e63ab518.js" crossorigin="anonymous"></script>
    <script src="./assets/script.js"></script>
  </body>
</html>
