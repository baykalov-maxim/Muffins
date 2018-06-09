package ua.nure.muffins.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import ua.nure.muffins.service.MuffinService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class StorePage {

    private MuffinService muffinService;

    @Autowired
    public StorePage(
            @Qualifier("jdbcMuffin") MuffinService muffinService) {

        this.muffinService = muffinService;
    }

    @GetMapping("/store")
    public String mainPage(
            HttpServletResponse response,
            @CookieValue(value = "session_id", defaultValue = "null") String sessionId,
            Model model
    ) {
        if (sessionId.equals("null"))
            response.addCookie(new Cookie("session_id", String.valueOf(System.currentTimeMillis() + (int) (Math.random() * 1000))));

        model.addAttribute("muffins", muffinService.getAll());
        return "store";
    }
}
