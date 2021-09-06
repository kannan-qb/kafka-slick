package com.qbrainx.application

import com.qbrainx.model.{Student, StudentDatabase}
import com.qbrainx.util.ConsumerProperties.consumerproperties
import com.qbrainx.util.Implicits.dataFormat
import org.apache.kafka.clients.consumer.{ConsumerRecords, KafkaConsumer}

import scala.jdk.CollectionConverters.IterableHasAsScala
import java.time.Duration
import java.util
import spray.json._

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


object ConsumerImp extends App {

  val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](consumerproperties)
  consumer.subscribe(util.Arrays.asList("testa", "testb"))
  val studentdata: StudentDatabase = new StudentDatabase
  val studentlist: mutable.ListBuffer[Student] = scala.collection.mutable.ListBuffer.empty

  def addtoList(student: Student): Unit = studentlist.append(student)
  def inserttoTable(list:mutable.ListBuffer[Student]): Unit ={
    for (elements <- list){
      studentdata.insert(elements)
    }
  }

  def toConsume(i: Int): Unit = {
    val records: ConsumerRecords[String, String] = consumer.poll(Duration.ofMillis(100))

    for(j <- records.asScala) {
      val b: String = j.value()
      val a: String = j.topic()
      a match {
        case "testa" => val student= b.parseJson.convertTo[Student]
                                  addtoList(student)
                                  println(studentlist)

        case "testb" => b match {
          case "A" => val a1: ListBuffer[Student] = studentlist.filter(f => f.section == 'A')
                      inserttoTable(a1)
          case "B" => val b1: ListBuffer[Student] = studentlist.filter(f => f.section == 'B')
                      inserttoTable(b1)
          case "C" => val c: ListBuffer[Student] = studentlist.filter(f => f.section == 'C')
                      inserttoTable(c)
          case _  => println("Invalid")
        }
      }

    }
    toConsume(i+1)
  }
  toConsume(0)
}
