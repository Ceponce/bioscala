/**
 * IUPAC Nucleotide Sequence represents a Sequence that uses the 
 * ambiguous code:
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

import bio._
import bio.attribute._

package bio {

  class GappedSequence (seqlist: List[Symbol], attributelist: List[Attribute]) extends bio.Sequence[Symbol](seqlist,attributelist) {
  }

  package DNA {
    class GappedSequence (seqlist: List[Symbol], attributelist: List[Attribute]) extends bio.GappedSequence(seqlist,attributelist) {
      def this(list: List[Nucleotide]) = this(GappedNucleotideConvert.fromList(list),Nil)
      def this(str: String) = this(GappedNucleotideConvert.fromString(str),Nil)
      def this(id: String, str: String) = this(GappedNucleotideConvert.fromString(str), List(Id(id)))
      def this(id: String, descr: String, str: String) = this(GappedNucleotideConvert.fromString(str),List(Id(id),Description(descr)))
      def this(sequence: Sequence) = this(sequence.seq, Nil)

    }
  }
}

