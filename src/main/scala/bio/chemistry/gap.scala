/** 
 * A gap represents a gap in a GappedSequence, as used in an alignment. Gaps
 * can contain state - e.g. quality - through the attributes list.
 */

package bio {

  package DNA {

    sealed abstract class Gap extends NTSymbol
    case object Gap extends Gap {
      override def toString = "-"
    }

    object GappedNucleotideConvert {
    /** 
     * Create a Gap object from its character representation.
     */
    def fromChar(c: Char): NTSymbol = { 
      c.toLowerCase match {
        case '-' => Gap
        case  _  => 
          NucleotideConvert.fromChar(c)
      }
    }
    def fromString(s: String): List[NTSymbol] = s.toList.map { fromChar(_) }
    def fromList(list: List[NTSymbol]): List[NTSymbol] = {
      list.map { 
        _ match {
          case Gap => Gap
          case  _  => throw new IllegalArgumentException("Unexpected type")
          }
        }
      }
    }
  }
}
