package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Agency;
import peaksoft.entity.Customer;
import peaksoft.exception.MyException;
import peaksoft.repository.CustomerRepository;
import peaksoft.service.AgencyService;
@Controller
@RequestMapping("/customers/{houseId}")
@RequiredArgsConstructor
public class CustomerApi {
    private final CustomerRepository customerRepository;

    @GetMapping("/new")
    public String createAgency(@PathVariable Long houseId, Model model){
        model.addAttribute("houseId");
        model.addAttribute("newCustomer",new Customer());
        return "/customers/newCustomer";
    }
    @PostMapping("/newCustomer")
    public String save(@ModelAttribute("newCustomer") Customer customer) throws MyException {
        customerRepository.saveCustomer(customer);
        return "redirect:/agencies";
    }
    @GetMapping
    public String getAllCustomer(Model model){
        model.addAttribute("customers",customerRepository.getAllCustomers());
        return "/customers/mainPage";
    }
    @GetMapping("/{customerId}/edit")
    public String getById(@PathVariable Long customerId, Model model) throws MyException {
        model.addAttribute("customer",customerRepository.getCustomerById(customerId));
        return "customer/updateCustomer";
    }
    @PutMapping("/update/{customerId}")
    public String update(@PathVariable Long customerId, @ModelAttribute("customer")Customer customer){
        customerRepository.updateCustomer(customerId, customer);
        return "redirect:/customers";
    }
    @DeleteMapping("/{customerId}")
    public String delete(@PathVariable Long customerId){
        customerRepository.deleteCustomerByID(customerId);
        return "redirect:/customers";
    }
}
