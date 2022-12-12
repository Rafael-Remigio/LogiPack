package org.rlpr.logipack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.rlpr.logipack.model.*;
import org.rlpr.logipack.model.Mongo.EncomendaMongo;
import org.rlpr.logipack.service.EncomendaService;

import java.util.List;


@RestController
public class EncomendaController {
    
    @Autowired
    private EncomendaService encomendaService;
    
    @GetMapping("/encomendas")
    public List<Encomenda> getAllEncomendas() {
        return encomendaService.getAllEncomendas();
    }

    @GetMapping("/encomendas/{id}")
    public Encomenda getEncomendaById(@PathVariable int id) {
        return encomendaService.getEncomendaById(id);
    }

    @GetMapping("/encomendas/{id}/details")
    public EncomendaMongo getEncomendaDetailsById(@PathVariable int id) {
        return encomendaService.getEncomendaDetailsById(id);
    }

    @PutMapping("cliente/{id}/confirmar/{packageId}")
    public Encomenda updateConfirmacao(@PathVariable int packageId) {
        return encomendaService.updateConfirmacao(packageId);
    }

    @GetMapping("/cliente/{id}/encomendas")
    public List<Encomenda> getEncomendasByClienteId(@PathVariable int id) {
        return encomendaService.getEncomendasByClienteId(id);
    }

    @GetMapping("/cliente/{id}/notificacoes")
    public List<Encomenda> getNotificacoesByClienteId(@PathVariable int id) {
        return encomendaService.getEncomendasByClienteId(id);
    }









    @PutMapping("estados/encomendas/{id}")
    public Encomenda updateEstado(@PathVariable int id, @RequestBody EncomendaEstado estado) {
        return encomendaService.updateEstado(estado, id);
    }

}
