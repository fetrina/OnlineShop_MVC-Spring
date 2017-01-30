package mii.web.controller;

import mii.entity.Buku;
import mii.entity.OrderBarang;
import mii.entity.OrderDetail;
import mii.web.service.BukuService;
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
@RequestMapping("/admin/order_detail")
public class OrderDetailController {
    private OrderBarangService orderBarangService;
    private OrderDetailService orderDetailService;
    private BukuService bukuService;
    
    public OrderBarangService getOrderBarangService() {
        return orderBarangService;
    }
    
    @Autowired
    public void setOrderBarangService(OrderBarangService orderBarangService) {
        this.orderBarangService = orderBarangService;
    }

    public OrderDetailService getOrderDetailService() {
        return orderDetailService;
    }

    @Autowired
    public void setOrderDetailService(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    public BukuService getBukuService() {
        return bukuService;
    }
    
    @Autowired
    public void setBukuService(BukuService bukuService) {
        this.bukuService = bukuService;
    }
    
    @RequestMapping(value = "/list", method= RequestMethod.GET) // didalam value itu url yg kita panggil nantinya
    public String getAllOrderDetail(Model model){
        model.addAttribute("orderdetails", this.orderDetailService.getAll());
        model.addAttribute("orders", this.orderBarangService.getAll());
        return "order_detail"; //ini sesuai nama jspnya, misal order_detail.jsp
    }
    
    @RequestMapping(value = "/forminsert", method= RequestMethod.GET) 
    public String formInsertOrderDetail(Model model){
        model.addAttribute("orderdetails", this.orderDetailService.getAll());
        model.addAttribute("orders", this.orderBarangService.getAll());
        model.addAttribute("books", this.bukuService.getAll());
        return "insert_orderdetail";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST) // didalam value itu url yg kita panggil nantinya
    public RedirectView getData(@RequestParam(required = true) int qty, int subtotal, Long buku, Long orderBarang)
    { //request param disini sesuai name di inputannya
            this.orderDetailService.insert(new OrderDetail(qty, subtotal, new Buku(buku), new OrderBarang(orderBarang)));
            return new RedirectView("/admin/order_detail/list", true); //ini sesuai hirarki reqst mappingnya
    }
    
       //==== menuju edit OrderBarang ====
    @RequestMapping(value = "/edit", method= RequestMethod.GET) 
    public String formEditOrderDetail(@RequestParam(required = true) Long id, Model model){ //Pake RequestParam klo ada kirim/minta data, disini kita tulis name dri inputannnya dan type datanya apa.
        model.addAttribute("orderdetail",  this.orderDetailService.getById(id)); //"customer" itu dpke ntar di jstl.
        return "edit_orderdetail";  
    }
    
    //==== menyimpan update OrderBarang ==== 
    @RequestMapping(value = "/update", method = RequestMethod.POST) // didalam value itu url yg kita panggil nantinya
    public RedirectView saveUpdate(@RequestParam(required = true) Long id, int qty, int subtotal, Buku buku, 
        OrderBarang orderBarang){ //RequestParam disini kita tulis name inputannnya dan type datanya apa.
            this.orderDetailService.update(new OrderDetail(id, qty, subtotal, buku, orderBarang));
            return new RedirectView("/admin/order_detail/list", true); 
    }
         
    //==== menyimpan delete OrderBarang ==== 
    @RequestMapping(value = "/delete", method = RequestMethod.GET) 
    public RedirectView deleteOrder(@RequestParam(required = true) Long id){ 
        this.orderDetailService.delete(new OrderDetail(id));
        //this.customerService.delete(id);
        return new RedirectView("/admin/order_detail/list", true); 
    }
    
    @RequestMapping(value = "/home", method= RequestMethod.GET) 
    public RedirectView toHomeAdmin(){
        return new RedirectView("/admin/home", true);
    }
    
}
