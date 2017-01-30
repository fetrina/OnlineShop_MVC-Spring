package mii.web.controller;

import mii.entity.Buku;
import mii.entity.Category;
import mii.web.service.BukuService;
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
@RequestMapping("/admin/buku")
public class BukuController {
    
    private BukuService bukuService;
    private CategoryService categoryService;
    
    public CategoryService getCategoryService() {
        return categoryService;
    }
    
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    public BukuService getBukuservice() {
        return bukuService;
    }

    @Autowired
    public void setBukuservice(BukuService bukuService) {
        this.bukuService = bukuService;
    }
    
    //==== tampilkan semua data buku ====
    @RequestMapping(value = "/list", method= RequestMethod.GET) 
    public String getAllBuku(Model model){
        model.addAttribute("books", this.bukuService.getAll());
        return "buku"; 
    }
    
    @RequestMapping(value = "/forminsert", method= RequestMethod.GET) // didalam value itu url yg kita panggil nantinya
    public String formInsertBuku(Model model){
        model.addAttribute("categories", this.categoryService.getAll()); //untuk nampilin combobox category di insert_buku.jsp
        return "insert_buku"; //ini sesuai nama jspnya, misal buku.jsp
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST) 
    public RedirectView getData(@RequestParam(required = true) String isbn, String judul, String penulis, String penerbit, 
        String tahun_terbit, String jenis_cover, String jml_hal, String bahasa, String deskripsi, String gambar, int harga, 
        int stok, Long category){ //request param disini sesuai name di inputannya
            this.bukuService.insert(new Buku(isbn, judul, penulis, penerbit, tahun_terbit, jenis_cover, jml_hal, bahasa, 
            deskripsi, gambar, harga, stok, new Category(category)));
            return new RedirectView("/admin/buku/list", true); 
    }
    
    //==== menuju edit buku ====
    @RequestMapping(value = "/edit", method= RequestMethod.GET) 
    public String formEditBuku(@RequestParam(required = true) Long id, Model model){
        model.addAttribute("buku",  this.bukuService.getById(id)); //"category" itu dpke ntar di jstl.
        model.addAttribute("categories", this.categoryService.getAll()); //agar bisa nmpilin combo box category
        return "edit_buku";  
    }
    
    //==== menyimpan update buku ==== 
    @RequestMapping(value = "/update", method = RequestMethod.POST) 
    public RedirectView saveUpdate(@RequestParam(required = true) Long id, String isbn, String judul, String penulis, String penerbit, 
        String tahun_terbit, String jenis_cover, String jml_hal, String bahasa, String deskripsi, String gambar, 
        int harga, int stok, Long category){ //RequestParam disini kita tulis name inputannnya dan type datanya apa.
           
            //Buku buku1 = new Buku(id, isbn, judul, penulis, penerbit, tahun_terbit, jenis_cover,
            //jml_hal, bahasa, deskripsi, gambar, harga, stok, new Category(category));
            //this.bukuService.update(buku1);
            //atao
            this.bukuService.update(new Buku(id, isbn, judul, penulis, penerbit, tahun_terbit, jenis_cover,
            jml_hal, bahasa, deskripsi, gambar, harga, stok, new Category(category)));
            return new RedirectView("/admin/buku/list", true); 
    }
    
        
    //==== menyimpan delete buku ==== 
    @RequestMapping(value = "/delete", method = RequestMethod.GET) 
    public RedirectView deleteBuku(@RequestParam(required = true) Long id){ //Pake RequestParam klo ada kirim/minta data, disini kita tulis name dri inputannnya dan type datanya apa.
        this.bukuService.delete(new Buku (id));
        //this.bukuService.delete(id);
        return new RedirectView("/admin/buku/list", true); 
    }
    
    @RequestMapping(value = "/home", method= RequestMethod.GET) 
    public RedirectView toHomeAdmin(){
        return new RedirectView("/admin/home", true);
    }
    
    
}
