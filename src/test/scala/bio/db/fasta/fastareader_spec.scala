import bio._

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

package bio.test {

  class FastaReaderSpec extends FlatSpec with ShouldMatchers {
    "FastaReader" should "read from file" in {
      val f = new FastaReader("./test/data/fasta/nt.fa")
      f.foreach { s => println(s) }

      true
    }
  }
}
