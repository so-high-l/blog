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
    <link href=" <c:url value='/assets/postDetails.css' /> " rel="stylesheet">
    <script
      src="https://kit.fontawesome.com/08e63ab518.js"
      crossorigin="anonymous"
    ></script>
  </head>
<body>
       <div class="header">
      <div class="navigation">
        <ul>
          <a href="index.do" >Home</a>
          <a href="profile.do"  >Profile</a>
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
      <div class="content">
        <div class="popularPostsContainer">
          <h2 class="title">Post by ${ userModel.getPost().getAuthor().getUsername() }</h2>
          <div class="popularPosts">
            <div class="popular--post">
              <div class="popular--post--side">
                <i class="fa-regular fa-heart"></i>
                <p class="popular--post--likes"> ${userModel.getPost().getNbrOfLikes()}  Likes</p>
              </div>
              <div class="popular--post--main">
                <div class="popular--post--topsection">
                  <a href="" class="popular--post--categorie">/${userModel.getPost().getCategorie().getName()}</a>
                  
                  </p>
                  <p class="popular--post--date">${userModel.getPost().getCreatedAt()}</p>
                </div>
                <div class="popular--post--midsection">
                  <a class="popular--post--title" href="">
                    ${userModel.getPost().getTitle()}
                  </a>
                  <p class="popular--post--subtitle">
                    ${userModel.getPost().getContent()}
                  </p>
                </div>
                <div class="popular--post--botsection">
                  <a href="" class="popular--post--comment--link"
                    ><i class="fa-light fa-comments"></i>
                    <p class="popular--post--nbcomments">${userModel.getPost().getNbrOfComments()} Comments</p></a
                  >
                </div>
                <div class="post--comment--section">
                <c:forEach items="${userModel.getPostComments() }" var="comment">
                <div class="comment--line">
                    <a class="popular--post--user" href="">${ comment.getAuthor().getUsername() }</a>
                    <p>${ comment.getContent() }</p>
                  </div>
                </c:forEach>
                  

                  
                  <form action="addComment.do" method="POST">
                  <div class="popular--post--commentsection">
	                  
	                    <input  name="commentContent" placeholder="Add comment" type="text">
	                    <input name="postId" type="hidden" value="${userModel.getPost().getId()}" />
	                    <button class="postComment--btn">Save</button>
	                  
                  </div>
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
