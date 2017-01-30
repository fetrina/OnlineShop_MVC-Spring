package mii.web.controller;

import mii.entity.Customer;
import mii.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author user2
 */
@Controller
@RequestMapping("/admin/customer")
public class CustomerController {
    
    private CustomerService customerService;

    public CustomerService getCustomerService() {
        return customerService;
    }
    
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @RequestMapping(value = "/list", method= RequestMethod.GET) 
    public String getAllCustomer(Model model){
        model.addAttribute("customers", this.customerService.getAll());
        return "customer"; 
    }
    
    @RequestMapping(value = "/forminsert", method= RequestMethod.GET) 
    public String formInsertCustomer(Model model){
        model.addAttribute("customers", this.customerService.getAll()); 
        return "insert_customer";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST) // didalam value itu url yg kita panggil nantinya
    public RedirectView getData(@RequestParam(required = true) String nama, String hp, String email, String alamat, 
            String kota, String provinsi){ //request param disini sesuai name di inputannya
            this.customerService.insert(new Customer(nama, hp, email, alamat, kota, provinsi));
            return new RedirectView("/admin/customer/list", true); //ini sesuai hirarki reqst mappingnya
    }
    
       //==== menuju edit customer ====
    @RequestMapping(value = "/edit", method= RequestMethod.GET) 
    public String formEditCustomer(@RequestParam(required = true) Long id, Model model){ //Pake RequestParam klo ada kirim/minta data, disini kita tulis name dri inputannnya dan type datanya apa.
        model.addAttribute("customer",  this.customerService.getById(id)); //"customer" itu dpke ntar di jstl.
        return "edit_customer";  //ini sesuai nama jspnya, misal edit_customer.jsp
    }
    
    //==== menyimpan update customer ==== 
    @RequestMapping(value = "/update", method = RequestMethod.POST) // didalam value itu url yg kita panggil nantinya
    public RedirectView saveUpdate(@RequestParam(required = true) Long id, String nama, String hp, String email, 
            String alamat, String kota, String provinsi){ //RequestParam disini kita tulis name inputannnya dan type datanya apa.
        
            this.customerService.update(new Customer(id, nama, hp, email, alamat, kota, provinsi));
            return new RedirectView("/admin/customer/list", true); 
    }
         
    //==== menyimpan delete customer ==== 
    @RequestMapping(value = "/delete", method = RequestMethod.GET) 
    public RedirectView deleteCustomer(@RequestParam(required = true) Long id){ 
        this.customerService.delete(new Customer (id));
        //this.customerService.delete(id);
        return new RedirectView("/admin/customer/list", true); 
    }
    
    @RequestMapping(value = "/home", method= RequestMethod.GET) 
    public RedirectView toHomeAdmin(){
        return new RedirectView("/admin/home", true);
    }
}
