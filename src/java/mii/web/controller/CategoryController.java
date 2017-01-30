package mii.web.controller;

import mii.entity.Category;
import mii.web.service.CategoryService;
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
@RequestMapping("/admin/category")
public class CategoryController {
      
    private CategoryService categoryService;
    
    public CategoryService getCategoryService() {
        return categoryService;
    }

    @Autowired //yg set di autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    @RequestMapping(value = "/list", method= RequestMethod.GET) // didalam value itu url yg kita panggil nantinya
    public String getAllCategory(Model model){ //nama methodnya terserah aja
        model.addAttribute("categories", this.categoryService.getAll()); //categories digunakan saat di jstl bgian foreach items, this.categoryService.getAll u mnmplkn smua data
        return "category"; //ini sesuai nama jspnya, misal category.jsp
    }
    
    @RequestMapping(value = "/forminsert", method= RequestMethod.GET) 
    public String formInsertCat(){
        return "insert_category"; 
    }
    
    //==== menyimpan insert category ====
    @RequestMapping(value = "/save", method = RequestMethod.POST) 
    public RedirectView getData(@RequestParam(required = true) String name){ //Pake RequestParam klo ada kirim/minta data, disini kita tulis name dri inputannnya dan type datanya apa.
        this.categoryService.insert(new Category(name)); 
        return new RedirectView("/admin/category/list", true); 
    }
    
    //==== menuju edit category ====
    @RequestMapping(value = "/edit", method= RequestMethod.GET) 
    public String formEditCategory(@RequestParam(required = true) Long id, Model model){
        model.addAttribute("category",  this.categoryService.getById(id)); //"category" itu dpke ntar di jstl. 
        return "edit_category"; //pke return String klo skdar mnju ke hlm biasa.
    }
    
    //==== menyimpan update category ==== 
    @RequestMapping(value = "/update", method = RequestMethod.POST) 
    public RedirectView saveUpdate(@RequestParam(required = true) Long id, String name){ //RequestParam disini kita tulis name inputannnya dan type datanya apa.
        this.categoryService.update(new Category(id, name));
        return new RedirectView("/admin/category/list", true); 
    }
        
    //==== menyimpan delete category ==== 
    @RequestMapping(value = "/delete", method = RequestMethod.GET) //diubah jdi GET krn pas error minta dlm bntuk GET
    public RedirectView deleteCategory(@RequestParam(required = true) Long id){ //Pake RequestParam klo ada kirim/minta data, disini kita tulis name dri inputannnya dan type datanya apa.
        this.categoryService.delete(new Category (id));
        //this.categoryService.delete(id);
        return new RedirectView("/admin/category/list", true); //klo ada back ke subfolder, ato ada ngolah database, nunjuk hlmnnya pke RedirectView biar datanya bisa ke view. Klo cm ngarah ke hlm apa pke return String bisa.
    }
    
    //==== menuju home admin ==== 
    @RequestMapping(value = "/home", method= RequestMethod.GET) 
    public RedirectView toHomeAdmin(){
        return new RedirectView("/admin/home", true);
    }
}
