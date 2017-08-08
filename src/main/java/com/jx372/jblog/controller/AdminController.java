package com.jx372.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.jx372.jblog.service.AdminService;
import com.jx372.jblog.service.FileUploadService;
import com.jx372.jblog.vo.BlogVo;
import com.jx372.jblog.vo.CategoryVo;
import com.jx372.jblog.vo.PostVo;
import com.jx372.jblog.vo.UserVo;
import com.jx372.security.AuthUser;

@Controller
@RequestMapping("/{userId}/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	FileUploadService fileupService;
	
	@RequestMapping(value="/category", method=RequestMethod.GET)
	public String category(Model model, @AuthUser UserVo userVo){
		model.addAttribute("path", "category");
		model.addAttribute("blogvo", adminService.getBlog(userVo.getNo()));
		model.addAttribute("list", adminService.getAdminCList(userVo.getNo()));
//		model.addAttribute("groupCount", adminService.getGroupCount());
		return "/blog/blog-admin-category";
	}
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String category(@ModelAttribute CategoryVo categoryVo, @AuthUser UserVo userVo){
		categoryVo.setNo(userVo.getNo());
		adminService.insertCate(categoryVo);
		return "redirect:/"+userVo.getId()+"/admin/category";
	}
	
	
	@RequestMapping(value="/basic", method=RequestMethod.GET)
	public String basic(Model model, @AuthUser UserVo userVo){
		model.addAttribute("path", "basic");
		model.addAttribute("blogvo", adminService.getBlog(userVo.getNo()));
		return "/blog/blog-admin-basic";
	}
	@RequestMapping(value="/basic", method=RequestMethod.POST)
	public String basic(@AuthUser UserVo userVo,@ModelAttribute BlogVo vo, @RequestParam(value="file") MultipartFile file){
		String url = fileupService.restore(file);
		
		if(url == ""){
			url=null;
		}
		vo.setLogo(url);
		vo.setUserNo(userVo.getNo());
		adminService.updateBlog(vo);
		
		return "redirect:/"+userVo.getId()+"/admin/basic";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(@PathVariable("userId") String userId,Model model, @AuthUser UserVo userVo){
		model.addAttribute("blogvo", adminService.getBlog(userVo.getNo()));
		model.addAttribute("path", "write");
		model.addAttribute("clist", adminService.getAdminCList(userVo.getNo()));
		return "/blog/blog-admin-write";
	}
	
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute PostVo postVo, @ModelAttribute("category") String category, @AuthUser UserVo authUser){
		adminService.insertPost(postVo, category, authUser.getNo());
		return "redirect:/"+authUser.getId()+"/1";
	}
}
