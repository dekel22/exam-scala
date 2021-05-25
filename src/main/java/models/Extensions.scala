package models

object Extensions {

  implicit class StringHelper(string: String) {
    def isValidPhoneNumber(): Boolean = {
      string.exists(_.isDigit)
    }

    def isValidEmail(): Boolean = string.contains("@") && string.contains(".com")
  }

}
