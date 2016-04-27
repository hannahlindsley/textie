package textie.pipeline

import iguana.utils.input.Input
import org.iguana.grammar.Grammar
import org.iguana.grammar.symbol.Rule.Builder
import org.iguana.grammar.symbol.{Epsilon, Rule, Nonterminal, Character}
import org.iguana.parser.{Iguana, ParseResult}
import org.iguana.regex.Sequence
import org.iguana.util.Configuration

import scala.collection.JavaConverters._
import scala.language.postfixOps

/**
 * TODO Doc
 */
object XbarGrammar {
  
  def parse(text: String): (String => ParseResult) = { (phraseType: String) => 
    Iguana parse (Input fromString text, grammar, Configuration DEFAULT, Nonterminal withName phraseType)
  }

  private def build(p: Nonterminal): Builder = Rule withHead p

  val NP: Nonterminal = Nonterminal withName "NP"
  val nBar: Nonterminal = Nonterminal withName "N_"
  val N: Sequence[Character] = Sequence from "N"

  val UP: Nonterminal = Nonterminal withName "UP"
  val uBar: Nonterminal = Nonterminal withName "U_"
  val U: Sequence[Character] = Sequence from "U"

  private val NPs: List[Rule] = List(
    build (NP) from nBar,                     // "wife"
    build (NP) from (nBar, NP),               // "sister wife"
    build (NP) from (nBar, UP)                // "sister and wife" or "sisters, wives"
  )
  
  private val uBars: List[Rule] = List(
    build(uBar) from (U, NP),                   // "and wife"
    build(uBar) from (Epsilon.getInstance, NP)  // sisters, "...wives" (the "and" is elided)
  )

  private val UPs: List[Rule] = List(build (UP) from uBar)

  private val rules: List[Rule] = (build (nBar) from N) :: uBars ++ NPs ++ UPs
  val grammar: Grammar = Grammar.builder().addRules(rules.asJava).build
}