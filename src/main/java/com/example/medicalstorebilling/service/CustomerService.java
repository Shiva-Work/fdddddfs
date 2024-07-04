package com.example.medicalstorebilling.service;

import com.example.medicalstorebilling.entity.Customers;
import com.example.medicalstorebilling.repository.Customerint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private Customerint cus;

    public int add(Customers cust)
    {
        Customers cs=cus.save(cust);
        System.out.println("================================="+"\n"+"=========================");
        System.out.println("==========================");
        int k=cus.findId(cust.getName(), cust.getPhone(),cust.getEmail());
        System.out.println(k+"============================================================================================================");

        return  k;
    }

    public List<Customers> getDataCust()
    {
        List<Customers> li=cus.findAll();

        return li;
    }
}
