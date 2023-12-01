package com.cusc.htqltuyensinh.api.output;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

    private String code;
    private String name;
    private Date birthday;
    private String username;
    private String password;
    private boolean gender;
    private String phone;
    private String address;
    private String email;
    private boolean role;
    private boolean status;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(
            String code,
            String name,
            Date birthday,
            String username,
            String password,
            boolean gender,
            String phone,
            String address,
            String email,
            boolean role,
            boolean status,
            Collection<? extends GrantedAuthority> authorities) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.role = role;
        this.status = status;
        this.authorities = authorities;
    }
    
    

    public CustomUserDetails() {

	}



	// Getters for all fields

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // You can implement this based on your requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // You can implement this based on your requirements
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // You can implement this based on your requirements
    }

    @Override
    public boolean isEnabled() {
        return status;
    }



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public boolean isGender() {
		return gender;
	}



	public void setGender(boolean gender) {
		this.gender = gender;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public boolean isRole() {
		return role;
	}



	public void setRole(boolean role) {
		this.role = role;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}
    
    
    
}