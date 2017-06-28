package de.bluexs.crtrip.social.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import de.bluexs.crtrip.repos.UserRepository;
import de.bluexs.crtrip.social.repos.SocialUserRepository;

@Configuration
public class SocialConfig {

	@Value("${spring.social.facebook.appId}")
	private String fbApiKey;

	@Value("${spring.social.facebook.appSecret}")
	private String fbApiSecret;
	
    @Autowired
    SocialUserRepository socialUserRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TextEncryptor textEncryptor;

    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new FacebookConnectionFactory(
            fbApiKey,
            fbApiSecret));
        return registry;
    }

    @Bean
    public UsersConnectionRepository usersConnectionRepository() {
        JpaUsersConnectionRepository usersConnectionRepository = new 
                JpaUsersConnectionRepository(socialUserRepository, userRepository,
                connectionFactoryLocator(), textEncryptor);

        return usersConnectionRepository;
    }
}

