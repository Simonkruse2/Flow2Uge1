package entity;

import entity.BiOneToManyCustomers4;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-18T11:49:51")
@StaticMetamodel(BiOneToManyAddresses4.class)
public class BiOneToManyAddresses4_ { 

    public static volatile SingularAttribute<BiOneToManyAddresses4, String> city;
    public static volatile SingularAttribute<BiOneToManyAddresses4, String> street;
    public static volatile SingularAttribute<BiOneToManyAddresses4, Integer> id;
    public static volatile SingularAttribute<BiOneToManyAddresses4, BiOneToManyCustomers4> customer;

}