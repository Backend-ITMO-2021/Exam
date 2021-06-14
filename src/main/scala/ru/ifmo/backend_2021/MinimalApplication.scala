package ru.ifmo.backend_2021

import ru.ifmo.backend_2021.ApplicationUtils.Document

object MinimalApplication extends cask.MainRoutes {

  @cask.get("/")
  def hello(): Document = PageCreator.createList(Seq(Seq()))

  @cask.get("/:pageName/:depth")
  def parsePage(pageName: String, depth: Int) = {
    val parser = Parser
    var names = Seq[Seq[String]]()
    names = names :+ Seq(pageName)
    for (i <- 0 until depth){
      for (name <- names(i)){
        if (names.length == i + 1){
          names = names :+ parser.parseWiki(name)
        }
        else{
          names = names.updated(i+1, names(i+1) :++ parser.parseWiki(name))
        }
      }
    }
    PageCreator.createList(names)
  }

  @cask.postForm("/")
  def formEndpoint(name: String, len: String) = {

    parsePage(name, len.toInt)
  }

  initialize()
}
