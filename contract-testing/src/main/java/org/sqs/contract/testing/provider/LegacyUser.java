package org.sqs.contract.testing.provider;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.eclipse.yasson.internal.model.customization.PropertyOrdering;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.config.PropertyOrderStrategy;

@JsonbPropertyOrder({ "id", "firstName", "lastName", "age" })
public class LegacyUser {

    public int id;
    public String firstName;
    public String lastName;
    public int age;

    public LegacyUser() {
        this.id = 1;
        this.firstName = "Max";
        this.lastName = "Mustermann";
        this.age = 23;
    }

}
