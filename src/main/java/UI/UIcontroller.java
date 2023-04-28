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
 public String login(@RequestParam String email, @RequestParam String password, HttpSession session) { //HttpSession er et springboot objekt
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

 @GetMapping("/dashboard")
 public String showDashboard(HttpServletRequest request, Model model) { //httpServletRequest you guessed it det et springboot objekt
  HttpSession session = request.getSession();
  User user = (User) session.getAttribute("user");
  System.out.println("Session id: " + session.getId());
  model.addAttribute("user", user);
  return "dashboard";
 }




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
 public String signUp(@RequestParam String fName, @RequestParam String lName, @RequestParam String email, @RequestParam String psw, @RequestParam int phoneNumber) {
  // handle signup request
  System.out.println(fName + " " + lName + " " + email+ " " + psw+ " " + phoneNumber);

  uc.buildUser(fName, lName, email, psw, phoneNumber);


  return "redirect:/frontPage";
 }


 @GetMapping("/editMember")
 public String showEditForm() {
  return "editMember";
 }

 @PostMapping("/editMember")
 public String editMember(@RequestParam String fname, @RequestParam String lname, @RequestParam String email, @RequestParam String psw, @RequestParam int phoneNumber) {
  // handle signup request
  System.out.println(fname + " " + lname + " " + email+ " " + psw+ " " + phoneNumber);

  uc.editUser(fname, lname, email, psw, phoneNumber);


  return "greeting";
 }




 @GetMapping("/oversigt")
 public String example(Model model) {
  // perform some logic here
  return "example-page";
 }




 @GetMapping("/dataside")
 public String getUser(Model model) {
  //User[] users = new User[]{new User("Lau", "b", "gmail", "123", 12345), new User("Lea", "b", "gmail", "123", 12345)};
  User user = new User (2, "b", "gmail", "123", "123", 12345);
  model.addAttribute("user", user);
  return "dataside";
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


