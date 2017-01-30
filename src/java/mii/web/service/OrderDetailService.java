package mii.web.service;

import java.util.List;
import mii.entity.OrderDetail;
import mii.web.dao.OrderBarangDAO;
import mii.web.dao.OrderDetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user2
 */
@Service ("orderDetailService")
public class OrderDetailService {
    private OrderDetailDAO orderDetailDAO;
    private OrderBarangDAO orderBarangDAO;

    public OrderBarangDAO getOrderBarangDAO() {
        return orderBarangDAO;
    }

    @Autowired
    public void setOrderBarangDAO(OrderBarangDAO orderBarangDAO) {
        this.orderBarangDAO = orderBarangDAO;
    }

    public OrderDetailDAO getOrderDetailDAO(){
        return orderDetailDAO;
    }
    
    @Autowired
    public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO){
        this.orderDetailDAO = orderDetailDAO;
    }
    
    public List<OrderDetail> getAll(){
        return this.orderDetailDAO.getAll();
    }
    
    //tambahan
    public List<OrderDetail> getDetailByIdOrder(Long id){
        return this.orderDetailDAO.getDetailByIdOrder(id);
    }
        
    public OrderDetail getById(Long id){
        return this.orderDetailDAO.getById(id);
    }
        
    public void insert(OrderDetail orderDetail){
        getOrderDetailDAO().insert(orderDetail);
    } 
    
    public void update(OrderDetail orderDetail){
        orderDetail.setOrderBarang(getOrderBarangDAO().getById(orderDetail.getOrderBarang().getId())); //agar name di tabel category tdk brubah NULL, ktika kt update category_id di tabel buku.
        getOrderDetailDAO().update(orderDetail);
    }
    
    public void delete(OrderDetail orderDetail){
        getOrderDetailDAO().delete(orderDetail);
    }

}
