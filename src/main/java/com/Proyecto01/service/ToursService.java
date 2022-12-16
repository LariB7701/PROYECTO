package com.Proyecto01.service;

import com.Proyecto01.domain.Tours;
import java.util.List;

public interface ToursService {
    
    //Los métodos para poder hacer un CRUD
    //create Read Update Delete
    
    public List<Tours> getTourss();
    
    
    public Tours getTours(Tours tours);
    
    public void save (Tours tours);
    
    public void delete (Tours tours);
    
}
