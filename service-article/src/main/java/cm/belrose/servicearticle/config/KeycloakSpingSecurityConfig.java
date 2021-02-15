package cm.belrose.servicearticle.config;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class KeycloakSpingSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    /**
     * Cette methode de Spring specifie ou Spring security trouvera les utilisateurs et leurs  roles
     * dans ce cas de figure, c'est keycloak qui est spécifié
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        //spécifie que l'accès à cette ressource demande a s'authentifier uniquement
        //http.authorizeRequests().antMatchers("/categories/**").authenticated();
        //spécifie que l'accès à cette ressource demande a s'authentifier en tant que app-manager
        http.authorizeRequests().antMatchers("/articles/**").hasAnyAuthority("app-manager");
    }
}
