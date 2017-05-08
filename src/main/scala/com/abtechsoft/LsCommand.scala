package com.abtechsoft

/**
  * Created by abdhesh on 08/05/17.
  */
object LsCommand extends App {

  import scala.sys.process._

  /**
    * Write output of command on console output stream
    * @param command
    * @return
    */
  def execute(command: Seq[String]) = Process(command) #> Console.out run()

  execute(Seq("ls"))

}
