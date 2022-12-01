package com.Proyecto01.service;

import com.Proyecto01.dao.ClienteDao;
import com.Proyecto01.domain.Cliente;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    /* Autowired: Provoca que si el objeto ya etsá en memoria se usa ese,
    sino está en memoria se crea ese*/
    @Autowired
    private ClienteDao clienteDao;


    //Los métodos para poder hacer un CRUD
    //create Read Update Delete
    @Override
    public List<Cliente> getClientes() {

        return (List<Cliente>) clienteDao.findAll();

    }



    @Override
    public Cliente getCliente(Cliente cliente) {

        return clienteDao.findById(cliente.getIdCliente()).orElse(null);

    }

    @Override
    public void save(Cliente cliente) {


        //Si el idCliente es 0, lo inserta
        //Si tiene un valor hace el update de registro
        clienteDao.save(cliente);

    }

    @Override
    public void delete(Cliente cliente) {

        clienteDao.delete(cliente);

    }

   

}
