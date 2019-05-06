package com.alan.yx.springInAction.Chapter_05.Spittr.src.main.java.spittr.web;

import com.alan.yx.springInAction.Chapter_05.Spittr.src.main.java.spittr.Spitter;
import com.alan.yx.springInAction.Chapter_05.Spittr.src.main.java.spittr.data.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    /**
     * 程序清单5.13 SpitterController：展现一个表单，允许用户注册该应用
     */
    @RequestMapping(value = "/register1", method = GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    /**
     * 程序清单5.19 processRegistration()：确保所提交的数据是合法的
     */
    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(
            // 校验 Spitter 输入
            @Valid Spitter spitter,
            Errors errors,
            Model model) {
        // 如果校验出现错误，则重新返回注册菜单
        if (errors.hasErrors()) {
            return "registerForm";
        }
        // 保存 Spitter
        spitterRepository.save(spitter);

        // 重定向的方式2：以占位符的方式更加的安全
//        model.addAttribute("username",spitter.getUsername());
//        return "redirect:/spitter/{username}";

        // 重定向到基本信息页
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }

}
