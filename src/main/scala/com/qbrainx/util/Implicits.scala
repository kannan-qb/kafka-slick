package com.qbrainx.util

import com.qbrainx.model.Student
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

object Implicits extends DefaultJsonProtocol {
  implicit val dataFormat: RootJsonFormat[Student] = jsonFormat4(Student)

}
