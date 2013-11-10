import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

import anorm._

@RunWith(classOf[JUnitRunner])
class ModelSpec extends Specification {
  
  import models._
  import tools._

  "User model" should {
    
    "be retrieved by id" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        
        val Some(xcode) = User.findById(1)

        xcode.id must equalTo(anorm.Id(1L))
        xcode.email must equalTo("xcodevn@gmail.com")
        Tools.checkPassword("abc123", xcode.password) must equalTo(true)
      }
    }

    "be retrieved by email" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        
        val Some(xcode) = User.findByEmail("xcodevn@gmail.com")

        xcode.id must equalTo(anorm.Id(1L))
        xcode.email must equalTo("xcodevn@gmail.com")
        Tools.checkPassword("abc123", xcode.password) must equalTo(true)
      }
    }

    "update user info correctly" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        /* Getting old info */
        val Some(thanh) = User.findById(2)
        /* Make sure it is wrong info */
        Tools.checkPassword("thanhpw", thanh.password) must equalTo(false)

        /* Now, update the corrected info */
        val new_thanh = thanh.copy(password = Tools.getHashedPassword("thanhpw"))
        User.update(2, new_thanh)

        /* Checking again */
        val Some(new1_thanh) = User.findById(2)
        Tools.checkPassword("thanhpw", new1_thanh.password) must equalTo(true)
      }
    }

    "insert new user" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        val newUser = User(NotAssigned, "spam@email.com", "strongPassword", "Troller")

        User.insert(newUser)

        val Some(troller) = User.findByEmail("spam@email.com")

        troller.id must equalTo(Id(1000L))
        troller.email must equalTo("spam@email.com")
        Tools.checkPassword("strongPassword", troller.password) must equalTo(true)
        troller.fullname must equalTo("Troller")
      }
    }
  }
}

