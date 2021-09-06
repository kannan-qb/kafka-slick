package com.qbrainx.model
import com.qbrainx.config.SlickConfig

import com.qbrainx.model.StudentDatabase.schema
import slick.jdbc.JdbcBackend
import slick.lifted.ProvenShape
import com.qbrainx.config.SlickConfig.jdbcProfile.api._

import scala.concurrent.Future
class StudentDatabase {
  val db: JdbcBackend#DatabaseDef = SlickConfig.db
  private val query: TableQuery[schema] =TableQuery(new schema(_))
  def insert(studentdata:Student):Future[Int]=db.run(query+=studentdata)
}

object StudentDatabase{

  val tableName="Student"
  final class schema(tag:Tag) extends Table[Student](tag,tableName) {
    private def name=column[String]("Name")
    private def rollno=column[Int]("RollNo",O.PrimaryKey)
    private def section=column[Char]("Section")
    private def mobileno=column[Long]("Mobileno")

    override def * : ProvenShape[Student] = (name,rollno,section,mobileno.?)<>(Student.tupled,Student.unapply)
  }
}

