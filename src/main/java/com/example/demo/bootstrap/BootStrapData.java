package com.example.demo.bootstrap;


import com.example.demo.dao.CustomersRepository;
import com.example.demo.dao.DivisionsRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomersRepository customersRepository;
    private final DivisionsRepository divisionsRepository;

    public BootStrapData(CustomersRepository customersRepository, DivisionsRepository divisionsRepository) {
        this.customersRepository = customersRepository;
        this.divisionsRepository = divisionsRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.customersRepository.count() <= 6L) {
            Division first = divisionsRepository.findById(2L).orElse(null);
            Customer jorge = new Customer("Jorge", "Chavez", "503-333-5555", "1339 Hemlock way", "97303", first);
            customersRepository.save(jorge);

            Division second = divisionsRepository.findById(3L).orElse(null);
            Customer mari = new Customer("Maricruz", "Chavez", "971-555-3333", "4841 Montana St", "97317", second);
            customersRepository.save(mari);

            Division third = divisionsRepository.findById(4L).orElse(null);
            Customer luna = new Customer("Luna", "Chavez", "541-555-3355", "318 Bark Rd", "97305", third);
            customersRepository.save(luna);

            Division fourth = divisionsRepository.findById(5L).orElse(null);
            Customer reign = new Customer("Reign", "Storm", "1-800-222-3333", "777 Energy Dr", "88653", fourth);
            customersRepository.save(reign);

            Division fifth = divisionsRepository.findById(6L).orElse(null);
            Customer ghost = new Customer("Casper", "Ghost", "800-000-0000", "333 Halloween Ct", "12345", fifth);
            customersRepository.save(ghost);
        }
    }

}
