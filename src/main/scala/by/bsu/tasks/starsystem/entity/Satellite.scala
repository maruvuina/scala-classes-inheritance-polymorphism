package by.bsu.tasks.starsystem.entity

final case class Satellite(id: Int) extends Id:
  private var _name: String = ""
  
  def this(id: Int, name: String) =
    this(id)
    _name = name

  def name = _name
  def name_= (x: String) = _name

  override def toString: String =
    s"""Satellite:
       |id = $id
       |name = $_name""".stripMargin