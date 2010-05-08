/**
 * Attributes are properties of Nucleotides, Sequences, Alignments etc.
 * For a Sequence there maybe a ID attributes, descriptions, features,
 * annotations, etc.
 *
 * Each attribute implements listeners, to messages they respond to. A
 * message may be to return the primary ID, descriptions, or output to
 * RDF, for example.
 *
 * A message is simply a Tuple of the message type, and paramaters. The
 * return value is also a Tuple with status and object(s).
 */

package bio {

  abstract class Message
  abstract class StatusMessage

  abstract class Attribute {
    // def send(msg: Message): Tuple2[StatusMessage,Any]
  }

  package attribute {

    // ==== Message
    case object getId extends Message
    case object getDescription extends Message
    // ==== StatusMessage
    case object Ok extends StatusMessage
    case object UnknownMessage extends StatusMessage
    case object Error extends StatusMessage

    // ==== Attributes
    class Id(str: String) extends Attribute {
      lazy val data = str
      // lazy val respondmsg = respond

      def send(msg: Message): Tuple2[StatusMessage,String] = {
        if (msg == getId) { (Ok,data) }
        else { (UnknownMessage,"")}

          // case getDescription => (Ok,data)
          // case _ => (UnknownMessage,"")
      }
    }
    // class Id(str: String) extends StringAttribute(str,getId)
    // class Description(str: String) extends StringAttribute(str,getDescription)
  }
}


