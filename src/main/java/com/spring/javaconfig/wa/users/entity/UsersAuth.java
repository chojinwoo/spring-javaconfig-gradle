package com.spring.javaconfig.wa.users.entity;

import javax.persistence.*;

/**
 * Created by bangae1 on 2016-01-11.
 */
@Entity
@Table(name = "users_auth", schema = "bangae1")
public class UsersAuth {
    private int seq;
    private String authority;
    private String email;

    @Id
    @Column(name = "seq", nullable = false)
    @SequenceGenerator(name = "seq", sequenceName = "users_auth_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "authority", nullable = false, length = 10)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 20)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersAuth usersAuth = (UsersAuth) o;

        if (seq != usersAuth.seq) return false;
        if (authority != null ? !authority.equals(usersAuth.authority) : usersAuth.authority != null) return false;
        if (email != null ? !email.equals(usersAuth.email) : usersAuth.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = seq;
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
