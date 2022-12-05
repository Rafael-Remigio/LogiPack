package org.rlpr.logipack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.*;

import org.rlpr.logipack.model.Encomenda;
import org.rlpr.logipack.repository.*;
import org.rlpr.logipack.repository.Mongo.EncomendaMongoRepository;
import  org.rlpr.logipack.model.Mongo.EncomendaMongo;

@Service
public class LoggingService {

    @Autowired
    private EncomendaRepository encomendaRepo;

    @Autowired
    private LocalizacaoRepository localizacaoRepo;

    //@Autowired
    //private EncomendaMongoRepository encomendaMongoRepository;


    public void insertEncomenda(String data) {
        
        try {

            //convert json to POJO
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Encomenda encomenda = mapper.readValue(data, Encomenda.class);

            //save first the package location
            localizacaoRepo.save(encomenda.getLocalizacao());

            //then save the package
            encomendaRepo.save(encomenda);            

            //test mongodb
            // encomendaMongoRepository.save(new EncomendaMongo());
        
        } catch (Exception e) {
            System.out.println(e );
        }

    }


    public void insertTransportador(String data) {
        
        System.out.printf("[T]  %s\n", data);
        //TODO: insert into db

    }
    
}
