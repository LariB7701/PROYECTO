
package com.Proyecto01.service;

import com.Proyecto01.dao.UsuarioDao;
import com.Proyecto01.domain.Rol;
import com.Proyecto01.domain.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioService  implements UserDetailsService {
    
    //@Autowired Provoca que si el objeto ya esta en memoria no se crea y si no esta, se crea
    //Si no esta en mermoria s ecrea el objeto
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    //Los metodos para poder hacer un CRUD
    //create Read Update Delete
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     //se busca el usuario en la tabla de usuarios
     Usuario usuario = usuarioDao.findByUsername(username);
     
     if (usuario==null){ //No se encontro el usuario
         throw new UsernameNotFoundException(username);
     }
     
     //se carga los rol que tiene el usuario
     var roles = new ArrayList<GrantedAuthority>();
     
     for(Rol rol : usuario.getRoles()){ //Recorre la lista de roles del usuario
        roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        
     }
      //se retorna ña info de userDateails
      
      return new User(usuario.getUsername(),usuario.getPassword(),roles);
     
    }
    
    
}
