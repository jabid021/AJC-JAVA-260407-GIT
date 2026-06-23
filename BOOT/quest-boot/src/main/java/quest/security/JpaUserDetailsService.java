package quest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import quest.model.Personne;
import quest.service.PersonneService;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private PersonneService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personne personne = this.service.getByLogin(username);

        if (personne == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        return User.builder()
            .username(username)
            .password(personne.getPassword())
            .build()
        ;
    }
}
