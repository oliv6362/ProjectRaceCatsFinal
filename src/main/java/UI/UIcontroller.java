package UI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UIcontroller {


 @GetMapping("/") //Forside
 public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
  model.addAttribute("name", name);
  return "index";
 }

 /*@GetMapping(value= "/")
public String home() {
   return "index";
}*/


//TODO - LOGIN SYSTREM
 @GetMapping("/login")
 public String showLoginForm() {
  return "login";
 }

 @PostMapping("/login")
 public String login(@RequestParam String email, @RequestParam String password) {
  // handle login request
  System.out.println(email + " " + password);
  //String usernameLogin = email;
  //System.out.println(usernameLogin);

//to sec lau ligger op på git
  //UseCase 


  return "/greeting";
 }

/*
 @GetMapping("/Authentication")
 public String loginAuthentication(@RequestParam(name="name", required=false, defaultValue="Ragdoll Fans") String name, Model model) {
  model.addAttribute("name", name);
  return "greeting";
 }*/

 //TODO - LOGIN SUCCESFUL
 @GetMapping("/greeting")
 public String greeting(@RequestParam(name="name", required=false, defaultValue="Ragdoll Fans") String name, Model model) {
  model.addAttribute("name", name);
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

  UseCase usecase = new UseCase();
  usecase.buildUser(fname, lname, email, psw, phoneNumber);


  return "/greeting";
 }


 @GetMapping("/oversigt")
 public String example(Model model) {
  // perform some logic here
  return "example-page";
 }
}

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

