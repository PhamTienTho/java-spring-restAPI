package vn.hoidanit.springrestwithai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String getHomePage() {
        return "Hello world";
    }

}
