package model

case class Person(
                   id: Option[Long] = None,
                   name: String,
                   family: String
                 )
