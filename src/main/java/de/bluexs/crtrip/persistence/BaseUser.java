package de.bluexs.crtrip.persistence;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.util.Assert;

import lombok.Data;

/**
 *
 * @author : daveyx
 */

@Data
@MappedSuperclass
public abstract class BaseUser extends AbstractPersistable<Long> {

    @Column(length=36)
    private String uuid;

    private Date timeCreated;

    public BaseUser() {
        this(UUID.randomUUID());
    }

    public BaseUser(UUID guid) {
        Assert.notNull(guid, "UUID is required");
        setUuid(guid.toString());
        this.timeCreated = new Date();
    }

    public int hashCode() {
        return getUuid().hashCode();
    }

}
