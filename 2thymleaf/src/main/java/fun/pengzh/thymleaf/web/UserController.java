package fun.pengzh.thymleaf.web;

import fun.pengzh.thymleaf.model.User;
import fun.pengzh.thymleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author fun.pengzh
 * @class fun.pengzh.thymleaf.controller.WebController
 * @desc
 * @since 2021-04-22
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(ModelMap map) {
        map.addAttribute("message", "时间：" + LocalDateTime.now());
        return "hello";
    }

    @RequestMapping("/")
    public String home(ModelMap map) {
        return "redirect:/pages";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("user", userService.findAll());
        return "user/UserList";
    }

    @RequestMapping("/pages")
    public ModelAndView pages(@RequestParam(value = "start", defaultValue = "0") Integer start,
                              @RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        List<String> list = Arrays.asList("id", "name");
        start = start < 0 ? 0 : start;
        Pageable pageRequest = PageRequest.of(start, limit, Sort.sort(User.class));
        Page<User> userPage = userService.findByPage(pageRequest);
        ModelAndView mav = new ModelAndView("user/UserPageList");
        mav.addObject("page", userPage);
        return mav;
    }

    @RequestMapping("/toAdd")
    public String toAdd(ModelMap map) {
        return "user/UserAdd";
    }

    @RequestMapping(value = "/toEdit/{id}", method = RequestMethod.GET)
    public String toEdit(Model model, @PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        model.addAttribute("user", user.get());
        return "user/UserEdit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
