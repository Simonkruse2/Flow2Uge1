package entity;

import entity.BiManyToManyCustomers5;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-18T11:49:51")
@StaticMetamodel(BiManyToManyAddresses5.class)
public class BiManyToManyAddresses5_ { 

    public static volatile SingularAttribute<BiManyToManyAddresses5, String> city;
    public static volatile SingularAttribute<BiManyToManyAddresses5, String> street;
    public static volatile SingularAttribute<BiManyToManyAddresses5, Integer> id;
    public static volatile ListAttribute<BiManyToManyAddresses5, BiManyToManyCustomers5> customers;
    public static volatile SingularAttribute<BiManyToManyAddresses5, BiManyToManyCustomers5> customer;

}