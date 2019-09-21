package entity;

import entity.UniOneToManyAddresses3;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-18T11:49:51")
@StaticMetamodel(UniOneToManyCustomers3.class)
public class UniOneToManyCustomers3_ { 

    public static volatile SingularAttribute<UniOneToManyCustomers3, String> firstName;
    public static volatile SingularAttribute<UniOneToManyCustomers3, String> lastName;
    public static volatile ListAttribute<UniOneToManyCustomers3, UniOneToManyAddresses3> addresses;
    public static volatile SingularAttribute<UniOneToManyCustomers3, Integer> id;

}