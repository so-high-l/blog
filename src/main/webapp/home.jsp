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
    <link href=" <c:url value='/assets/home.css' /> " rel="stylesheet">
	<!-- jQuery CDN -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
  </head>

  <body>
    <div class="header">
      <div class="navigation">
        <ul>
          <a href="index.do" class="active">Home</a>
          <a href="profile.do" >Profile</a>
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
            <i class="fa fa-city"></i>
            <p class="sidebar--link--text">Home</p></a
          >
          <a href="" class="sidebar--link--container">
            <i class="fa fa-fire"></i>
            <p>Popular</p></a
          >
          <br />
          <p class="sidebar--section--title">TOPICS</p>
          <a href="" class="sidebar--link--container">
            <i class="fa fa-code"></i>
            <p>Programming</p></a
          >
          <a href="" class="sidebar--link--container">
            <i class="fa fa-gamepad"></i>
            <p class="sidebar--link--text">Gaming</p></a
          >
          <a href="" class="sidebar--link--container">
            <i class="fa fa-futbol"></i>
            <p>Sports</p></a
          >
          <a href="" class="sidebar--link--container">
            <i class="fa fa-futbol"></i>
            <p>Football</p></a
          >
          <a href="" class="sidebar--link--container">
            <i class="fa fa-school"></i>
            <p>Studies</p></a
          >
          <a href="" class="sidebar--link--container">
            <i class="fa fa-caret-down"></i>
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
        <div class="trendingPostsContainer">
          <h2 class="title">Trending today</h2>
          <div class="trendingPosts">
          <c:forEach items="${userModel.getTrendingPosts()}" var="trendingPost">
            <div class="trending--post">
              <p class="trending--post--title">
                <a href="./postDetails.do?id=${trendingPost.getId()}">${trendingPost.getTitle()}</a>
              </p>
              <p class="trending--post--subtitle">
                ${trendingPost.getContent()}
              </p>

              <p class="trending--post--categorie">${trendingPost.getCategorie().getName()}</p>
            </div>
           </c:forEach>
            
        </div>
        <div class="popularPostsContainer">
          <h2 class="title">Popular posts</h2>
          <div class="popularPosts">
          <c:forEach items="${userModel.getPosts()}" var="post">
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
                    Posted by <a href="">${post.getAuthor().getUsername()} </a>
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
      <div class="sidebar rightsidebar"></div>
    </div>
	<script src="https://kit.fontawesome.com/08e63ab518.js" crossorigin="anonymous"></script>
    <script src="./assets/home.js"></script>
  </body>
</html>
    