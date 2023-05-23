package peaksoft.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Customer;
import peaksoft.repository.AgencyRepository;
import peaksoft.repository.CustomerRepository;
import peaksoft.service.CustomerService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public void updateCustomer(Long customerId, Customer customer) {
customerRepository.updateCustomer(customerId,customer);
    }

    @Override
    public void deleteCustomerByID(Long customerId) {
customerRepository.deleteCustomerByID(customerId);
    }

    @Override
    public void assignCustomerToAgency(Long customerId, Long agencyId) {

    }
}
