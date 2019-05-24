package com.ixanaui.config;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mkyong.users.dao.UsuarioDao;
import com.mkyong.users.model.Usuario;


public class MyUserDetailsService implements UserDetailsService {
	
	UsuarioDao usuarioDao;

public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //Retrieve the user from wherever you store it, e.g. a database 
    Usuario user = usuarioDao.findByUserName(username); 
    if (user == null) {
        throw new UsernameNotFoundException("Invalid username/password.");
    }
    Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
    return new User(user.getUsername(), user.getPassword(), authorities);
}

public UsuarioDao getUsuarioDao() {
	return usuarioDao;
}

public void setUsuarioDao(UsuarioDao usuarioDao) {
	this.usuarioDao = usuarioDao;
}



}
