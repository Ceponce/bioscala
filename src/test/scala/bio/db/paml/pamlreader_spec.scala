import bio._

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

package bio.test {

  class PamlReaderSpec extends FlatSpec with ShouldMatchers {
    import bio._
    import bio.DNA._

    "PamlReader" should "read PAML Phylip file" in {
      val pamlreader = new PamlReader("test/data/paml/paml-aln1.phy")
      val (id, seq) = pamlreader.next
      (id) should equal ("PITG_04081T0")
    }
    "PamlReader" should "read PAML Phylip file2" in {
      val pamlreader = new PamlReader("test/data/paml/paml-aln2.phy")
      val (id1, seq1) = pamlreader.next
      val (id2, seq2) = pamlreader.next
      (id1,id2) should equal ("PITG_04081","PITG_18670")
    }
  } // Spec class
} // bio.test
