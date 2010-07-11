/**
 * An Alignment has an (immutable) list of GappedSequences. A Sequence can
 * consist of nucleotides, amino acids and/or gaps. Each of these can have
 * attributes, sequences can have attributes and the Alignment can have
 * attributes.
 */

import bio._
import bio.attribute._

package bio {

  class Alignment[T](sequencelist: List[T], attributelist: List[Attribute]) {
    val list = sequencelist
    val attributes = attributelist

    def this(list: List[T]) = this(list,Nil)
    def toList : List[T] = list
  }

  package DNA {
    object SparseAlignment extends SparseAlignment[NTSymbol] 
    { 
      type GapType = Gap
      val gap = Gap
    } 
  } // DNA
}
