package textie.pipeline

import org.iguana.parser.ParseResult
import org.scalatest.{FunSpec, ShouldMatchers}

class SemanticForestSpec extends FunSpec with ShouldMatchers {

  describe("a parse forest") {

    it ("should be able to generate all available trees as a stream") {}

    it ("should be able to generate all available subtrees as a stream") {}
    
    it ("should be prune-able by score") {}

    it ("should be prune-able by pattern") {}
  }

  describe ("a parse pattern") {

    it ("should match all nodes for which it is more general") {
      // "UP(U_(U(x)), *)" or something equivalent should match all coordinating phrase options,
      // like "and Susan" or "but not Jason"
      // The idea here would be to predefine certain phrase types, like genitives, appositives, etc, for
      // the purpose of affecting the scoring given context.
    }

    it ("should be able to specify both syntactic and semantic elements")  {
      // "in the building" should be distinguishable from "in the night", as location vs. time
    }
  }
}
