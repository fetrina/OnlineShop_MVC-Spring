package mii.web.service;

import java.util.Date;
import java.util.List;
import mii.entity.OrderBarang;
import mii.web.dao.CustomerDAO;
import mii.web.dao.OrderBarangDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user2
 */
@Service ("orderBarangService")
public class OrderBarangService {
    private OrderBarangDAO orderBarangDAO;
    private CustomerDAO customerDAO;

    public OrderBarangDAO getOrderBarangDAO(){
        return orderBarangDAO;
    }
    
    @Autowired
    public void setOrderBarangDAO(OrderBarangDAO orderBarangDAO){
        this.orderBarangDAO = orderBarangDAO;
    }    
        
    public List<OrderBarang> getAll(){
        return this.orderBarangDAO.getAll();
    }
    
    public OrderBarang getById(Long id){
        return this.orderBarangDAO.getById(id);
    }
    
    public void insert(OrderBarang orderBarang){
        orderBarang.setTanggal(new Date()); //new Date() itu untuk mengambil current date
        getOrderBarangDAO().insert(orderBarang);
    } 
    
    //ini belum beres updatenya
    public void update(OrderBarang orderBarang){
        orderBarang.setCustomer(getCustomerDAO().getById(orderBarang.getCustomer().getId())); //agar name di tabel category tdk brubah NULL, ktika kt update category_id di tabel buku.
        getOrderBarangDAO().update(orderBarang);
    }
    
    public void delete(OrderBarang orderBarang){
        getOrderBarangDAO().delete(orderBarang);
    }

    //==== Tambahan krn u update buku biar g mmpgruh
    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }
    
    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
