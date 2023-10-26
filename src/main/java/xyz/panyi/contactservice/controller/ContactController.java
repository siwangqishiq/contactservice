package xyz.panyi.contactservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.panyi.contactservice.model.Contact;
import xyz.panyi.contactservice.service.ContactService;

import java.util.List;

@RestController
public class ContactController {

    public static final int CONTACT_MAX_COUNT = 5000000;
//    public static final int CONTACT_MAX_COUNT = 500;

    @Autowired
    private ContactService contactService;


    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/contacts")
    public List<Contact> contacts(@RequestParam(name = "count") int count) {
        return contactService.genContactList(count);
    }

}//end class
