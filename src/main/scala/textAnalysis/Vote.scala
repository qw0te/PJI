import java.util.Date

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
 * @param voteAnalyse analyse of the vote
 *
 * @author Quentin Baert
 */
class Vote(
  val date: Date,
  val number: Int,
  val suject: String,
  val voterNb: Int,
  val expressedVotes: Int,
  val absoluteMajority: Int,
  val forNb: Int,
  val againstNb: Int,
  val voteAnalyse: String)
