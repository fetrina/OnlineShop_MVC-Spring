package mii.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mii.entity.Buku;
import mii.entity.OrderBarang;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-16T05:29:45")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, Buku> buku;
    public static volatile SingularAttribute<OrderDetail, Integer> subtotal;
    public static volatile SingularAttribute<OrderDetail, Integer> qty;
    public static volatile SingularAttribute<OrderDetail, OrderBarang> orderBarang;
    public static volatile SingularAttribute<OrderDetail, Long> id;

}