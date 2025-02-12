/**
 * 
 */

/*password hide show js start here */

var flag=0;

function k(){
	
      let passwordInput11  =document.querySelector(".passwordInput1");
      let eye=document.querySelector(".eyeIconDivi");
	  
	if(flag == 0){
		eye.classList.add("fa-eye");
		passwordInput11.setAttribute("type", "text");
		console.log(0);
		flag=1;
	}
	else{
		eye.classList.remove("fa-eye");
		passwordInput11.setAttribute("type", "password");
		console.log(1);
		flag =0;
	}
}

/*password hide show js end here */


/*password refresh system js start */

var refresh = document.querySelector(".refreshDiv");

refresh.addEventListener("click" , refreshPassword);

function refreshPassword(){
	var flag =true;
	if(flag == true){
		var re = "720";
		    refresh.style.transform =`rotate(${re}deg)`;
			flag=true;
		    location.reload(); // Refresh the page
	}
	
}




// capture code process goes here .....End.......



/* floating login and profile div script ... */


var formStatus = 1;
const openSignDivForm=()=>{
	
	let userImg = document.querySelector(".userImg");
	let signInDiv =document.querySelector(".profileSignDiv");
	
	if( formStatus == 1){
		signInDiv.style.display="flex";
		formStatus = 0;
	}
	else{
		signInDiv.style.display="none";
	    formStatus = 1;
	}
}
window.addEventListener("load",function(){
	let signInDiv =document.querySelector(".profileSignDiv");
	signInDiv.style.display="none";
	formStatus = 1;
})


let ChecBalStaDiv =document.querySelector(".ChecBalStaDiv");
let checBalCard1 =document.querySelector("#checBalCard1");
let checBalCard2 =document.querySelector("#checBalCard2");
let checBalCard3 =document.querySelector("#checBalCard3");

 ChecBalStaDiv.addEventListener("mouseover",function(){
		
	   checBalCard1.style.transform="scaleX(20px)";
	   checBalCard2.style.transform="translateX(-60px) rotateY(30deg)";
	   checBalCard3.style.transform="translateX(60px) rotateY(-30deg)";
})
 ChecBalStaDiv.addEventListener("mouseleave",function(){
		
	   checBalCard1.style.transform="none";
	   checBalCard2.style.transform="";
	   checBalCard3.style.transform="";
})



var headerr = document.querySelector(".header");
var logodiv = document.querySelector(".logoDiv");
var navList = document.querySelector(".navList");






function kris(){
	
	console.log("hi clicked ")
	
	gsap.from(".header",{
		scale:0,
		y:-30,
		duration:0.5,
		delay:0.5
	})

}
kris();



// ..................................................................................


function hideAlert() {
	let alert = document.querySelector('.alertdiv');
	setTimeout(function() {
			alert.style.display = 'flex';
	}, 3000);
	 setTimeout(function() {
		alert.style.display = 'none';
 }, 20000);  
}


function verify() {
	let alertt = document.querySelector('.messagee');
	setTimeout(function() {
			alertt.style.display = 'none';
	}, 5000); 
}



  function onClick(e) {
    e.preventDefault();
    grecaptcha.enterprise.ready(async () => {
      const token = await grecaptcha.enterprise.execute('6LeJu3gqAAAAAMOIhkOf4eaHa4EsEyEziN4oRjnr', {action: 'LOGIN'});
    });
  }



// for customer support page js for slide side ..................................


function showChatBot(){
	
	let chatDiv = document.querySelector(".chatDiv")
	let container = document.querySelector(".customerSupportInner");
	let chatInner = document.querySelector(".chatInner")
	
	chatInner.style.display='none';
	chatDiv.style.display='flex';
  console.log("click")
}



	//  {
//   "event": {
//     "token": "TOKEN",
//     "expectedAction": "USER_ACTION",
//     "siteKey": "6LeJu3gqAAAAAMOIhkOf4eaHa4EsEyEziN4oRjnr",
//   }
// }


// https://recaptchaenterprise.googleapis.com/v1/projects/startlifebank-1731068039253/assessments?key=API_KEY





// @Override
// public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                     Authentication authentication) throws IOException {
//     String username = authentication.getName();
    
//     // Check if user has a specific role
//     boolean isAdmin = authentication.getAuthorities().stream()
//                                     .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
    
//     if (isAdmin) {
//         response.sendRedirect("/admin/dashboard");
//     } else {
//         response.sendRedirect("/home");
//     }
// }


// @Override
// public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                     Authentication authentication) throws IOException {
//     String username = authentication.getName();
//     System.out.println("User " + username + " logged in successfully at " + java.time.LocalDateTime.now());

//     // Proceed to the default success URL or redirect to a custom page
//     response.sendRedirect("/home");
// }

