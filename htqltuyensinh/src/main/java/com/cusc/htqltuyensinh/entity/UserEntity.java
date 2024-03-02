package com.cusc.htqltuyensinh.entity;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{
	@Column(name = "name")
	private String name;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "job")
	private String job;
	
	@Column(name = "province_id")
    private String province;
	
	@ManyToOne
	@JoinColumn(name = "schools_id")
    private SchoolEntity school;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "father_phone")
	private String fatherPhone;
	
	@Column(name = "mother_phone")
	private String motherPhone;
	
	@Column(name = "zalo")
	private String zalo;
	
	@Column(name = "facebook")
	private String facebook;
	
	@Column(name = "gather_description")
	private String gatherDescription;
	
	@Column(name = "status")
	private boolean status;
	
	@OneToMany(mappedBy = "user")
    private List<FavoriteSubjectEntity> favoriteSubjects = new ArrayList<>();

	@OneToMany(mappedBy = "user")
    private List<ApplicationFormEntity> applicationForms = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
    private List<AssignDetailEntity> assignDetails = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
    private List<CallEntity> calls = new ArrayList<>();
	
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public SchoolEntity getSchool() {
		return school;
	}

	public void setSchool(SchoolEntity school) {
		this.school = school;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFatherPhone() {
		return fatherPhone;
	}

	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}

	public String getMotherPhone() {
		return motherPhone;
	}

	public void setMotherPhone(String motherPhone) {
		this.motherPhone = motherPhone;
	}

	public String getZalo() {
		return zalo;
	}

	public void setZalo(String zalo) {
		this.zalo = zalo;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getGatherDescription() {
		return gatherDescription;
	}

	public void setGatherDescription(String gatherDescription) {
		this.gatherDescription = gatherDescription;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<FavoriteSubjectEntity> getFavoriteSubjects() {
		return favoriteSubjects;
	}

	public void setFavoriteSubjects(List<FavoriteSubjectEntity> favoriteSubjects) {
		this.favoriteSubjects = favoriteSubjects;
	}

	public List<ApplicationFormEntity> getApplicationForms() {
		return applicationForms;
	}

	public void setApplicationForms(List<ApplicationFormEntity> applicationForms) {
		this.applicationForms = applicationForms;
	}

	public List<AssignDetailEntity> getAssignDetails() {
		return assignDetails;
	}

	public void setAssignDetails(List<AssignDetailEntity> assignDetails) {
		this.assignDetails = assignDetails;
	}

	public List<CallEntity> getCalls() {
		return calls;
	}

	public void setCalls(List<CallEntity> calls) {
		this.calls = calls;
	}
	
}
