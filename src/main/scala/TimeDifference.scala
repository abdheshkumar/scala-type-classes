import java.sql.Timestamp
import java.util.Date

import com.abtechsoft.Debug

/**
  * Created by abdhesh on 16/05/17.
  */
object TimeDifference extends App {

  import scala.concurrent.duration._

  val start_time = new Timestamp(new Date().getTime)
  println(start_time.getTime)
  Thread.sleep(5 * 60 * 1000)
  val end_time = new Timestamp(new Date().getTime)

  val diff = Duration(end_time.getTime - start_time.getTime, MILLISECONDS)
  val diffSeconds = diff.toSeconds
  val diffMinutes = diff.toMinutes
  val diffHours = diff.toHours
  val finalString = s"$diffHours:$diffMinutes:$diffSeconds"
  println(finalString)
}
