//==== Controller untuk halaman client ====
// view katalog, search buku, regristrasi.
package mii.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mii.entity.Users;
import mii.web.service.BukuService;
import mii.web.service.CategoryService;
import mii.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author user2
 */
@Controller
@RequestMapping("/client")
public class ClientController {
    
    private BukuService bukuService;
    private CategoryService categoryService;
    private UsersService usersService;
    
    public CategoryService getCategoryService() {
        return categoryService;
    }
    
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public BukuService getBukuService() {
        return bukuService;
    }

    @Autowired
    public void setBukuService(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    public UsersService getUsersService() {
        return usersService;
    }
    
    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
    
    @RequestMapping(value = "/home", method= RequestMethod.GET) // didalam value itu url yg kita panggil nantinya
    public String toHome(Model model){
        model.addAttribute("books", this.bukuService.getAll());
        return "home_client"; //ini sesuai nama jspnya, misal home.jsp
    }
    
    @RequestMapping(value = "/katalog", method= RequestMethod.GET) 
    public String getAllBuku(Model model){
        model.addAttribute("books", this.bukuService.getAll());
        return "frontend/katalog_buku";
    }
    
    //==== menuju detail buku ====
    @RequestMapping(value = "/detailbuku", method= RequestMethod.GET) 
    public String toDetailBuku(@RequestParam(required = true) Long id, Model model){
        model.addAttribute("buku",  this.bukuService.getById(id)); //"category" itu dpke ntar di jstl.
        model.addAttribute("categories", this.categoryService.getAll()); //agar bisa nmpilin combo box category
        return "frontend/detail_buku";  
    }
    
    @RequestMapping(value = "/search", method= RequestMethod.GET) 
    public String searchBuku(Model model){
        model.addAttribute("categories", this.categoryService.getAll()); //agar bisa nmpilin combo box category saat search ctg
        return "frontend/search_buku";
    }
    
    @RequestMapping(value = "/getsearch", method= RequestMethod.GET) // didalam value itu url yg kita panggil nantinya
    public String getSearchBuku(Model model, String search){
        model.addAttribute("books", this.bukuService.searchBuku(search)); //books itu dipake di jstl
        return "frontend/hasil_search";  //ini sesuai nama jspnya, misal search_buku.jsp klo didlm folder tulisfolder/namajspnya
    }
    
    @RequestMapping(value = "/getsearch_byprice", method= RequestMethod.GET)
    public String getSearchBukuByPrice(Model model, int harga){
        model.addAttribute("books", this.bukuService.searchBukuByPrice(harga));
        return "frontend/hasil_search"; 
    }
    
    @RequestMapping(value = "/getsearch_bycategory", method= RequestMethod.GET)
    public String getSearchBukuByCategory(Model model, Long category){
        model.addAttribute("books", this.bukuService.searchBukuByCategory(category));
        return "frontend/hasil_search"; 
    }
    
    @RequestMapping(value = "/register", method= RequestMethod.GET) 
    public String registerUser(){
        return "frontend/register_user"; 
    }
    
    @RequestMapping(value = "/saveregister", method = RequestMethod.POST) 
    public RedirectView saveUser(@RequestParam(required = true) String username, String password, String leveluser){ //request param disini sesuai name di inputannya
        this.usersService.insert(new Users(username, password, leveluser));
            return new RedirectView("/client/home", true); 
    }
    
    @RequestMapping(value = "/keranjangbelanja", method= RequestMethod.GET) 
    public String toShoppingChart(){
        return "frontend/keranjang_belanja";
    }
    
    //=== outputnya masi error bwh ini ===
    @RequestMapping(value = "/belibuku", method= RequestMethod.GET) 
    public String shoppingChart(@CookieValue ("id") Long id, HttpServletResponse response){
 
        Cookie orderdet_cookie = new Cookie("id", id.toString());
        response.addCookie(orderdet_cookie);
        return "frontend/tes_cookies";
    }
    
}
