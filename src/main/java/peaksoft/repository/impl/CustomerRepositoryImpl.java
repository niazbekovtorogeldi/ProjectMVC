package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.entity.Customer;
import peaksoft.exception.MyException;
import peaksoft.repository.CustomerRepository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Autowired
    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return entityManager.createQuery("select c from Customer  c where c.id=?",Customer.class).setParameter("id",customerId).getSingleResult();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("select c from Customer c",Customer.class).getResultList();
    }

    @Override
    public void updateCustomer(Long customerId, Customer customer) {
        try {
            boolean isEmpty = false;
            for (Customer customer1: getAllCustomers()) {
                if (Objects.equals(customer1.getId(), customerId)) {
                    isEmpty = true;
                }
            }
            if (isEmpty) {
               Customer customer2= entityManager.find(Customer.class, customerId);
                customer2.setName(customer.getName());
                customer2.setSurName(customer.getSurName());
                customer2.setEmail(customer.getEmail());
                customer2.setGender(customer.getGender());
                customer2.setPhoneNumber(customer.getPhoneNumber());
                customer2.setDateOfBirth(customer.getDateOfBirth());
                entityManager.merge(customer2);
            } else {
                throw new MyException("Agency by ID : " + customerId+ " not found!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void deleteCustomerByID(Long customerId) {
        Customer customer = entityManager.find(Customer.class,customerId);
        entityManager.remove(customer);
    }

    @Override
    public void assignCustomerToAgency(Long customerId, Long agencyId) {


    }
}
