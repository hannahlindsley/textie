package textie.pipeline

import org.iguana.parser.ParseResult
import org.scalatest.{FunSpec, ShouldMatchers}

class SemanticForestSpec extends FunSpec with ShouldMatchers {

  describe("a parsable sentence with a single point of ambiguity") {

    val parseResult: ParseResult = XbarGrammar.parse("NN")("NP")

    it ("") {
      parseResult.isParseSuccess should be (true)

      // It's either "meat sauce" or "meat <and> sauce"
      parseResult.asParseSuccess.getStatistics.getCountAmbiguousNodes should be (1)
    }
  }

  describe ("a semantic parse forest, given a syntactic one") {
    it ("should have concept nodes as terminals") {

    }
  }
}
