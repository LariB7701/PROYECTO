package com.Proyecto01.service;

import com.Proyecto01.dao.ToursDao;
import com.Proyecto01.domain.Tours;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ToursServiceImpl implements ToursService {

    /* Autowired: Provoca que si el objeto ya etsá en memoria se usa ese,
    sino está en memoria se crea ese*/
    @Autowired
    private ToursDao toursDao;


    //Los métodos para poder hacer un CRUD
    //create Read Update Delete
    @Override
    public List<Tours> getTourss() {

        return (List<Tours>) toursDao.findAll();

    }



    @Override
    public Tours getTours(Tours tours) {

        return toursDao.findById(tours.getIdTours()).orElse(null);

    }

    @Override
    public void save(Tours tours) {


        //Si el idTours es 0, lo inserta
        //Si tiene un valor hace el update de registro
        toursDao.save(tours);

    }

    @Override
    public void delete(Tours tours) {

        toursDao.delete(tours);

    }

   

}
