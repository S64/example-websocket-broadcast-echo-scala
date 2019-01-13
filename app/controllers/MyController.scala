package controllers

import akka.actor.ActorSystem
import akka.stream.Materializer
import akka.stream.scaladsl.{BroadcastHub, Flow, Keep, MergeHub}
import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents, WebSocket}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class MyController @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext, mat: Materializer) extends AbstractController(cc) {

  private val (mySink, mySource) = {
    val src = MergeHub.source[String]

    val sink = BroadcastHub.sink[String]

    src.toMat(sink)(Keep.both).run()
  }

  private val myFlow: Flow[String, String, _] = {
    Flow.fromSinkAndSource(mySink, mySource)
  }

  def index: WebSocket = WebSocket.acceptOrResult[String, String] { req =>
    Future.successful(myFlow).map { flow =>
      Right(flow)
    }
  }

}
