package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Agency;
import peaksoft.exception.MyException;
import peaksoft.service.AgencyService;


@Controller
@RequestMapping("/agencies")
public class AgencyApi {
    private final AgencyService agencyService;
    @Autowired
    public AgencyApi(AgencyService agencyService) {
        this.agencyService = agencyService;
    }
    @GetMapping("/new")
    public String createAgency(Model model){
        model.addAttribute("newAgency",new Agency());
        return "agency/newAgency";
    }
    @PostMapping("/newAgency")
    public String save(@ModelAttribute("newAgency") Agency agency) throws MyException {
        agencyService.saveAgency(agency);
        return "redirect:/agencies";
    }
    @GetMapping
    public String getAllAgencies(Model model){
        model.addAttribute("agencies",agencyService.getAllAgency());
        return "agency/mainPage";
    }
    @GetMapping("/{agencyId}/edit")
    public String getById(@PathVariable Long agencyId,Model model) throws MyException {
        model.addAttribute("agency",agencyService.getAgencyById(agencyId));
        return "agency/updateAgency";
    }
    @PutMapping("/update/{agencyId}")
    public String update(@PathVariable Long agencyId, @ModelAttribute("agency")Agency agency){
        agencyService.updateAgency(agencyId, agency);
        return "redirect:/agencies";
    }
    @DeleteMapping("/{agencyId}")
    public String delete(@PathVariable Long agencyId){
        agencyService.deleteAgency(agencyId);
        return "redirect:/agencies";
    }
}
