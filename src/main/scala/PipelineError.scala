package textie.pipeline

import org.iguana.parser.ParseError

sealed trait PipelineError
final case class ParserError(e: ParseError) extends PipelineError
final case class ComprehensionError(m: String) extends PipelineError
