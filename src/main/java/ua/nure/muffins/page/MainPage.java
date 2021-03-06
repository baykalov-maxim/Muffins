package ua.nure.muffins.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.nure.muffins.dto.MuffinDto;
import ua.nure.muffins.service.CartService;
import ua.nure.muffins.service.MuffinService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainPage {

    private MuffinService muffinService;
    private CartService cartService;

    @Autowired
    public MainPage(CartService cartService) {
        this.cartService = cartService;
    }

    @Resource(name = "${type.muffin}")
    protected void setMuffinService(MuffinService muffinService) {
        this.muffinService = muffinService;
    }

    @RequestMapping("/")
    public String mainPage(
            HttpServletResponse response,
            @CookieValue(value = "session_id", defaultValue = "null") String sessionId,
            Model model
    ) {
        long id;
        if (sessionId.equals("null")) {
            id = System.currentTimeMillis() + (int) (Math.random() * 1000);
            response.addCookie(new Cookie("session_id", String.valueOf(id)));
        } else {
            id = new Long(sessionId);
        }

        if (!cartService.isPresent(id)) {
            cartService.addCart(id);
        }

        List<MuffinDto> muffins = muffinService.getRandomMuffins();
        cartService.setInCart(id, muffins);

        model.addAttribute("muffins", muffins);
        return "index";
    }
}
