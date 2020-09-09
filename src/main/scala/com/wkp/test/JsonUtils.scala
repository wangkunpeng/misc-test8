package com.wkp.test

import com.google.gson.{JsonElement, JsonObject}

/**
 * @Description DESC
 * @Date 2020/9/9 10:23 上午
 * @Created by wangkunpeng
 */
object JsonUtils {

  implicit def element2String(element: JsonElement): String = if (element != null && !element.isJsonNull) element.getAsString else ""

  implicit def element2Int(element: JsonElement): Int = if (element != null && !element.isJsonNull) element.getAsInt else 0

  implicit def element2Long(element: JsonElement): Long = if (element != null && !element.isJsonNull) element.getAsLong else 0L

  implicit def element2Float(element: JsonElement): Float = if (element != null && !element.isJsonNull) element.getAsFloat else 0

  implicit def element2Double(element: JsonElement): Double = if (element != null && !element.isJsonNull) element.getAsDouble else 0

  implicit def element2Boolean(element: JsonElement): Boolean = if (element != null && !element.isJsonNull) element.getAsBoolean else false

  // 数组类型处理
  implicit def element2StringArray(element: JsonElement): java.lang.Iterable[java.lang.String] = {
    if (element != null && !element.isJsonNull) {
      element.getAsJsonArray.asScala.map(_.getAsString).asJava
    } else Iterable.empty[String].asJava
  }

  implicit def element2IntArray(element: JsonElement): java.lang.Iterable[java.lang.Integer] = {
    if (element != null && !element.isJsonNull) {
      element.getAsJsonArray.asScala.map(_.getAsInt.asInstanceOf[java.lang.Integer]).asJava
    } else Iterable.empty[java.lang.Integer].asJava
  }

  implicit def element2LongArray(element: JsonElement): java.lang.Iterable[java.lang.Long] = {
    if (element != null && !element.isJsonNull) {
      element.getAsJsonArray.asScala.map(_.getAsLong.asInstanceOf[java.lang.Long]).asJava
    } else Iterable.empty[java.lang.Long].asJava
  }

  implicit def element2DoubleArray(element: JsonElement): java.lang.Iterable[java.lang.Double] = {
    if (element != null && !element.isJsonNull) {
      element.getAsJsonArray.asScala.map(_.getAsDouble.asInstanceOf[java.lang.Double]).asJava
    } else Iterable.empty[java.lang.Double].asJava
  }

  implicit def element2FloatArray(element: JsonElement): java.lang.Iterable[java.lang.Float] = {
    if (element != null && !element.isJsonNull) {
      element.getAsJsonArray.asScala.map(_.getAsFloat.asInstanceOf[java.lang.Float]).asJava
    } else Iterable.empty[java.lang.Float].asJava
  }

  implicit def element2BooleanArray(element: JsonElement): java.lang.Iterable[java.lang.Boolean] = {
    if (element != null && !element.isJsonNull) {
      element.getAsJsonArray.asScala.map(_.getAsBoolean.asInstanceOf[java.lang.Boolean]).asJava
    } else Iterable.empty[java.lang.Boolean].asJava
  }

  /**
   * 获取JsonElement
   *
   * @param memberName
   * @param jsonObject
   * @return
   */
  def getJsonElement(memberName: String)(implicit jsonObject: JsonObject): JsonElement = {
    if (jsonObject.has(memberName)) {
      jsonObject.get(memberName)
    } else null
  }

}
