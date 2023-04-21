package UI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@RestController
public class InputController {





    @GetMapping("/example")
    public String example(@RequestParam(name = "fName") String fName,
                          @RequestParam(name = "age") int age, Model model) {
        model.addAttribute("fName", fName);
        model.addAttribute("age", age);

        return "name="+fName;
    }



    // -Model objekt kan gives flere attributter end dem fra parametre
    // -Model objekt kan bruge 'view resolution' noget med at gøre det adaptable til mobil/desktop

    // Model er class i spring framwork der funkere som et objekt der bliver bygget fra HTML variabler tastet på siden
    // ok så først siger vi

    //          @GetMapping("/example")

    // der fortæller vi skal bruge info fra HTML URL page/example
    // så starter vi metoden der returnere et String:

    //          public String example(  )
    //                     parametrene^ skal også hentes fra HTML
    //
    // vi bruger @RequestParam til at hente variabler fra HTML siden som blev kaldt i @GetMapping()

    //          @RequestParam(name = "fName") String fName

    // her henter vi fornavn som en ny bruger har skrevet i HTML.
    // (name = "fName") siger at vi har gemt fornavn som "fName" i vores HTML variabel
    // fordi det første 'name' i parantesen ikke er en variabel men et alias for et String (because f you)
    // String fName er den java variabel som vi assigner den kaldte HTML variabel, derved oversætter mellem sprog

    // ligsom et objekt kan modellen have flere attributter f.eks: @RequestParam(name = "age") int age
    // efter vi har vores parametre med skal vi lukke den ved at oprette en instans af en model:

    //          Model, model) {
    //              model.addAttribute("name", fName);

    // her får modellen sine attributter, hvor ("name", fName); siger modellen skal have en attribut der hedder "fName"
    // og den får værdien fra vores java String variabel 'fName'
    // så til sidst kan vi return et string med de input vi kaldte og gemte i variabler

    //          return "navn: " + fName + " age: " + age;



}