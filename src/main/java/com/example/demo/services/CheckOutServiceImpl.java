package com.example.demo.services;

import com.example.demo.dao.CustomersRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Status;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckOutServiceImpl implements CheckOutService{

    private CustomersRepository customersRepository;


    public CheckOutServiceImpl(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }
    
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //retrieve the cart and customer info from dto
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();



        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //populate CART with CARTItems
        Set<CartItem> cartItems = purchase.getCartItem();
        cartItems.forEach(item -> cart.add(item));

        //POPULATE CART with cartItem and customer
        cart.setCartItem(purchase.getCartItem());
        cart.setCustomer(purchase.getCustomer());

        //populate customer with cart

        customer.add(cart);
        cart.setStatus(Status.ordered);
        //save the database
        customersRepository.save(customer);
        
        //return response


        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //creating a unique id that is random and hard to guess (a Universally unique Identifier) UUID
        return UUID.randomUUID().toString();
    }
}
