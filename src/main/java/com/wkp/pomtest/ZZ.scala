
package com.wkp.pomtest

import java.util

import com.kuaishou.ad.andromeda.core.rpc.AndromedaClientSafeBuilder
import com.kuaishou.ad.andromeda.core.rpc.client.dto.form.clue.{FormClueDiffFormQueryRequest, FormClueType}
import com.kuaishou.ad.andromeda.core.rpc.client.dto.{ClientConfigDesc, CommonEntityListResponse, OptContextDesc}
import com.kuaishou.ad.andromeda.core.rpc.constants.AdAndromedaBizTypeEnum


object ZZ {

  private def getClueInfo(clueId: Long): Unit = {
    val clueClient = AndromedaClientSafeBuilder.getBuilder(new ClientConfigDesc(AdAndromedaBizTypeEnum.AD_LP)).getConfClueClient
    val request = new FormClueDiffFormQueryRequest();
    val set = new util.HashSet[java.lang.Long]()
    set.add(100L)
    request.setClueIdIn(set)

    val desc = new OptContextDesc()
    desc.setBizType(AdAndromedaBizTypeEnum.AD_LP)
    desc.setAccountId(0L)
    desc.setOptUserId(0L)
    desc.setUserId(0L)

    val response: CommonEntityListResponse[FormClueType] = clueClient.queryFormClueDiffForm(desc, request)
    if (!response.getData.isEmpty) {
      val phone = response.getData.get(0).getPhone
      val userId = response.getData.get(0).getUserId
      val hit_spam_rule_ids = response.getData.get(0).getRiskRules
      val spam_risk_level = response.getData.get(0).getRiskLevel
      //val is_clue_submit_success = response.getData.get(0).getClueStatus ?
    }
  }


  @throws[Exception]
  def main(args: Array[String]): Unit = {
    getClueInfo(100L)
  }
}