package com.example.demo.services;

import com.example.demo.dao.CartItemsRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomersRepository;
import com.example.demo.entities.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

import static com.example.demo.entities.Status.ordered;

@Service
public class CheckOutServiceImpl implements CheckOutService{

    private CustomersRepository customersRepository;
    private CartRepository cartRepository;




    public CheckOutServiceImpl(CustomersRepository customersRepository, CartRepository cartRepository) {
        this.customersRepository = customersRepository;
        this.cartRepository = cartRepository;

    }
    
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //retrieve the cart and customer info from dto
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();



        //generate tracking number and change status to ordered
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(ordered);

        //populate every cartItem and add it to the cart and set the item to the cart to create a relationship between cart and cartitems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> {
            cart.add(item);
            item.setCart(cart);
        });




        //set a relationship between customer and the cart
//        cart.setCartItem(purchase.getCartItems());
        cart.setCustomer(purchase.getCustomer());

        //populate customer with cart

//        customer.add(cart);

        //save the database
        customersRepository.save(customer);
        cartRepository.save(cart);

        
        //return response


        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //creating a unique id that is random and hard to guess (a Universally unique Identifier) UUID
        return UUID.randomUUID().toString();
    }
}
