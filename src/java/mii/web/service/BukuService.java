package mii.web.service;

import java.util.List;
import mii.entity.Buku;
import mii.web.dao.BukuDAO;
import mii.web.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user2
 */
@Service ("bukuService")
public class BukuService {
    private BukuDAO bukuDAO;
    private CategoryDAO categoryDAO;
    
    public List<Buku> getAll(){
        return this.bukuDAO.getAll();
    }
    
    public BukuDAO getBukuDAO(){
        return bukuDAO;
    }
    
    @Autowired
    public void setBukuDAO(BukuDAO bukuDAO){
        this.bukuDAO = bukuDAO;
    }
    
    public void insert(Buku buku){
        getBukuDAO().insert(buku);
    } 
    
      public Buku getById(Long id){
        return this.bukuDAO.getById(id);
    }
    
    public void update(Buku buku){
        buku.setCategory(getCategoryDAO().getById(buku.getCategory().getId())); //agar name di tabel category tdk brubah NULL, ktika kt update category_id di tabel buku.
        getBukuDAO().update(buku);
    }
    
    public void delete(Buku buku){
        getBukuDAO().delete(buku);
    }

    //==== Tambahan krn u update buku biar g mmpgruh
    public CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }
    @Autowired
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
    
    //==== Search Buku =====
    //dipakai oleh controller client
     public List<Buku> searchBuku(String search){
        return this.bukuDAO.searchBuku(search);
    }
    
    //dipakai oleh controller client
     public List<Buku> searchBukuByPrice(int harga){
        return this.bukuDAO.searchBukuByPrice(harga);
    }
     
    //dipakai oleh controller client
    public List<Buku> searchBukuByCategory(Long category){
        return this.bukuDAO.searchBukuByCategory(category);
    }  
}
