package com.projectstreamer.watchlistservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @Column(nullable = false)
    private Long dataId;

    @Column(nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private boolean isFavorite;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private ItemCategory itemCategory;

    public void setCreatedDate(Date createdDate) {
        if(this.createdDate!=null)
            this.createdDate = new Date(System.currentTimeMillis());
    }
}
