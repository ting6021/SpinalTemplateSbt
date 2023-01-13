package Timer

import spinal.core._
import spinal.lib._
import spinal.lib.bus.amba3.apb.{Apb3, Apb3Config}
import spinal.lib.bus.regif.AccessType.{RO, RW}
import spinal.lib.bus.regif._
import spinal.lib.bus.regif.Apb3BusInterface

  class Apb3Slave extends Component {
  val io = new Bundle {
    val apb = slave(Apb3(Apb3Config(32,32)))
  }

  val busif = Apb3BusInterface(io.apb,(0x30000000,104 Byte),regPre = "AP")

  val TIMx_CR1 = busif.newReg(doc = "TIMx_CR1:控制寄存器1")
    val CEN = TIMx_CR1.field(Bool(),RW,0,"CEN:")
    val UDIS = TIMx_CR1.field(Bool(),RW,0,"UDIS:")
    val URS = TIMx_CR1.field(Bool(),RW,0,"URS:")
    val OPM = TIMx_CR1.field(Bool(),RW,0,"OPM:")
    val DIR = TIMx_CR1.field(Bool(),RW,0,"DIR:")
    val CMS = TIMx_CR1.field(Bits(2 bit),RW,0,"CMS:")
    val ARPE = TIMx_CR1.field(Bool(),RW,0,"ARPE:")
    val CKD = TIMx_CR1.field(Bits(2 bit),RW,0,"CKD:")
    TIMx_CR1.reserved(1 bit)
    val UIFREMAP = TIMx_CR1.field(Bool(),RW,0,"UIFREMAP:")

  val TIMx_CR2 = busif.newReg(doc = "TIMx_CR2:")
    val CCPC = TIMx_CR2.field(Bool(),RW,0,"CCPC:")
    TIMx_CR2.reserved(1 bit)
    val CCUS = TIMx_CR2.field(Bool(),RW,0,"CCUS")
    val CCDS = TIMx_CR2.field(Bool(),RW,0,"CCDS")
    val MMS = TIMx_CR2.field(Bits(2 bit),RW,0,"MMS")
    val TI1S = TIMx_CR2.field(Bool(),RW,0,"TI1S")
    val OIS1 = TIMx_CR2.field(Bool(),RW,0,"OIS1")
    val OIS1N = TIMx_CR2.field(Bool(),RW,0,"OIS1N")
    val OIS2 = TIMx_CR2.field(Bool(),RW,0,"OIS2")
    val OIS2N = TIMx_CR2.field(Bool(),RW,0,"OIS2N")
    val OIS3 = TIMx_CR2.field(Bool(),RW,0,"OIS3")
    val OIS3N = TIMx_CR2.field(Bool(),RW,0,"OIS3N")
    val OIS4 = TIMx_CR2.field(Bool(),RW,0,"OIS4")
    TIMx_CR2.reserved(1 bit)
    val OIS5 = TIMx_CR2.field(Bool(),RW,0,"OIS5")
    TIMx_CR2.reserved(1 bit)
    val OIS6 = TIMx_CR2.field(Bool(),RW,0,"OIS6")
    TIMx_CR2.reserved(1 bit)
    val MMS2 = TIMx_CR2.field(Bits(4 bit),RW,0,"MMS2")

  val TIMx_SMCR = busif.newReg(doc = "TIMx_SMCR")
    val SMS_0_2 = TIMx_SMCR.field(Bits(3 bit),RW,0,"SMS")
    TIMx_SMCR.reserved(1 bit)
    val TS_0_2 = TIMx_SMCR.field(Bits(3 bit),RW,0,"TS")
    val MSM = TIMx_SMCR.field(Bool(),RW,0,"MSM")
    val ETF = TIMx_SMCR.field(Bits(4 bit),RW,0,"ETF")
    val ETPS = TIMx_SMCR.field(Bits(2 bit),RW,0,"ETPS")
    val ECE = TIMx_SMCR.field(Bool(),RW,0,"ECE")
    val ETP = TIMx_SMCR.field(Bool(),RW,0,"ETP")
    val SMS_3 = TIMx_SMCR.field(Bool(),RW,0,"SMS_3")
    TIMx_SMCR.reserved(3 bit)
    val TS_3_4 = TIMx_SMCR.field(Bits(2 bit),RW,0,"TS")




  val TIMx_DIER = busif.newReg(doc = "TIMx_DIER")
  val TIMx_SR = busif.newReg(doc = "TIMx_SR")
  val TIMx_EGR = busif.newReg(doc = "TIMx_EGR")
  val TIMx_CCMR1 = busif.newReg(doc = "TIMx_CCMR1")
  val TIMx_CCMR2 = busif.newReg(doc = "TIMx_CCMR2")
  val TIMx_CCER = busif.newReg(doc = "TIMx_CCER")
  val TIMx_CNT = busif.newReg(doc = "TIMx_CNT")
  val TIMx_PSC = busif.newReg(doc = "TIMx_PSC")
  val TIMx_ARR = busif.newReg(doc = "TIMx_ARR")
  val TIMx_RCR = busif.newReg(doc = "TIMx_RCR")
  val TIMx_CCR1 = busif.newReg(doc = "TIMx_CCR1")
  val TIMx_CCR2 = busif.newReg(doc = "TIMx_CCR2")
  val TIMx_CCR3 = busif.newReg(doc = "TIMx_CCR3")
  val TIMx_CCR4 = busif.newReg(doc = "TIMx_CCR4")
  val TIMx_BDTR = busif.newReg(doc = "TIMx_BDTR")
  val TIMx_DCR = busif.newReg(doc = "TIMx_DCR")
  val TIMx_DMAR = busif.newReg(doc = "TIMx_DMAR")
  val TIMx_CCMR3 = busif.newReg(doc = "TIMx_CCMR3")
  val TIMx_CCR5 = busif.newReg(doc = "TIMx_CCR5")
  val TIMx_CCR6 = busif.newReg(doc = "TIMx_CCR6")
  val TIMx_AF1 = busif.newReg(doc = "TIMx_AF1")
  val TIMx_AF2 = busif.newReg(doc = "TIMx_AF2")
  val TIMx_TISEL = busif.newReg(doc = "TIMx_TISEL")


}

object Apb3Slave {
  def main(args: Array[String]) {
    SpinalVerilog(new Apb3Slave)
  }
}
