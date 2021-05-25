package UserClasses

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

@JsonCreator
case class Person @JsonCreator()(@JsonProperty("age") val age: Int, @JsonProperty("name") name: String,
                                 @JsonProperty("gender") val gender: String, @JsonProperty("company") company: String,
                                 @JsonProperty("email") val email: String, @JsonProperty("phone") val phone: String,
                                 @JsonProperty("address") address: String) extends Serializable with User {
  override val firstName: String = name.split(" ")(0)
  override val lastName: String = name.split(" ")(1)
}
