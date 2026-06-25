package quest.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeFreeRestController {
    @GetMapping("/free")
    public String free() {
        return "FREEEE (3) !!";
    }
}
