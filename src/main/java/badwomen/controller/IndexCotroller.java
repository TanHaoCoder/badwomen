package badwomen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/24 1:59
 */
@Controller
public class IndexCotroller {

    @RequestMapping({"/","index"})
    public String index(Model model){
        model.addAttribute("msg","hello yznu");
        return "index";
    }

}
