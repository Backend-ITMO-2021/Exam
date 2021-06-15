import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration.Inf

object Main {
  def main(args: Array[String]): Unit = {
    lazy val nums = List.fill(4000000)(10000000).map(scala.util.Random.nextInt)
    compare(nums)
  }

  def merge(l1: List[Int], l2: List[Int], lst: List[Int]): List[Int] =
    (l1, l2) match {
      case (Nil, _) => lst.reverse ::: l2
      case (_, Nil) => lst.reverse ::: l1
      case (h1 :: t1, h2 :: t2) => {
        if (h1 < h2) { merge(t1, l2, h1 :: lst) }
        else merge(l1, t2, h2 :: lst)
      }
    }

  def sort(list: List[Int]): List[Int] = {
    list match {
      case Nil      => list
      case h :: Nil => list
      case _ => {
        val (l1, l2) = list.splitAt(list.length / 2)
        merge(sort(l1), sort(l2), Nil)
      }
    }
  }

  def sortParallel(list: List[Int]): Future[List[Int]] = {
    list match {
      case Nil      => Future { list }
      case h :: Nil => Future { list }
      case _ => {
        val (l1, l2) = list.splitAt(list.length / 2)
        var fl = Future { sort(l1) }
        var fr = Future { sort(l2) }
        val flr = fl.zip(fr)
        val lr = Await.result(flr, Inf)
        Future { merge(lr._1, lr._2, Nil) }
      }
    }
  }

  def compare(list: List[Int]): Unit = {
    //sortParallel test
    val startP = System.currentTimeMillis()
    val f = sortParallel(list)
    val res = Await.result(f, Inf)
    val endP = System.currentTimeMillis()
    val timeP = endP - startP
    println(s"Time parallel: $timeP ms")

    //sort test
    val start = System.currentTimeMillis()
    sort(list)
    val end = System.currentTimeMillis()
    val time = end - start
    println(s"Time: $time ms")
  }
}
