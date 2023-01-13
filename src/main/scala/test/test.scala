package test

import spinal.core._
import spinal.lib._

class test extends Component {
  val io = new Bundle {
    val sigIn = in Bool()
    val clear = in Bool()
    val cnt   = out UInt(32 bits)
  }

    val cnt = Reg(UInt(32 bits)) init(0)
    when(io.clear){
      cnt := 0
    }
    when(io.sigIn.rise(False)){
      cnt := cnt + 1
    }
    io.cnt := cnt

//    val cnt = Counter(32 bits,io.sigIn.rise(False))
//    when(io.clear){
//      cnt.value.clearAll()
//    }
//    io.cnt := cnt.value
}

object test {
  def main(args: Array[String]) {
    SpinalVerilog(new test)
  }
}

