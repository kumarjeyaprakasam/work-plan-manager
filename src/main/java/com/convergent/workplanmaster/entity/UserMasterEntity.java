package com.convergent.workplanmaster.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="user_master")
public class UserMasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String guid;
    private String email;
    private String password;
    private String avatar;
    private String phone;
    private Boolean isRememberMe;
    private String address;
    private Integer noOfAttempts;
    private Boolean isAccountLocked;
    private LocalDateTime lastLogin;
    private LocalDateTime prevLogin;
    private Boolean changePassword;
    private Long createdBy;
    private Long updatedBy;
    private Date createdAt;
    private Date updatedAt;
    private Integer version;
    private Boolean status;
}
