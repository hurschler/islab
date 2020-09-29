package ch.hslu.islab.productservice.controller;

import java.security.Principal;
import org.springframework.ui.Model;

public class CustomerController {

    // @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    // @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
        model.addAttribute("customers", "customer");
        model.addAttribute("username", principal.getName());
        return "customers";
    }

}
