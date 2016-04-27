package textie

import scalaz.EitherT
import scalaz.concurrent.Task

package object pipeline {
  type Action[A] = EitherT[Task, PipelineError, A]
  type Tagger = (String => Action[List[Token]])
  type Parser = (String => List[Token] => Action[ParseForest])
  type Conceptualizer = (ParseForest => Action[SemanticForest])
}
