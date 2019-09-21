package entity;

import entity.BiOneToManyAddresses4;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-18T11:49:51")
@StaticMetamodel(BiOneToManyCustomers4.class)
public class BiOneToManyCustomers4_ { 

    public static volatile SingularAttribute<BiOneToManyCustomers4, String> firstName;
    public static volatile SingularAttribute<BiOneToManyCustomers4, String> lastName;
    public static volatile ListAttribute<BiOneToManyCustomers4, BiOneToManyAddresses4> addresses;
    public static volatile SingularAttribute<BiOneToManyCustomers4, Integer> id;

}