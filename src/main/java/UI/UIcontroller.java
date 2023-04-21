package UI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UIcontroller {

    @RestController
    public inputController(String url) { // jeg læser input fra html siden og return name

        @GetMapping("/" + url)
        public String example(@RequestParam(name = "userID") int id,
        @RequestParam(name = "fName") String fName,
        @RequestParam(name = "lName") String lName,
        @RequestParam(name = "email") String email,
        @RequestParam(name = "password") String password,
        @RequestParam(name = "phoneNumber") int phoneNumber, Model model) {
            model.addAttribute("userID", id);
            model.addAttribute("fName", fName);
            model.addAttribute("lName", lName);
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            model.addAttribute("phoneNumber", phoneNumber);
            return "name="+name;
        }
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