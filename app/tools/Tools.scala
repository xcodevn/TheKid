package tools

import org.mindrot.jbcrypt._

object Tools {

  /**
   * Get hashed version of the password
   *
   * @param password Plain text password
   */
  def getHashedPassword(password: String) = {
    BCrypt.hashpw(password, BCrypt.gensalt())
  }

  /**
   * Checking plain password with hashed password
   *
   * @param password The plan text password
   * @param hashedPassword The hashed version
   */
  def checkPassword(password: String, hashedPassword: String) = {
    try {
      BCrypt.checkpw(password, hashedPassword)
    } catch {
      case _ : Throwable => false
    }
  }
}

