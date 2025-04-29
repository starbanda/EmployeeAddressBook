package com.capgemini.EmployeeAddressBook.Controller;

import com.capgemini.EmployeeAddressBook.Model.UserData;
import com.capgemini.EmployeeAddressBook.Repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userData")
public class FormController {

    @Autowired
    private UserDataRepository userDataRepository;

    @ModelAttribute("userData")
    public UserData setUpUserForm() {
        return new UserData();
    }

    @GetMapping("/")
    public String showStep1Form(Model model) {
        return "step1";
    }

    @GetMapping("/step2")
    public String showStep2Form(Model model) {
        return "step2";
    }

    @GetMapping("/step3")
    public String showStep3Form(Model model) {
        return "step3";
    }

    @GetMapping("/summary")
    public String showSummary(Model model) {
        return "summary";
    }

    @PostMapping("/step1")
    public String processStep1(@ModelAttribute("userData") UserData userData) {
        return "redirect:/step2";
    }

    @PostMapping("/step2")
    public String processStep2(@ModelAttribute("userData") UserData userData) {
        return "redirect:/step3";
    }

    @PostMapping("/step3")
    public String processStep3(@ModelAttribute("userData") UserData userData) {
        // Save data to the database
        userDataRepository.save(userData);
        return "redirect:/summary";
    }
}
