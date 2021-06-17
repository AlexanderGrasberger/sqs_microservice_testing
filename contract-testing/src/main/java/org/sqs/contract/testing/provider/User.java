package org.sqs.contract.testing.provider;

import javax.json.bind.annotation.JsonbPropertyOrder;
import java.time.LocalDate;

@JsonbPropertyOrder({ "id", "firstName", "lastName", "birthday" })
public class User {

    public int id;
    public String firstName;
    public String lastName;
    public LocalDate birthday;

    public User() {
        this.id = 1;
        this.firstName = "Max";
        this.lastName = "Mustermann";
        this.birthday = LocalDate.now().minusYears(23);
    }

}
