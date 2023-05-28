const body = document.querySelector("body");
const darkModeBtn = document.querySelector(".theme-switch");
const likePostBtns = document.querySelectorAll(".likePostBtn");
const dislikePostBtns = document.querySelectorAll(".dislikePostBtn");

darkModeBtn.addEventListener("click", () => {
  body.classList.toggle("light-theme");
});

dislikePostBtns.forEach(btn => {
  btn.addEventListener("click", () => {
     $.ajax({
      url: 'like-post.do',  // Replace with the URL of the server-side action
      method: 'POST',  // Replace with the appropriate HTTP method
      data: { },  // Pass the postId to the server-side action
      success: function(response) {
        // Handle the success response, if needed
      },
      error: function(xhr, status, error) {
        // Handle the error response, if needed
      }
    });
  });
});


likePostBtns.forEach(btn => {
  btn.addEventListener("click", () => {
    console.log("clicked");
  });
});
