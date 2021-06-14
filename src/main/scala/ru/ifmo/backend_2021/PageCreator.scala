package ru.ifmo.backend_2021

import ru.ifmo.backend_2021.ApplicationUtils.Document
import scalatags.Text.all.{p, _}

object PageCreator {
  def createList(data: Seq[Seq[String]]): Document = doctype("html")(
    {

      html(
        head(
          link(rel := "stylesheet", href := ApplicationUtils.styles)
        ),
        body(
          div(
            form(action := "/", method := "post")(
            input(attr("name"):="name"),
            input(attr("name"):="len"),
            input(attr("type"):= "submit", attr("value"):="go"))
          ),
          div(
            for (i <- 0 until data.length) yield div(
              b(s"Depth $i" ),
              p( for (j <- 0 until data(i).length) yield span(
                a(attr("href"):=createLink(data(i)(j)))(
                data(i)(j)),
                if(j + 1 != data(i).length ) " - "
                )
              )
            )
          )
        )
      )
    })

  def createLink(name:String): String ={
    "https://en.wikipedia.org/wiki/" + name
  }
}
