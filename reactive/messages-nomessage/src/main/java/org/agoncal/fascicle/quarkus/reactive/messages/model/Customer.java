package org.agoncal.fascicle.quarkus.reactive.messages.model;

import javax.json.bind.annotation.JsonbProperty;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class Customer extends Person {

  public String email;
  @JsonbProperty("phone_number")
  public String phoneNumber;
  public Status status;

  public Customer() {
  }

  public Customer(String firstName, String lastName, String email, String phoneNumber, Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.shippingAddress = address;
  }
}