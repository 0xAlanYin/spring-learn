package com.alan.yx.springInAction.Chapter_05.Spittr.src.main.java.spittr.web;

import com.alan.yx.springInAction.Chapter_05.Spittr.src.main.java.spittr.Spittle;
import com.alan.yx.springInAction.Chapter_05.Spittr.src.main.java.spittr.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 程序清单5.10 SpittleController：在模型中放入最新的spittle列表
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        // 注入 SpittleRepository
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        // 将 Spittle 添加到模型中
        model.addAttribute(spittleRepository.findOne(spittleId));
        // 显示的指定 mode 的 key
//        model.addAttribute("spittle",spittleRepository.findOne(spittleId));
        // 返回视图名
        return "spittle";
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittle(Model model) {
//        // 将 Spittle 添加到模型中
//        model.addAttribute(spittleRepository.findOne(1));
//        // 显示的指定 mode 的 key
////        model.addAttribute("spittle",spittleRepository.findOne(spittleId));
//        // 返回视图名
//        return "spittle";
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittle2(Map map) {
//        // Map 将 Spittle 添加到模型中(效果同上)
//        map.put("spittle", spittleRepository.findOne(1));
//        return "spittle";
//    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) throws Exception {
        spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
                form.getLongitude(), form.getLatitude()));
        return "redirect:/spittles";
    }

}
