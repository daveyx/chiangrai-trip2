package de.bluexs.crtrip.social.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import de.bluexs.crtrip.persistence.BaseUser;
import de.bluexs.crtrip.persistence.User;
import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"userId", "providerId", "providerUserId"}),
		@UniqueConstraint(columnNames = {"userId", "providerId", "rank"})})
public class SocialUser extends BaseUser {

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "userId", nullable = false, updatable = false)
    private User user;

    private String providerId;

    private String providerUserId;

    private int rank;

    private String displayName;

    private String profileUrl;

    private String imageUrl;

    @Column(length = 500)
    private String accessToken;

    private String secret;

    private String refreshToken;

    private Long expireTime;
    
    @Column(length=36)
    private String uuid;
}
