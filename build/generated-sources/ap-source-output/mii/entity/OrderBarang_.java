package mii.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mii.entity.Customer;
import mii.entity.OrderDetail;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-16T05:29:45")
@StaticMetamodel(OrderBarang.class)
public class OrderBarang_ { 

    public static volatile SingularAttribute<OrderBarang, String> waktu;
    public static volatile SingularAttribute<OrderBarang, String> status_order;
    public static volatile SingularAttribute<OrderBarang, OrderDetail> orderDetail;
    public static volatile SingularAttribute<OrderBarang, Long> id;
    public static volatile SingularAttribute<OrderBarang, Date> tanggal;
    public static volatile SingularAttribute<OrderBarang, Integer> total_bayar;
    public static volatile SingularAttribute<OrderBarang, Customer> customer;

}