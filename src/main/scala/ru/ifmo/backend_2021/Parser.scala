package ru.ifmo.backend_2021

import scalaj.http._



object Parser {
   def parseWiki(name: String): Seq[String] ={
     val response: HttpResponse[String] = Http("https://en.wikipedia.org/w/api.php").params(Map("action"-> "query",
      "format"-> "json",
      "titles"-> name,
      "prop"-> "links")).asString
     if (!response.body.contains("\"missing\":\"\"")){
       val linksArray = response.body.split("\"links\":\\[\\{\"ns\":0,\"title\":\"")(1).split("\"},\\{\"ns\":0,\"title\":\"")
       linksArray(linksArray.length - 1) = linksArray(linksArray.length - 1).split("\"")(0)
       linksArray.to(Seq)
     }else{
       Seq.empty[String]
     }

  }



}
