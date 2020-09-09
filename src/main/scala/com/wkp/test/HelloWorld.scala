package com.wkp.test

import com.google.gson.{Gson, JsonElement}

object HelloWorld {


  case class Test(temType: String, engineType: String)

  case class FanstopChargeInfoModule(bidType: Long, itemType: String, engineType: String)

  implicit def element2Long(element: Object): Long = 11199999

  implicit def element2Long(element: JsonElement): Long = if (element != null && !element.isJsonNull) element.getAsLong else 0L


  def main(args: Array[String]): Unit = {

    val gson: Gson = new Gson()

    val test = Test("8888", "test1")

    val testString = gson.toJsonTree(test).getAsJsonObject.get("temType")
    println(gson.toJsonTree(test).getAsJsonObject.get("temType"))


    val fans = FanstopChargeInfoModule("1", "1", "1")
    println("2 " + fans)

    //val fans1 = FanstopChargeInfoModule(gson.toJsonTree(test).getAsJsonObject.get("temType"), "1", "1")

    val fans1 = FanstopChargeInfoModule("99999", "1", "1")
    println("3 " + fans1)


    val fans2 = FanstopChargeInfoModule(gson.toJsonTree(test).getAsJsonObject.get("temType"), "1", "1")
    println("4 " + fans2)


  }
}