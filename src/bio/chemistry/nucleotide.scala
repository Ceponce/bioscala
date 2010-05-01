/*
 * Nucleotides (abreviated nt) are molecules that, when joined together, make
 * up the structural units of RNA and DNA. In addition, nucleotides play
 * central roles in metabolism.
 *
 * The purines are adenine (A) and guanine (G).
 * The (complementary) pyrimidines are thymine (T) and cytosine (C).
 * In RNA uracil (U) is the complementary pyrimidine of adenine.
 *
 */

package bio {

  sealed abstract class Nucleotide {
    def fromChar(c : Char) : Char = {
      c
    }
  }

  package DNA {
    case object A extends Nucleotide {
      override def toString() = "a"
    }
    case object G extends Nucleotide {
      override def toString() = "g"
    }
    case object T extends Nucleotide {
      override def toString() = "t"
    }
    case object C extends Nucleotide {
      override def toString() = "c"
    }

  }

  package RNA {
    case object A extends Nucleotide {
      override def toString() = "a"
    }
    case object G extends Nucleotide {
      override def toString() = "g"
    }
    case object U extends Nucleotide {
      override def toString() = "u"
    }
    case object C extends Nucleotide {
      override def toString() = "c"
    }
  }

}
