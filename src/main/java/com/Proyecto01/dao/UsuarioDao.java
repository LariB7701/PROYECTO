
package com.Proyecto01.dao;

import com.Proyecto01.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao extends JpaRepository<Usuario,Long> {
    
    public Usuario findByUsername(String username);
    
    
   }
