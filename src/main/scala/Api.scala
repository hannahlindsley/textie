package textie.pipeline

import org.iguana.parser.{ParseSuccess, ParseError, ParseResult}

import scalaz.concurrent.Task
import scalaz.{\/, EitherT}
import scalaz.syntax.arrow._
import scalaz.syntax.bind._

object Api {

  private def run(tagger: Tagger)
                 (parser: Parser)
                 (conceptualizer: Conceptualizer):  (String => String => Result[SemanticForest]) =
    (s: String) => (ph: String) => tagger(s) >>= parser(ph) >>= conceptualizer

  def iguanaParser: Parser = (upToPhrase: String) => {
    (toks: List[Token]) => {

      //TODO this is making a list out of all possible pos's, not just one for each term
      val result: ParseResult = XbarGrammar.parse(toks.map(_.data.values).toString())(upToPhrase)

      val disjunct: \/[ParseError, ParseSuccess] = {
        if (result.isParseError) \/ left result.asParseError
        else \/ right result.asParseSuccess
      }

      EitherT[Task, PipelineError, ParseForest] {
        Task.delay {
          disjunct.leftMap(ParserError).map(ParseForest.apply)
        }
      }
    }
  }
  
  def basicConceptualizer: Conceptualizer = { (pf: ParseForest) =>
    ???
  }

  def basicTagger: Tagger = ???
  
  def processAsNounPhrase(text: String): Result[SemanticForest] =
    run(basicTagger)(iguanaParser)(basicConceptualizer)(text)("NP")  
}
