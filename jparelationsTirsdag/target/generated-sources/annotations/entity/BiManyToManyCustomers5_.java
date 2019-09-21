package entity;

import entity.BiManyToManyAddresses5;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-18T11:49:51")
@StaticMetamodel(BiManyToManyCustomers5.class)
public class BiManyToManyCustomers5_ { 

    public static volatile SingularAttribute<BiManyToManyCustomers5, String> firstName;
    public static volatile SingularAttribute<BiManyToManyCustomers5, String> lastName;
    public static volatile ListAttribute<BiManyToManyCustomers5, BiManyToManyAddresses5> addresses;
    public static volatile SingularAttribute<BiManyToManyCustomers5, Integer> id;

}