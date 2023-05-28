const body = document.querySelector("body");
const darkModeBtn = document.querySelector(".theme-switch");

darkModeBtn.addEventListener("click", () => {
  body.classList.toggle("light-theme");
});


const tab1Button = document.querySelector("#tab1Button");
const tab2Button = document.querySelector("#tab2Button");
const tab3Button = document.querySelector("#tab3Button");
const tab4Button = document.querySelector("#tab4Button");
const tabs = document.querySelectorAll(".tab");

tab1Button.addEventListener("click", ()=>{
  tabs.forEach(tab=>{
    tab.style.display = "none";

  })
  tabs[0].style.display = "grid";
  tabTitles.forEach(tabTitle =>{
    tabTitle.classList.remove("active");
  })
  tabTitles[0].classList.add("active");
})


tab2Button.addEventListener("click", ()=>{
  tabs.forEach(tab=>{
    tab.style.display = "none";

  })
  tabs[1].style.display = "block";
  tabTitles.forEach(tabTitle =>{
    tabTitle.classList.remove("active");
  })
  tabTitles[1].classList.add("active");
})

tab3Button.addEventListener("click", ()=>{
  tabs.forEach(tab=>{
    tab.style.display = "none";

  })
  tabs[2].style.display = "block";
  tabTitles.forEach(tabTitle =>{
    tabTitle.classList.remove("active");
  })
  tabTitles[2].classList.add("active");
})
tab4Button.addEventListener("click", ()=>{
  tabs.forEach(tab=>{
    tab.style.display = "none";

  })
  tabs[3].style.display = "block";
  tabTitles.forEach(tabTitle =>{
    tabTitle.classList.remove("active");
  })
  tabTitles[3].classList.add("active");
})



const tabTitles = document.querySelectorAll(".tabTitle");
