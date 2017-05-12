package com.abtechsoft

import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Keep, Sink, Source}

import scala.concurrent.Future

/**
  * Created by abdhesh on 11/05/17.
  */
object TraverseFuture {
  def traverse[A, B](in: TraversableOnce[A], maxParallel: Int)(fn: A => Future[B])(implicit mat: ActorMaterializer): Future[Seq[B]] = {
    Source[A](in.toStream)
      .mapAsync(maxParallel)(fn)
      .toMat(Sink.seq)(Keep.right)
      .run()
  }
}
