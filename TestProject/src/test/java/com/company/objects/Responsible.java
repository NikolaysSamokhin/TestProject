package com.company.objects;

import lombok.Data;

@Data
public class Responsible {
    private String firstName;
    private String middleName;
    private String lastName;

    private Responsible() {
    }


    public static class Builder {
        Responsible responsible;

        public Builder() {
            this.responsible = new Responsible();
        }

        public Builder setFirstName(String firstName) {
            responsible.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            responsible.middleName = middleName;
            return this;
        }

        public Builder setLastName(String lastName) {
            responsible.lastName = lastName;
            return this;
        }

        public Responsible build() {
            return responsible;
        }
    }
}
