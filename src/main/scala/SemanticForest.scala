package textie.pipeline

import org.iguana.parser.ParseSuccess

import scalaz.\/

trait Forest
final case class ParseForest(trees: ParseSuccess) extends Forest
final case class SemanticForest() extends Forest
object SemanticForest {
  def understand(pf: ParseForest): ComprehensionError \/ SemanticForest = {
    ???
  }
}