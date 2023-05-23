package peaksoft.service;

import peaksoft.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    Customer getCustomerById(Long customerId);
    List<Customer> getAllCustomers();
    void updateCustomer(Long customerId,Customer customer);
    void deleteCustomerByID(Long customerId);
    void assignCustomerToAgency(Long customerId,Long agencyId);
}
