package com.tutorial.ecommerce_be.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "verification_token")
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @Column(name = "create_time_stemp", nullable = false)
    private Timestamp createTimeStemp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private LocalUser user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "verification_token_id")
    private VerificationToken verificationToken;

    public VerificationToken getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(VerificationToken verificationToken) {
        this.verificationToken = verificationToken;
    }

    public LocalUser getUser() {
        return user;
    }

    public void setUser(LocalUser user) {
        this.user = user;
    }

    public Timestamp getCreateTimeStemp() {
        return createTimeStemp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCreateTimeStemp(Timestamp createTimeStemp) {
        this.createTimeStemp = createTimeStemp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}