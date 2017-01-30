package mii.web.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mii.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user2
 */
@Repository("customerDAO")
@Transactional
public class CustomerDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(Customer customer){
        em.persist(customer);
    }
    
    public Customer getById(Long id){
        return em.find(Customer.class,id);
    }
    
    public List<Customer> getAll(){
    return em.createQuery("SELECT c FROM Customer c").getResultList();
    }
    
    public void update(Customer customer){
        em.merge(customer);
    }
    
    public void delete(Customer customer){
        em.remove(em.merge(customer)); 
    }
}
