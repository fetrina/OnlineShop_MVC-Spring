package mii.web.service;

import java.util.List;
import mii.entity.Customer;
import mii.web.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user2
 */
@Service ("customerService")
public class CustomerService {
    private CustomerDAO customerDAO;
    
    public List<Customer> getAll(){
        return this.customerDAO.getAll();
    }
    
    public CustomerDAO getCustomerDAO(){
        return customerDAO;
    }
    
    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }
    
    //===skrip tmbhn===
    public void insert(Customer customer){
        getCustomerDAO().insert(customer);
    } 
    
    public Customer getById(Long id){
        return this.customerDAO.getById(id);
    }
    
    public void update(Customer customer){
        getCustomerDAO().update(customer);
    }
    
    public void delete(Customer customer){
        getCustomerDAO().delete(customer);
    }
}
