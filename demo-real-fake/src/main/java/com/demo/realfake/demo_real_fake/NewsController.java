
package com.demo.realfake.demo_real_fake;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NewsController {

    private List<News> recentNews = new ArrayList<>();

    @GetMapping("/news")
    public String index(Model model) {
        model.addAttribute("recentNews", recentNews);
        return "index";
    }

    @PostMapping("/addPost")
    public String addPost(@RequestParam String title, @RequestParam String content, @RequestParam("image") MultipartFile image, Model model) {
        String imagePath = "";
        if (!image.isEmpty()) {
            try {
                String fileName = image.getOriginalFilename();
                String uploadDir = "src/main/resources/static/images/";
                File transferFile = new File(uploadDir + fileName);
                image.transferTo(transferFile);
                imagePath = "/images/" + fileName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        News news = new News(title, content, imagePath);
        recentNews.add(news);
        model.addAttribute("recentNews", recentNews);
        return "redirect:/news";
    }
}
