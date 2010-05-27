/**
 * IUPAC supports ambiguous data
 *
 * Symbol       Meaning      Nucleic Acid
 * ------------------------------------------
 * A            A            Adenine
 * C            C            Cytosine
 * G            G            Guanine
 * T            T            Thymine
 * U            U            Uracil
 * M          A or C
 * R          A or G
 * W          A or T
 * S          C or G
 * Y          C or T
 * K          G or T
 * V        A or C or G
 * H        A or C or T
 * D        A or G or T
 * B        C or G or T
 * X      G or A or T or C
 * N      G or A or T or C
 *
 */

package bio {

  package DNA {
    sealed abstract class IUPAC extends Symbol
    case object M extends IUPAC { override def toString = "m" }
    case object R extends IUPAC { override def toString = "r" }
    case object W extends IUPAC { override def toString = "w" }
    case object S extends IUPAC { override def toString = "s" }
    case object Y extends IUPAC { override def toString = "y" }
    case object K extends IUPAC { override def toString = "k" }
    case object V extends IUPAC { override def toString = "v" }
    case object H extends IUPAC { override def toString = "h" }
    case object D extends IUPAC { override def toString = "d" }
    case object B extends IUPAC { override def toString = "b" }
    case object X extends IUPAC { override def toString = "x" }
    case object N extends IUPAC { override def toString = "n" }

    object IUPACNucleotideConvert {
      /** 
       * Create a IUPAC object from its character representation.
       */
      def fromChar(c: Char): Symbol = { 
        c.toLowerCase match {
          // case '-' => EmptyIUPAC
          case 'm' => M
          case 'r' => R
          case 'w' => W
          case 's' => S
          case 'y' => Y
          case 'k' => K
          case 'v' => V
          case 'h' => H
          case 'd' => D
          case 'b' => B
          case 'x' => X
          case 'n' => N
          case  _  => 
            NucleotideConvert.fromChar(c)
        }
      }
      def fromString(s: String): List[Symbol] = s.toList.map { fromChar(_) }
      def fromList(list: List[Symbol]): List[Symbol] = {
        list.map { 
          _ match {
            case A => A
            case C => C
            case G => G
            case T => T 
            case M => M
            case R => R
            case W => W
            case S => S
            case Y => Y
            case K => K
            case V => V
            case H => H
            case D => D
            case B => B
            case X => X
            case N => N
            case  _  => throw new IllegalArgumentException("Unexpected type")
            }
          }
        }
    }
  }
}
