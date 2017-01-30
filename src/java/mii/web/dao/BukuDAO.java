package mii.web.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mii.entity.Buku;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user2
 */
@Repository("bukuDAO")
@Transactional
public class BukuDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(Buku buku){
        em.persist(buku); //ada jg yg pke merge. tpi ini pke persist g knp2
    }
    
    public Buku getById(Long id){
        return em.find(Buku.class,id);
    }
    
    public List<Buku> getAll(){
        return em.createQuery("SELECT b FROM Buku b").getResultList();
    }
    
    public void update(Buku buku){
        em.merge(buku);
    }
    
    public void delete(Buku buku){
        em.remove(em.merge(buku)); 
    }
    
    //==== untuk search dari page Client ====
    public List<Buku> searchBuku(String search){
        return em.createQuery("SELECT b FROM Buku b where b.judul LIKE '%"+search+"%' ").getResultList();
    }
    
    public List<Buku> searchBukuByPrice(int harga){
        return em.createQuery("SELECT b FROM Buku b where b.harga LIKE '%"+harga+"%' ").getResultList();
    }
    
    public List<Buku> searchBukuByCategory(Long category){
        return em.createQuery("SELECT b FROM Buku b where b.category.id LIKE '%"+category+"%' ").getResultList();
        //klo pke combobox where nya pake id kyk ini --> b.category.id
        //klo textfield wherenya pke name kyk ini --> b.category.name   //agar searchnya bisa nyari berdasar nama category
    }
}
