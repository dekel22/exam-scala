package models

object Adaptors {

  implicit class ClientToUser(client: Client) extends User {
    override val age: Int = client.age
    override val firstName: String = client.firstName
    override val lastName: String = client.lastName
    override val gender: String =  client.gender
    override val email: String = client.email
    override val phone: String = client.phone

  }
  implicit def clientListToUserList(list:List[Client]):List[User]=list.map(client=>ClientToUser(client))

  implicit class PersonToUser(person: Person) extends User {
    override val age: Int = person.age
    override val firstName: String = person.name.split(" ")(0)
    override val lastName: String = person.name.split(" ")(1)
    override val gender: String =  person.gender
    override val email: String = person.email
    override val phone: String = person.phone
  }
  implicit def personListToPersonList(list:List[Person]):List[User]=list.map(person=>PersonToUser(person))


}

//firstName: String, lastName: String, gender: String, age: Int, email: String, phone: String, education: String, occupation: String, salary: Int, maritalStatus: String, numberOfChildren: Int
//age: Int, name: String, gender: String, company: String, email: String, phone: String, address: