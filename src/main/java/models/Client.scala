package models

case class Client(val firstName: String, val lastName: String, val gender: String, val age: Int, val email: String,
                  val phone: String, education: String, occupation: String, salary: Int, maritalStatus: String,
                  val numberOfChildren: Int)extends Serializable with User {
}
