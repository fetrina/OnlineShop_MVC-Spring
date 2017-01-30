package mii.web.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mii.entity.OrderDetail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user2
 */
@Repository("orderDetailDAO")
@Transactional
public class OrderDetailDAO {
    @PersistenceContext
    private EntityManager em;
    
    public OrderDetail getById(Long id){
        return em.find(OrderDetail.class,id);
    }
    
    public List<OrderDetail> getAll(){
    return em.createQuery("SELECT o FROM OrderDetail o").getResultList();
    }
    
    public List<OrderDetail> getDetailByIdOrder(Long id){
        return em.createQuery("SELECT o FROM OrderDetail o WHERE o.orderBarang.id LIKE '%"+id+"%' ").getResultList();
    }
    
    
    public void insert(OrderDetail orderDetail){
        em.persist(orderDetail); //ada jg yg pke merge. tpi ini pke persist g knp2
    }
    
    public void update(OrderDetail orderDetail){
        em.merge(orderDetail);
    }
    
    public void delete(OrderDetail orderDetail){
        em.remove(em.merge(orderDetail)); 
    }
}
