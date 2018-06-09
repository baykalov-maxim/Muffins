package ua.nure.muffins.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BasketPage {

    @RequestMapping("/basket")
    public String mainPage(
            HttpServletResponse response,
            @CookieValue(value = "session_id", defaultValue = "null") String sessionId,
            Model model
    ) {
        if (sessionId.equals("null"))
            response.addCookie(new Cookie("session_id", String.valueOf(System.currentTimeMillis() + (int) (Math.random() * 1000))));

        return "basket";
    }
}
