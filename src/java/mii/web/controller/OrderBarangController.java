package mii.web.controller;

import mii.entity.Customer;
import mii.entity.OrderBarang;
import mii.entity.OrderDetail;
import mii.web.service.CustomerService;
import mii.web.service.OrderBarangService;
import mii.web.service.OrderDetailService;
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
@RequestMapping("/admin/order")
public class OrderBarangController {
    private OrderBarangService orderBarangService;
    private CustomerService customerService;
    private OrderDetailService orderDetailService;

    public OrderBarangService getOrderBarangService() {
        return orderBarangService;
    }
    
    @Autowired
    public void setOrderBarangService(OrderBarangService orderBarangService) {
        this.orderBarangService = orderBarangService;
    }
    
    public CustomerService getCustomerService() {
        return customerService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public OrderDetailService getOrderDetailService() {
        return orderDetailService;
    }

    @Autowired
    public void setOrderDetailService(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }
    
    @RequestMapping(value = "/list", method= RequestMethod.GET) 
    public String getAllOrder(Model model){
        model.addAttribute("orders", this.orderBarangService.getAll());
        return "order"; 
    }
    
    @RequestMapping(value = "/forminsert", method= RequestMethod.GET) 
    public String formInsertOrder(Model model){
        model.addAttribute("orders", this.orderBarangService.getAll()); 
        return "insert_order";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST) // didalam value itu url yg kita panggil nantinya
    public RedirectView getData(@RequestParam(required = true)String waktu, int total_bayar, String status_order){ 
            //request param disini sesuai name di inputannya
            //tanggal orderny dri current date bkn inputan, mknya tanggal g ditulis di constructor
            this.orderBarangService.insert(new OrderBarang(waktu, total_bayar, status_order));
            return new RedirectView("/admin/order/list", true); //ini sesuai hirarki reqst mappingnya
    }
    
       //==== menuju edit OrderBarang ====
    @RequestMapping(value = "/edit", method= RequestMethod.GET) 
    public String formEditOrder(@RequestParam(required = true) Long id, Model model){ //Pake RequestParam klo ada kirim/minta data, disini kita tulis name dri inputannnya dan type datanya apa.
        model.addAttribute("order",  this.orderBarangService.getById(id)); //"order" itu dpke ntar di jstl.
        return "edit_order"; //ini sesuai nama jspnya, misal edit_order.jsp 
    }
    
    //==== menyimpan update OrderBarang ==== 
    @RequestMapping(value = "/update", method = RequestMethod.POST) // didalam value itu url yg kita panggil nantinya
    public RedirectView saveUpdate(@RequestParam(required = true) Long id, String waktu, int total_bayar, 
        String status_order, OrderDetail orderDetail, Customer customer){ //RequestParam disini kita tulis name inputannnya dan type datanya apa.
            this.orderBarangService.update(new OrderBarang(id, waktu, total_bayar, status_order, orderDetail, customer));
            return new RedirectView("/admin/order/list", true); 
    }
         
    //==== menyimpan delete OrderBarang ==== 
    @RequestMapping(value = "/delete", method = RequestMethod.GET) 
    public RedirectView deleteOrder(@RequestParam(required = true) Long id){ 
        this.orderBarangService.delete(new OrderBarang(id));
        return new RedirectView("/admin/order/list", true); //Redirec view ini sesuai hirarki Request mappingnya
    }
    
    @RequestMapping(value = "/home", method= RequestMethod.GET) 
    public RedirectView toHomeAdmin(){
        return new RedirectView("/admin/home", true);
    }
    
    //==== menampilkan List Order Detail berdasar selected ID Order ====
    @RequestMapping(value = "/order_detail", method= RequestMethod.GET) //a href mngacu pada request mapping
    public String toOrderDetail(@RequestParam(required = true) Long id, Model model){
        model.addAttribute("orderdetails",  this.orderDetailService.getDetailByIdOrder(id)); //"orderdetails" dipke di jstl pas ngeview datanya
        return "order_detail_byidorder"; 
    }
}
