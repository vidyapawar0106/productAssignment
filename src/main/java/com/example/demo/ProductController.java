package com.example.demo;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ProductController {
@Autowired
ProductRepo repo;
@RequestMapping("/")
public ModelAndView loadFrontPage(HttpServletRequest request,HttpServletResponse response)
{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("index.jsp");
	return mv;
}

@RequestMapping("/insert")
public ModelAndView insertProduct(HttpServletRequest request,HttpServletResponse response)
{
	ModelAndView mv=new ModelAndView();
	
	String pname=request.getParameter("pname");
	String prize1=request.getParameter("prize");
	double prize=Double.parseDouble(prize1);
	String description=request.getParameter("description");
	Product product=new Product();
	product.setPname(pname);
	product.setPrize(prize);
	product.setDescription(description);
	Product p=repo.save(product);
	if(p!=null)
	{
		mv.setViewName("success.jsp");
	}
	else
	{
		mv.setViewName("fail.jsp");
	}
	return mv;
	
}
@RequestMapping("/viewProduct")
public ModelAndView viewProduct(HttpServletRequest request,HttpServletResponse response)
{
	ModelAndView mv=new ModelAndView();
	List<Product> list=repo.findAll();
	mv.setViewName("viewproduct.jsp");
	mv.addObject("list", list);
	return mv;
}
@RequestMapping("/searchProduct")
public ModelAndView searchProduct(HttpServletRequest request,HttpServletResponse response)
{
	ModelAndView mv=new ModelAndView();
	String str=request.getParameter("search");
	List<Product> list=repo.findAll();
	List<Product> newlist=list.stream().filter(e->str.equalsIgnoreCase(e.Pname)).collect(Collectors.toList());
	if(newlist==null)
	{
		mv.setViewName("searchFail.jsp");
	}
	else
	{
		
		mv.addObject("newlist",newlist);
		mv.setViewName("searchResult.jsp");
	}
	return mv;
}
@RequestMapping("/update")
public ModelAndView updateProduct(HttpServletRequest request,HttpServletResponse response)
{
	ModelAndView mv=new ModelAndView();
	int id= Integer.parseInt(request.getParameter("id"));
	String pname=request.getParameter("pname");
	String prize1=request.getParameter("prize");
	double prize=Double.parseDouble(prize1);
	String description=request.getParameter("description");
	Product pp=new Product();
	pp.setId(id);
	pp.setPname(pname);
	pp.setPrize(prize);
	pp.setDescription(description);
	repo.save(pp);
	mv.setViewName("index.jsp");
	return mv;
}
@RequestMapping("/delete")
public ModelAndView deleteProduct(HttpServletRequest request,HttpServletResponse response)
{
	ModelAndView mv=new ModelAndView();
	int id=Integer.parseInt(request.getParameter("id"));
	repo.deleteById(id);
	mv.setViewName("index.jsp");
	return mv;
}
}


