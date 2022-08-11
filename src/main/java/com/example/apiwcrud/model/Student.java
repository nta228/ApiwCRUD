package com.example.apiwcrud.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "api_crud", catalog = "")
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    @NotEmpty
    @Size(min = 5, message = "student name should have at least 5 characters")
    private String name;
    @Basic
    @Column(name = "email")
    @NotEmpty
    @Email
    private String email;
    @Basic
    @Column(name = "phone")
    @NotEmpty
    private String phone;
    @Basic
    @Column(name = "gender")
    private String gender;
    @Basic
    @Column(name = "note")
    private String note;
    @Basic
    @Column(name = "class_id")
    private int classId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && classId == student.classId && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(phone, student.phone) && Objects.equals(gender, student.gender) && Objects.equals(note, student.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, gender, note, classId);
    }
}
