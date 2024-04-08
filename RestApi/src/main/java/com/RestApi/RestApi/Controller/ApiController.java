package com.RestApi.RestApi.Controller;

import com.RestApi.RestApi.Models.Client;
import com.RestApi.RestApi.Models.Stylist;
import com.RestApi.RestApi.Repository.ClientRepository;
import com.RestApi.RestApi.Repository.StylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    StylistRepository stylistRepository;

    @GetMapping(value = "/")
    public String index() {
        return "<h2>Hello</h2>\n" +
                "Check our stylists: <a href=\"/getStylists\">stylists</a><br>\n" +
                "Check our clients: <a href=\"/getClients\">clients</a><br>";
    }

    @GetMapping(value ="/getClients")
    public List<Client> GetClients() {
        return clientRepository.findAll();
    }

    @GetMapping(value = "/getStylists")
    public List<Stylist> GetStylists() {
        return stylistRepository.findAll();
    }

    @PostMapping(value = "/addStylist")
    public String addNewStylist(@RequestBody Stylist stylist) {
        stylistRepository.save(stylist);
        return "Saved...";
    }

    @PostMapping(value = "/addClient")
    public String addNewClient(@RequestBody Client client){
        clientRepository.save(client);
        return "Saved...";
    }


    @PutMapping(value = "/updateStylist/{id}")
    public String updateStylist(@PathVariable long id, @RequestBody Stylist stylist) {
        Stylist updatedStylist = stylistRepository.findById(id).get();
        updatedStylist.setName(stylist.getName());
        stylistRepository.save(updatedStylist);
        return "Updated...";
    }
    @PutMapping(value = "/updateClient/{id}")
    public String updateClient(@PathVariable long id, @RequestBody Stylist stylist) {
        Client updatedClient = clientRepository.findById(id).get();
        updatedClient.setName(stylist.getName());
        clientRepository.save(updatedClient);
        return "Updated...";
    }
    @DeleteMapping(value ="/deleteStylist/{id}" )
    public String deleteStylist(@PathVariable long id){
        Stylist deleteStylist = stylistRepository.findById(id).get();
        stylistRepository.delete(deleteStylist);
        return "Delete user with the id: " + id;
    }
    @DeleteMapping(value ="/deleteClient/{id}" )
    public String deleteClient(@PathVariable long id){
        Client deleteclient = clientRepository.findById(id).get();
        clientRepository.delete(deleteclient);
        return "Delete user with the id: " + id;
    }
}
