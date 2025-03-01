/*password hide show js start here */
var headerr = document.querySelector(".header");
var logodiv = document.querySelector(".logoDiv");
var navList = document.querySelector(".navList");
// let ChecBalStaDiv = document.querySelector(".ChecBalStaDiv");
// let checBalCard1 = document.querySelector("#checBalCard1");
// let checBalCard2 = document.querySelector("#checBalCard2");
// let checBalCard3 = document.querySelector("#checBalCard3");

var flag = 0;

function k() {
  let passwordInput11 = document.querySelector(".passwordInput1");
  let eye = document.querySelector(".eyeIconDivi");

  if (flag == 0) {
    eye.classList.add("fa-eye");
    passwordInput11.setAttribute("type", "text");
    console.log(0);
    flag = 1;
  } else {
    eye.classList.remove("fa-eye");
    passwordInput11.setAttribute("type", "password");
    console.log(1);
    flag = 0;
  }
}

/*password hide show js end here */

/*password refresh system js start */

var flag = true;
function refreshPassword() {
  if (flag == true) {
    var re = "720";
    refresh.style.transform = `rotate(${re}deg)`;
    flag = true;
    location.reload(); // Refresh the page
  }
}

var refresh = document.querySelector(".refreshDiv");

// refresh.addEventListener("click", refreshPassword);

// capture code process goes here .....End.......

/* floating login and profile div script ... */

var formStatus = 1;

const openSignDivForm = () => {
  let userImg = document.querySelector(".userImg");
  let signInDiv = document.querySelector(".profileSignDiv");


  if (formStatus == 1) {
    signInDiv.style.display = "flex";
    formStatus = 0;
  } else {
    signInDiv.style.display = "none";
    formStatus = 1;
  }
};

let profileImg = document.querySelector(".profileImg");

profileImg.addEventListener("click", openSignDivForm);

window.addEventListener("load", function () {
  let signInDiv = document.querySelector(".profileSignDiv");
  signInDiv.style.display = "none";
  formStatus = 1;
});






// function kris() {
//   console.log("hi clicked ");

//   gsap.from(".header", {
//     scale: 0,
//     y: -30,
//     duration: 0.5,
//     delay: 0.5,
//   });
// }
// kris();

// ..................................................................................

function hideAlert() {
  let alert = document.querySelector(".alertdiv");
  setTimeout(function () {
    alert.style.display = "flex";
  }, 3000);
  setTimeout(function () {
    alert.style.display = "none";
  }, 20000);
}

function verify() {
  let alertt = document.querySelector(".messagee");
  setTimeout(function () {
    alertt.style.display = "none";
  }, 5000);
}

function onClick(e) {
  e.preventDefault();
  grecaptcha.enterprise.ready(async () => {
    const token = await grecaptcha.enterprise.execute(
      "6LeJu3gqAAAAAMOIhkOf4eaHa4EsEyEziN4oRjnr",
      { action: "LOGIN" }
    );
  });
}

// for customer support page js for slide side ..................................

function showChatBot() {
  let chatDiv = document.querySelector(".chatDiv");
  let container = document.querySelector(".customerSupportInner");
  let chatInner = document.querySelector(".chatInner");

  chatInner.style.display = "none";
  chatDiv.style.display = "flex";
  console.log("click");
}


var listOpenerflag = true

function navListOpener(){
  if(listOpenerflag){
    navList.style.right='0%';
    listOpenerflag = false;
  }
  else{
    navList.style.right='-100%';
    listOpenerflag = true;
  }

}
var listOpener = document.querySelector(".listOpener");

listOpener.addEventListener( 'click', navListOpener  )






