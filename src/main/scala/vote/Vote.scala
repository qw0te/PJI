/**
 * Represents a vote
 *
 * @constructor creates a new vote
 * @param date date of the vote
 * @param number number of the vote
 * @param subject subject of the vote
 * @param voterNb number of voter
 * @param expressedVotes number of suffrage that are expressed
 * @param absoluteMajority number of suffrage necessary to make the vote
 *                         effective
 * @param forNb number of suffrage expressed for the vote
 * @param againstNb number of suffrage against the vote
 * @param adopted tells if the vote was adopted or not
 * @param voteDetails details of the vote
 *
 * @author Quentin Baert
 */
class Vote(
  val legislature: Int,
  val date: String,
  val number: Int,
  val subject: String,
  val voterNb: Int,
  val expressedVotes: Int,
  val absoluteMajority: Int,
  val forNb: Int,
  val againstNb: Int,
  val adopted: Boolean,
  val voteDetails: List[(Voter, VoteDecision)]) {

  def toCSV: String = {
    def buildLine(voterCouple: (Voter, VoteDecision)): String = {
      val (voter, decision) = voterCouple

      "\"" + this.legislature + "\"" + ", " +
      "\"" + this.date        + "\"" + ", " +
      "\"" + this.number      + "\"" + ", " +
      "\"" + this.subject     + "\"" + ", " +
      "\"" + voter.party      + "\"" + ", " +
      "\"" + voter.lastName   + "\"" + ", " +
      "\"" + voter.firstName  + "\"" + ", " +
      "\"" + decision         + "\""
    }

    (this.voteDetails map buildLine) mkString "\n"
  }

  override def toString: String = {
    def coupleToString(c: (Voter, VoteDecision)): String =
      c._1.toString + " -> " + c._2.toString

    "Legislature              : " + this.legislature      + "\n" +
    "Date                     : " + this.date             + "\n" +
    "Numéro du scrutin        : " + this.number           + "\n" +
    "Sujet du scrutin         : " + this.subject          + "\n" +
    "Nombre de votant         : " + this.voterNb          + "\n" +
    "Nombre de votes exprimés : " + this.expressedVotes   + "\n" +
    "Majorité absolue         : " + this.absoluteMajority + "\n" +
    "Pour                     : " + this.forNb            + "\n" +
    "Contre                   : " + this.againstNb        + "\n" +
    "Adopté                   : " + this.adopted          + "\n" +
    "Votants                  : " + "\n" +
      ((this.voteDetails map coupleToString) mkString "\n")
  }

}
