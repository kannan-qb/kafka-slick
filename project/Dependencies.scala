import sbt._
object Dependencies {
  lazy val slickVersion = "3.3.3"
  lazy val mysqlConnectorJavaVersion = "8.0.26"
  lazy val sprayjsonVersion = "1.3.6"
  lazy val kafkaVersion = "2.8.0"
  lazy val typeSafeConfigVersion = "1.4.1"
  lazy val sprayJson =  "io.spray" %% "spray-json" % sprayjsonVersion
  lazy val slick = "com.typesafe.slick" %% "slick" % slickVersion
  lazy val slickHikariCp = "com.typesafe.slick" %% "slick-hikaricp" % slickVersion
  lazy val mysqlConnectorJava = "mysql" % "mysql-connector-java" % mysqlConnectorJavaVersion
  lazy val  kafkaclient = "org.apache.kafka" % "kafka-clients" % kafkaVersion
  def compileDependencies: Seq[ModuleID] =
    Seq(slick, slickHikariCp, mysqlConnectorJava,kafkaclient,sprayJson)

}
