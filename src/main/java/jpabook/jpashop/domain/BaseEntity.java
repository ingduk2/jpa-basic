package jpabook.jpashop.domain;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class BaseEntity {
     private String createdBy;
     private LocalDateTime createDate;
     private String lastModifiedBy;
     private LocalDateTime lastModefiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModefiedDate() {
        return lastModefiedDate;
    }

    public void setLastModefiedDate(LocalDateTime lastModefiedDate) {
        this.lastModefiedDate = lastModefiedDate;
    }
}
