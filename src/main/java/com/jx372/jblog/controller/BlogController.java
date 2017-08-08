package com.jx372.jblog.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jx372.jblog.service.BlogService;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping({"/{postNo1}/{cate}","/{postNo1}",""})
	public String blog(@PathVariable("id") String userId, @PathVariable("postNo1") Optional<Integer> postNo1,@RequestParam(value="cate",required=true, defaultValue="%") String category, Model model){
		System.out.println("-------------------------------------------------" + userId);
		int post;
		if(postNo1.isPresent()){
			post=postNo1.get();
			model.addAttribute("postvo", blogService.getPostByNo(post));
		}else{
			post=-1;
		}
		
		model.addAttribute("cateList", blogService.getCategory(userId));
		model.addAttribute("blogvo", blogService.getBlog(userId));
		model.addAttribute("postList", blogService.getPostList(userId, category));
		model.addAttribute("post", post);
		return "/blog/blog-main";
	}

}
