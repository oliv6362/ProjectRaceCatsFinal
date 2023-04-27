package UI;

import Entity.User;
import Usecase.UseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UIcontroller {

 UseCase uc = new UseCase();



//TODO - index aka forside
 @GetMapping("/") //Forside
 public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
  model.addAttribute("name", name);
  return "index";
 }
 @GetMapping("/frontPage")
 public String showFrontPage() {
  return "index";
 }

 @GetMapping("/members")
 public String showAllMembersPage() {
  return "members";
 }

 @GetMapping("/cats")
 public String showAllCatsPage() {
  return "cats";
 }

 @GetMapping("/aboutUs")
 public String showAboutUsPage() {
  return "aboutUs";
 }

//TODO - Account
 @GetMapping("/account")
 public String showAccountPage() {
  return "account";
 }


//TODO - LOGIN SYSTREM
 @GetMapping("/login")
 public String showLoginForm() {
  return "login";
 }

 @PostMapping("/login")
 public String login(@RequestParam String email, @RequestParam String password) {
  // handle login request
  System.out.println(email + " " + password);

  if (!uc.loginUser(email, password)) {
   System.out.println("forkert bruger");
   return "login";
  } else {
   User user = new User(email, password); // create a new User object
   session.setAttribute("user", user); // store the User object in the session
   return "redirect:/dashboard";
  }
 }



/*
 @GetMapping("/Authentication")
 public String loginAuthentication(@RequestParam(name="name", required=false, defaultValue="Ragdoll Fans") String name, Model model) {
  model.addAttribute("name", name);
  return "greeting";
 }*/

 //TODO - LOGIN SUCCESFUL
 @GetMapping("/greeting")
 public String greeting(@RequestParam(name="fName", required=false, defaultValue="Ragdoll Fan") String fName,
                        @RequestParam(name="lName") String lName,
                        Model model) {
  model.addAttribute("fName", fName);
  model.addAttribute("lName", lName);
  return "greeting";
 }


 //TODO SIGNUP
 @GetMapping("/signUp")
 public String showSignupForm() {
  return "signUp";
 }



 @PostMapping("/signUp")
 public String signUp(@RequestParam String fname, @RequestParam String lname, @RequestParam String email, @RequestParam String psw, @RequestParam int phoneNumber) {
  // handle signup request
  System.out.println(fname + " " + lname + " " + email+ " " + psw+ " " + phoneNumber);

  uc.buildUser(fname, lname, email, psw, phoneNumber);


  return "greeting";
 }


 @GetMapping("/oversigt")
 public String example(Model model) {
  // perform some logic here
  return "example-page";
 }




 @GetMapping("/dataside")
 public String getUser(Model model) {
  User[] users = new User[]{new User("Lau", "b", "gmail", "123", 12345), new User("Lea", "b", "gmail", "123", 12345)};
  model.addAttribute("users", users);
  return "users";
 }



 //when someone presses account run this - not finished
 public void getUser(){
  uc.getUser();
 }


 @GetMapping("/edituser")
 public String showEditMemberPage() {
  return "edituser";
 }


 @PostMapping("/edituser")
 public String readMembertest() {
   User user = uc.getUser();
   //edit name button = user.getfnavn

  System.out.println("den er her");

  editMembertest(user);//probably doesn't work
   return "frontPage";
  }

 public void editMembertest(User user){
   uc.editAccount(user);
 }



 }























/*
 public void registrerController() {



 }


   @GetMapping({"/example"})
   public String example(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age, Model model) {
    model.addAttribute("name", name);
    model.addAttribute("age", age);
    return "name=" + name;
   }*/



//is flagged as a @RestController, meaning it is ready for use by Spring MVC to handle web requests.
// @GetMapping maps / to the index() method. When invoked from a browser or by using curl on the command line,
// the method returns pure text. That is because @RestController combines @Controller and @ResponseBody,
// two annotations that results in web requests returning data rather than a view.

// DVS. @Controller OVERSÆTTER TIL OG FRA HTML
// DVS. @ResponseBody RETURNERE HTML TIL JAVA OBJEKT
// DVS. @RestController GØR BEGGE DELE LOL (i think?)
// DVS. @GetMapping NOTERER URL (i think?)

// In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container
// are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.

// DVS. @bean er Objekt

// """GET request is used to get single or multiple resources and @GetMapping annotation
// for mapping HTTP GET requests onto specific handler methods"""

