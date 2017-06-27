package de.bluexs.crtrip.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * 
 * @author daveyx
 * 
 */

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Value("${oauth.tokenTimeoutAccess:3600}")
	private int expirationAccess;

	@Value("${oauth.tokenTimeoutRefresh:172800}") // two days
	private int expirationRefresh;

	@Autowired
	private DataSource dataSource;

    @Value("classpath:schema.sql")
    private Resource schemaScript;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		configurer
			.authenticationManager(authenticationManager)
			.tokenStore(tokenStore())
			.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.jdbc(dataSource)
//			.inMemory()
			.withClient("daveyx")
			.secret(PASSWORD_ENCODER.encode("secret"))
			.accessTokenValiditySeconds(expirationAccess)
			.refreshTokenValiditySeconds(expirationRefresh)
			.scopes("read", "write")
			.authorizedGrantTypes("password", "refresh_token")
			.resourceIds("resource");
	}

	@Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.passwordEncoder(PASSWORD_ENCODER).tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

	// JDBC token store configuration

	@Bean
	public TokenStore tokenStore() {
	    return new JdbcTokenStore(dataSource);
	}

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

}
