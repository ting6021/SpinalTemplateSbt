package test

import spinal.core._
import spinal.lib._

class test_1 (TimeMs : Int) extends Component{
  val io = new Bundle{
    val sigIn = in Bool()
    val clear = in Bool()
    val cnt   = out UInt(32 bits)
  }

  val timeout = Timeout(TimeMs)
  val cnt = Counter(32 bits,io.sigIn.rise(False))
  when(io.clear){
    cnt.value.clearAll()
  }
  when(timeout){
    timeout.clear()
    cnt.value.clearAll()
  }
  //io.cnt := cnt
  io.cnt := RegNextWhen(cnt.value,timeout,U(0,32 bits))
}

object test_1 {
  def main(args: Array[String]) {
    SpinalVerilog(new test_1(TimeMs = 3))
  }
}

