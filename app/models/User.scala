package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

import scala.language.postfixOps

import tools._

case class User(id: Pk[Long] = NotAssigned, email: String, password: String, fullname: String)

object User {
  /**
   * Parse a User from a ResultSet
   */
  val simple = {
    get[Pk[Long]]("user.id") ~ 
    get[String]("user.email") ~
    get[String]("user.password") ~
    get[String]("user.fullname") map {
      case id~email~password~fullname => User(id, email, password, fullname)
    }
  }

  /**
   * Find a user by Id
   *
   * @param id User Id
   */
  def findById(id: Long): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from user where id = {id}").on('id -> id).as(User.simple.singleOpt)
    }
  }

  /**
   * Find a user by email
   *
   * @param email User's email
   */
  def findByEmail(email: String): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from user where email = {email}").on('email -> email).as(User.simple.singleOpt)
    }
  }

  /**
   * Update a user
   *
   * @param id The user id
   * @param user The user object
   */
  def update(id: Long, user: User) = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          update user
          set email = {email}, password = {password}, fullname = {fullname}
          where id = {id}
        """
      ).on(
        'id -> id,
        'email -> user.email,
        'password -> user.password,
        'fullname -> user.fullname
      ).executeUpdate()
    }
  }

  /**
   * Insert a new user
   * Note: only save the hash of the password
   *
   * @param user The user object
   */
  def insert(user: User) = {
    DB.withConnection { implicit connection => 
      SQL(
        """
          insert into user values (
            (select next value for user_seq),
            {email}, {password}, {fullname}
          )
        """
      ).on ( 'email -> user.email,
        'password -> Tools.getHashedPassword(user.password),
        'fullname -> user.fullname
      ).executeUpdate()
    }
  }

  /** Delete a user
   * 
   * @param id The id of user to be deleted
   */
  def delete(id: Long) = {
    DB.withConnection { implicit connection =>
      SQL("delete from user where id = {id}").on('id -> id).executeUpdate()
    }
  }
}

