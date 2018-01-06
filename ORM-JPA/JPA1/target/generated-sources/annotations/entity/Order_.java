package entity;

import entity.Orderline;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-25T08:57:00")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile ListAttribute<Order, Orderline> orderList;
    public static volatile SingularAttribute<Order, Long> id;

}