package by.bsu.tasks.book.entity

case class Author(id: Int) extends Id:
  private var _authorName: String = ""
  
  def this() = this(0)
  
  def this(id: Int, authorName: String) =
    this(0)
    _authorName = authorName

  def authorName = _authorName
  def authorName_= (x: String) = authorName
  
  override def toString: String =
    s"""StarSystem:
       |id = $id
       |athorName = $_authorName""".stripMargin    