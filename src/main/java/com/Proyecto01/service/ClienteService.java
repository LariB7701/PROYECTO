package com.Proyecto01.service;

import com.Proyecto01.domain.Cliente;
import java.util.List;

public interface ClienteService {
    
    //Los métodos para poder hacer un CRUD
    //create Read Update Delete
    
    public List<Cliente> getClientes();
    
    
    public Cliente getCliente(Cliente cliente);
    
    public void save (Cliente cliente);
    
    public void delete (Cliente cliente);
    
}
