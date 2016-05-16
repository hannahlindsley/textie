package textie

import scalaz.EitherT
import scalaz.concurrent.Task

package object pipeline {
  type Result[A] = EitherT[Task, PipelineError, A]
  type Tagger = (String => Result[List[Token]])
  type Parser = (String => List[Token] => Result[ParseForest])
  type Conceptualizer = (ParseForest => Result[SemanticForest])
}
