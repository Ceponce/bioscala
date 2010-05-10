/**
 * The (immutable) Nucleotide sequence class represents a list of DNA, or RNA,
 * nucleotides. Each sequence can carry a list of attributes, including the
 * ID(s) and description(s).
 * <p>
 * Contrasting with most Bio* implementations, the Sequence class represents
 * the contained nucleotides as a List, not as a String. Also a Sequence may be
 * represented by multiple ID's and descriptions in the form of flexible
 * attributes.
 */

import bio._
import bio.attribute._

package bio {

  abstract class Sequence(nucleotidelist: List[Nucleotide], attributelist: List[Attribute]) extends AttributeAccess {
    lazy val nucleotides = nucleotidelist
    lazy val attributes  = attributelist

    // transcribe() is defined in the base class because it is used by translate()
    def transcribe(): Sequence
    def translate() = { SequenceTranslation.translate(
                          transcribe nucleotides) }

    /** @return Nucleotide List as a String */
    override def toString = nucleotides mkString
    /** @return Nucleotide List */
    def toList = nucleotides
    /**
     * @return first (primary) ID in attribute list
     */
    def idList = attribList(GetId, attributes)
    def descriptionList = attribList(GetDescription, attributes)
    def id = attribFirst(GetId, attributes).toString
    /**
     * @return first (priamary) Description in attribute list
     */
    def description = attribFirst(GetDescription, attributes).toString
  }

  package DNA {
    class Sequence(nucleotidelist: List[Nucleotide], attributelist: List[Attribute]) extends bio.Sequence(nucleotidelist, attributelist) {
      def this(list: List[Nucleotide]) = this(NucleotideConvert.fromList(list),Nil)
      def this(str: String) = this(NucleotideConvert.fromString(str),Nil)
      def this(id: String, str: String) = this(NucleotideConvert.fromString(str), List(Id(id)))
      def this(id: String, descr: String, str: String) = this(NucleotideConvert.fromString(str),List(Id(id),Description(descr)))
      def this(seq: Sequence) = this(seq.nucleotides, Nil)

      /**
       * Add an attribute to Sequence and return a new Sequence object
       */
      def attrAdd(attribute: Attribute) = {
        val attrlist = attribute :: attributes 
        new Sequence(nucleotides, attrlist)
      }
      /**
       * Add a list of attributes to Sequence and return a new Sequence object
       */
      def attrAdd(attributelist: List[Attribute]) = {
        val attrlist = attributes ::: attributelist
        new Sequence(nucleotides, attrlist)
      }

      /**
       * @return transcribed DNA.Sequence as RNA.Sequence
       */
      override def transcribe = { 
        val transcribed = SequenceTranscription.transcribe(nucleotides) 
        new RNA.Sequence(transcribed)
      }
      /**
       * @return complementary DNA.Sequence
       */
      def complement = SequenceTranscription.complement(nucleotides)
    }
  }

  package RNA {
    class Sequence(nucleotidelist: List[Nucleotide], attributelist: List[Attribute]) extends bio.Sequence(nucleotidelist, attributelist) {
      def this(list: List[Nucleotide]) = this(NucleotideConvert.fromList(list),Nil)
      def this(str: String) = this(NucleotideConvert.fromString(str),Nil)
      def this(seq: Sequence) = this(seq.nucleotides, Nil)
      def this(id: String, str: String) = this(NucleotideConvert.fromString(str), List(Id(id)))
      def this(id: String, descr: String, str: String) = this(NucleotideConvert.fromString(str),List(Id(id),Description(descr)))

      /**
       * @return itself (source is immutable)
       */
      override def transcribe = { this }

      def attrAdd(attribute: Attribute) = {
        val attrlist = attribute :: attributes 
        new Sequence(nucleotides, attrlist)
      }
      def attrAdd(attributelist: List[Attribute]) = {
        val attrlist = attributes ::: attributelist
        new Sequence(nucleotides, attrlist)
      }
    }
  }
}
