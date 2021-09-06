package com.qbrainx.application

import com.qbrainx.util.ProducerProperties.properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import scala.annotation.tailrec
import scala.io.StdIn

object ProducerImp extends App {
  val producer: KafkaProducer[String, String] = new KafkaProducer[String, String](properties)
  val topic = "testa"
  @tailrec
  def write(i: Int): Unit = {
    val msg = StdIn.readLine()
    val record: ProducerRecord[String, String] = new ProducerRecord(topic, s"${i + 1}", msg)
    producer.send(record)
    write(i + 1)
  }
  write(0)
}
