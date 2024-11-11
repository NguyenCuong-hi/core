package com.example.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "person")

public class Person extends  EntityObject{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "carer")
    private String carer;

    @Column(name = "communist_party_join_date")
    private LocalDateTime communistPartyJoinDate;

    @Column(name = "communist_young_union_join_date")
    private LocalDateTime communistYoungUnionJoinDate;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "id_number_issue_by")
    private String idNumberIssueBy;

    @Column(name = "id_number_issue_date")
    private LocalDateTime idNumberIssueDate;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "communist_party_member")
    private Boolean communistPartyMember;

    @Column(name = "is_dead")
    private Boolean isDead;

    @Column(name = "marital_status")
    private int maritalStatus;

    @Column(name = "photo_cropped")
    private Boolean photoCropped;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "ethnics_id")
    private String ethnicsId;

    @Column(name = "family_social_class_id")
    private String familySocialClassId;

    @Column(name = "family_social_priority_id")
    private String familySocialPriorityId;

    @Column(name = "country_id")
    private String countryId;

    @Column(name = "native_village")
    private String nativeVillage;

    @Column(name = "personal_social_priority_id")
    private String personalSocialPriorityId;

    @Column(name = "religionId")
    private String religionId;

    @Column(name = "user_id")
    private Long userId;

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getCarer() {
        return carer;
    }

    public void setCarer(String carer) {
        this.carer = carer;
    }

    public LocalDateTime getCommunistPartyJoinDate() {
        return communistPartyJoinDate;
    }

    public void setCommunistPartyJoinDate(LocalDateTime communistPartyJoinDate) {
        this.communistPartyJoinDate = communistPartyJoinDate;
    }

    public LocalDateTime getCommunistYoungUnionJoinDate() {
        return communistYoungUnionJoinDate;
    }

    public void setCommunistYoungUnionJoinDate(LocalDateTime communistYoungUnionJoinDate) {
        this.communistYoungUnionJoinDate = communistYoungUnionJoinDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNumberIssueBy() {
        return idNumberIssueBy;
    }

    public void setIdNumberIssueBy(String idNumberIssueBy) {
        this.idNumberIssueBy = idNumberIssueBy;
    }

    public LocalDateTime getIdNumberIssueDate() {
        return idNumberIssueDate;
    }

    public void setIdNumberIssueDate(LocalDateTime idNumberIssueDate) {
        this.idNumberIssueDate = idNumberIssueDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Boolean getCommunistPartyMember() {
        return communistPartyMember;
    }

    public void setCommunistPartyMember(Boolean communistPartyMember) {
        this.communistPartyMember = communistPartyMember;
    }

    public Boolean getDead() {
        return isDead;
    }

    public void setDead(Boolean dead) {
        isDead = dead;
    }

    public int getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(int maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Boolean getPhotoCropped() {
        return photoCropped;
    }

    public void setPhotoCropped(Boolean photoCropped) {
        this.photoCropped = photoCropped;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getEthnicsId() {
        return ethnicsId;
    }

    public void setEthnicsId(String ethnicsId) {
        this.ethnicsId = ethnicsId;
    }

    public String getFamilySocialClassId() {
        return familySocialClassId;
    }

    public void setFamilySocialClassId(String familySocialClassId) {
        this.familySocialClassId = familySocialClassId;
    }

    public String getFamilySocialPriorityId() {
        return familySocialPriorityId;
    }

    public void setFamilySocialPriorityId(String familySocialPriorityId) {
        this.familySocialPriorityId = familySocialPriorityId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getNativeVillage() {
        return nativeVillage;
    }

    public void setNativeVillage(String nativeVillage) {
        this.nativeVillage = nativeVillage;
    }

    public String getPersonalSocialPriorityId() {
        return personalSocialPriorityId;
    }

    public void setPersonalSocialPriorityId(String personalSocialPriorityId) {
        this.personalSocialPriorityId = personalSocialPriorityId;
    }

    public String getReligionId() {
        return religionId;
    }

    public void setReligionId(String religionId) {
        this.religionId = religionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
