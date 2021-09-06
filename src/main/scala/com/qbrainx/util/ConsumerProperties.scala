package com.qbrainx.util

import java.util.Properties

object ConsumerProperties {
  val consumerproperties: Properties = new Properties()
  consumerproperties.put("bootstrap.servers", "localhost:9092")
  consumerproperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  consumerproperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  consumerproperties.put("group.id", "test-consumer-group")


}
