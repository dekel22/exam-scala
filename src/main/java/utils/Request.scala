package utils

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

case class Request @JsonCreator()(@JsonProperty("min_age") min_age: Int = 0, @JsonProperty("max_age") max_age: Int = 200,
                                  @JsonProperty("gender") gender: String = "", @JsonProperty("prefix_name") prefix_name: String = "",
                                  @JsonProperty("Marital Status") maritalStatus: String = "", @JsonProperty("Number of Children") NumberOfChildren: Int = 0) {

}
