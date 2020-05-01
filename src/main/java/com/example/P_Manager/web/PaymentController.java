package com.example.P_Manager.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.P_Manager.domain.Payment;
import com.example.P_Manager.domain.PaymentRepository;
import com.example.P_Manager.domain.Person;
import com.example.P_Manager.domain.PersonRepository;
import com.example.P_Manager.domain.Type;
import com.example.P_Manager.domain.TypeRepository;

@Controller
public class PaymentController {
	@Autowired
	private PaymentRepository prepository; 
	
	@Autowired
	private TypeRepository trepository;
	
	@Autowired
	private PersonRepository urepository; 
	
	// Login page
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }		
	
	//Show all payments
    @RequestMapping(value= {"/", "/paymentlist"})
    public String paymentList(Model model) {	
        model.addAttribute("payments", prepository.findAll());
        return "paymentlist";
    }
    
    // RESTful service to get all payments
    @RequestMapping(value="/payments", method = RequestMethod.GET)
    public @ResponseBody List<Payment> paymentListRest() {	
        return (List<Payment>) prepository.findAll();
    }
    
    // RESTful service to get payment by id
    @RequestMapping(value="/payment/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Payment> findPaymentRest(@PathVariable("id") Long paymentId) {	
    	return prepository.findById(paymentId);
    }
    
    //Add new payment  
    @RequestMapping(value = "/addpayment")
    public String addPayment(Model model){
    	model.addAttribute("payment", new Payment());
    	model.addAttribute("types", trepository.findAll());
        return "addpayment";
    }     
    
    //Save new payment
    @RequestMapping(value = "/savepayment", method = RequestMethod.POST)
    public String save(Payment payment){
        prepository.save(payment);
        return "redirect:paymentlist";
    }
    
    //Delete payment and add it into paidlist; only possible for person with ADMIN role
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deletePayment(@PathVariable("id") Long paymentId, Model model ) {
    	prepository.deleteById(paymentId);
        return "redirect:../paymentlist";
    } 
    
    //Edit payment; only possible for person with ADMIN role    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPayment(@PathVariable("id") Long paymentId, Model model) {
    	model.addAttribute("edit", prepository.findById(paymentId));
    	model.addAttribute("types", trepository.findAll());
        return "editpayment";
    }  
        
    //Add new person; only possible for person with ADMIN role  
    @RequestMapping(value = "/addperson")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addPerson(Model model){
    	model.addAttribute("person", new Person());
        return "addperson";
    }     
    
    //Save new person
    @RequestMapping(value = "/saveperson", method = RequestMethod.POST)
    public String save(Person person){
        urepository.save(person);
        return "redirect:paymentlist";
    }
  
    //Add new type; only possible for person with ADMIN role
    @RequestMapping(value = "/addtype")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addType(Model model){
    	model.addAttribute("type", new Type());
        return "addtype";
    }     
    
    //Save new type
    @RequestMapping(value = "/savetype", method = RequestMethod.POST)
    public String save(Type type){
        trepository.save(type);
        return "redirect:paymentlist";
    }
}
