package eu.isdc.employeesMng.config;

import eu.isdc.employeesMng.model.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private static final String template = "Hello, %s!";

    @RequestMapping("/getUser")
    public User getUser(@RequestParam(value="name", defaultValue="you") String name) {
        return new User(String.format(template, name));
    }

    @RequestMapping("/users")
    public String getUsers() {
        return "["
        		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
        		+ "{\"name\":\"Ion\", \"age\":\"64\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Paul\", \"age\":\"35\", \"language\":\"engleza\"},"
        		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
        		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"spaniola\"}, "
        		+ "{\"name\":\"Maria\", \"age\":\"37\", \"language\":\"spaniola\"},"
        		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
        		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Maria\", \"age\":\"34\", \"language\":\"engleza\"},"
        		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Paul\", \"age\":\"35\", \"language\":\"engleza\"},"
        		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
        		+ "{\"name\":\"Remus\", \"age\":\"22\", \"language\":\"spaniola\"}, "
        		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
        		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
        		+ "{\"name\":\"Paul\", \"age\":\"24\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
        		+ "{\"name\":\"Remus\", \"age\":\"11\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
        		+ "{\"name\":\"Ion\", \"age\":\"14\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
        		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Remus\", \"age\":\"35\", \"language\":\"spaniola\"},"
        		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
        		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"}"
        		+ "]";
    }

}