package peaksoft.repository;

import peaksoft.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    void saveCustomer(Customer customer);
    Customer getCustomerById(Long customerId);
    List<Customer> getAllCustomers();
    void updateCustomer(Long customerId,Customer customer);
    void deleteCustomerByID(Long customerId);
    void assignCustomerToAgency(Long customerId,Long agencyId);
}
