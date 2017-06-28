package de.bluexs.crtrip.social.repos;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.util.MultiValueMap;

import de.bluexs.crtrip.persistence.User;
import de.bluexs.crtrip.social.persistence.SocialUser;

@RepositoryRestResource(exported = false)
public interface SocialUserRepository extends JpaRepository<SocialUser, Long> {

    List<SocialUser> findAllByUser(User user);

    List<SocialUser> findByUserAndProviderId(User user, String providerId);

    List<SocialUser> findByProviderIdAndProviderUserId(String providerId, String providerUserId);

    //TODO will need a JPA Query here
    List<SocialUser> findByUserAndProviderUserId(User user, MultiValueMap<String, String> providerUserIds);

    @Query("Select userId from SocialUser where providerId = ? AND providerUserId in (?)")
    Set<String> findByProviderIdAndProviderUserId(String providerId, Set<String> providerUserIds);

    SocialUser findByUserAndProviderIdAndProviderUserId(User user, String providerId, String providerUserId);

}
