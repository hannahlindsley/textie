package textie.pipeline

import scalaz.concurrent.{Task, TaskApp}

object Main extends TaskApp {

  override def runl(args: List[String]): Task[Unit] = {
    for {
      t <- Api.processAsNounPhrase(args.head).run
    } yield println(t)
  }
}
