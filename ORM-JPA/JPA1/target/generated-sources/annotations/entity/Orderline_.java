package entity;

import entity.ItemType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-25T08:57:00")
@StaticMetamodel(Orderline.class)
public class Orderline_ { 

    public static volatile SingularAttribute<Orderline, ItemType> item;
    public static volatile SingularAttribute<Orderline, Integer> quantity;
    public static volatile SingularAttribute<Orderline, Long> id;

}