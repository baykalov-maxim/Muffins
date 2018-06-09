package ua.nure.muffins.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutPage {

    @RequestMapping("/about")
    public String mainPage() {
        return "about";
    }
}
