package mii.web.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mii.entity.OrderBarang;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user2
 */
@Repository("orderBarangDAO")
@Transactional
public class OrderBarangDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(OrderBarang orderBarang){
        em.persist(orderBarang); //ada jg yg pke merge. tpi ini pke persist g knp2
    }
    
    public OrderBarang getById(Long id){
        return em.find(OrderBarang.class,id);
    }
    
    public List<OrderBarang> getAll(){
    return em.createQuery("SELECT o FROM OrderBarang o").getResultList();
    }
    
    public void update(OrderBarang orderBarang){
        em.merge(orderBarang);
    }
    
    public void delete(OrderBarang orderBarang){
        em.remove(em.merge(orderBarang)); 
    }
}
