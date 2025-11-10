package com.itproger.blog.controllers;

import com.itproger.blog.models.Post;
import com.itproger.blog.repo.postRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class BlogController {

    @Autowired
    private postRepository postRepository;  //чтобы передавать все записи в шаблон ( указываем репозиторий и переменную)

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();   //массив данных, в котором все записи из таблицы о каком то обьекте
        model.addAttribute("posts",posts);     //обращение к модели, и передача верхнего массива  с именем пост
        return "blog-main";
    }
}
