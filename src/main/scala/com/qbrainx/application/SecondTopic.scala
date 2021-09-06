package com.qbrainx.application
import com.qbrainx.application.ProducerImp.producer
import com.qbrainx.util.ProducerProperties.properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import scala.annotation.tailrec
import scala.io.StdIn
object SecondTopic extends App{
  val topic2 = "testb"
  @tailrec
  def writetoSecond(i: Int): Unit = {
    val msg2 = StdIn.readLine()
    val producer1: KafkaProducer[String, String] = new KafkaProducer[String, String](properties)
    producer1.send(new ProducerRecord(topic2, s"${i + 1}", msg2))
    writetoSecond(i + 1)
  }
  writetoSecond(0)
}
