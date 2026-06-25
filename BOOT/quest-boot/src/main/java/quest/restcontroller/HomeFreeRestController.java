package quest.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/home/free")
public class HomeFreeRestController {

    @GetMapping()
    public String HomeFreeRestController() {
        return "FREEEEEEE";
    }
}
