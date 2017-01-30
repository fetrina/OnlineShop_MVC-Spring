package mii.web.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mii.entity.Customer;
import mii.entity.Users;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user2
 */
@Repository("userDAO")
@Transactional
public class UsersDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public Users getById(Long id){
        return em.find(Users.class,id);
    }
    
    public List<Users> getAll(){
    return em.createQuery("SELECT u FROM Users u").getResultList();
    }
    
    public void insert(Users users){
        em.persist(users);
    }
    
    public void update(Users users){
        em.merge(users);
    }
    
    public void delete(Users users){
        em.remove(em.merge(users)); 
    }
}
