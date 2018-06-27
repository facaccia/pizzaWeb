package com.scai.esercizioPizza.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scai.esercizioPizza.model.Pizza;

@Controller
public class ViewController {
	
	@Autowired
	private EntityManager entityManager;

	    private Session getSession() {
	        return entityManager.unwrap(Session.class);
	    }
	
	@Autowired
	private
	PizzaController pizzaController;

	
	@RequestMapping("welcome")
	public String welcome() {
		return "welcomePage";
	}
	
	@RequestMapping("/ordineForm")
	public String ordineForm(Model model,
			HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
		List<Pizza> listPizza= getPizzaController().getAllPizza();
		System.out.println(listPizza.get(0).getDescrizione());
		session.setAttribute("listPizza", listPizza);
//		model.addAttribute("listPizza", listPizza.get(0).getDescrizione());
//		new ModelAndView("redirect:/WEB-INF/jsp/welcomePage.jsp");
		
		return "ordineForm";
		}

	private PizzaController getPizzaController() {
		return pizzaController;
	}




}
