package mii.web.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mii.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user2
 */
@Repository("categoryDAO")
@Transactional//cb ini di hapus
public class CategoryDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(Category category){
        em.persist(category);
    }
    
    public Category getById(Long id){
        return em.find(Category.class,id);
    }
    
    public List<Category> getAll(){
        return em.createQuery("SELECT c FROM Category c").getResultList();
    }
    
    public void update(Category category){
        em.merge(category);
    }
    
    public void delete(Category category){
        //em.remove(category); //klo gni doang bkl error meski di bkin GET di method deleteCategory pada categoryController.java
        em.remove(em.merge(category)); 
    }
}
