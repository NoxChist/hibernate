package ru.neto.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "persons")
public class Person {
    @EmbeddedId
    private PKey pKey;
    private String phone_number;
    private String city_of_living;

    @Override
    public String toString() {
        return getPKey().toString() + getPhone_number() + ", " + getCity_of_living() + "\n";
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Embeddable
    public static class PKey implements Serializable {
        @Column(nullable = false)
        private String name;
        @Column(nullable = false)
        private String surname;
        @Column(nullable = false)
        private int age;

        @Override
        public int hashCode() {
            return Objects.hashCode(this.getName().toLowerCase() + this.getSurname().toLowerCase() + this.getAge());
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() == PKey.class) {
                PKey key = (PKey) obj;
                return key.getName().equalsIgnoreCase(this.getName())
                        && key.getSurname().equalsIgnoreCase(this.getSurname())
                        && key.getAge() == this.getAge();
            }
            return false;
        }

        @Override
        public String toString() {
            return String.format("%s %s, %d\n", this.getSurname(), this.getName(), this.getAge());
        }
    }

}
