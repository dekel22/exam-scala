import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}
@JsonCreator
case class   Person@JsonCreator()(@JsonProperty("age")var age:Int, @JsonProperty("name")name: String,
                                  @JsonProperty("gender")var gender: String, @JsonProperty("company")company: String,
                                  @JsonProperty("email")var email: String, @JsonProperty("phone")phone: String,
                                  @JsonProperty("address")address: String) extends Serializable with User {
  override var firstName: String = name.split(" ")(0)
  override var lastName: String = name.split(" ")(1)
}