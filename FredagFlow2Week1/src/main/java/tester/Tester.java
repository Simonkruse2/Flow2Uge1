/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entities.Customer;
import entities.OrderLine;
import entities.Orderm;
import facades.Facade;

/**
 *
 * @author simon
 */
public class Tester {

    public static void main(String[] args) {
        Facade facade = new Facade();
        Customer c1 = facade.addCustomer("Simon", "Kruse");
        facade.addCustomer("Martin", "Døi");

        facade.createItemType("Kebab", "Boks", 45);

        Orderm orderm = new Orderm(facade.getCustomer(1));
        facade.createOrderm(facade.getCustomer(1), orderm);

        OrderLine ol = new OrderLine(5, facade.getItemType(1));

        facade.addOrderLine(orderm, ol);

    }
}
