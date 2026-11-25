package com.tylercave.royalty_ledger.rightsholder;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "rights_holder")
public class RightsHolder {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private RightsHolderType type;

    private String email;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    protected RightsHolder() {}

    public RightsHolder(String name, RightsHolderType type, String email) {
        this.name = name;
        this.type = type;
        this.email = email;
        this.createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RightsHolderType getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
