package com.projectstreamer.watchlistservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WatchList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date createdDate;

    @Column()
    private Date updatedDate;

    @ManyToOne()
    @JoinColumn(name = "account",nullable = false,referencedColumnName = "id")
    private Account account;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "watchlist_and_items",joinColumns = {@JoinColumn(name = "watchlist_id",referencedColumnName = "id")},
            inverseJoinColumns = @JoinColumn(name = "item_id",referencedColumnName = "dataId"))
    private Set<Item> items;

    public void setCreatedDate(Date createdDate) {
        if(this.createdDate==null)
            this.createdDate = new Date(System.currentTimeMillis());
    }

    public void setUpdatedDate(Date updatedDate) {
        if(this.createdDate!=null)
            this.updatedDate = new Date(System.currentTimeMillis());
    }
}
