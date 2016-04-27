package textie.pipeline

final case class Token(word: Word, data: Map[String, List[POS]])
final case class Word(text: String, start: Int, end: Int)
final case class POS(pos: PartOfSpeech, score: Int)

trait PartOfSpeech
final case class Noun(word: Word) extends PartOfSpeech
final case class Conjunction(word: Word) extends PartOfSpeech