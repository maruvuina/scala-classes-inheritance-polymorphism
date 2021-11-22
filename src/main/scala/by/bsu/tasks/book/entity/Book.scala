package by.bsu.tasks.book.entity

import java.util.Comparator

case class Book(id: Int) extends Id:
  private var _bookName: String = ""
  private var _authors: List[Author] = Nil
  private var _publisher:  String = ""
  private var _yearOfPublishing: Int = 0
  private var _numberOfPages: Int = 0
  private var _price: Float = 0f
  private var _bingingType: BingingType = BingingType.Hard

  def this() = this(0)

  def this(id: Int, bookName: String, authors: List[Author], publisher: String,
           yearOfPublishing: Int, numberOfPages: Int, price: Float, bingingType: BingingType) =
    this(id)
    _bookName = bookName
    _authors = authors
    _publisher = publisher
    _yearOfPublishing = yearOfPublishing
    _numberOfPages = numberOfPages
    _price = price
    _bingingType = bingingType

  def bookName = _bookName
  def bookName_= (x: String) = bookName

  def authors = _authors
  def authors_= (x: List[Author]) = authors

  def publisher = _publisher
  def publisher_= (x: String) = publisher

  def yearOfPublishing = _yearOfPublishing
  def yearOfPublishing_= (x: Int) = yearOfPublishing

  def numberOfPages = _numberOfPages
  def numberOfPages_= (x: Int) = numberOfPages

  def price = _price
  def price_= (x: Float) = price

  def bingingType = _bingingType
  def bingingType_= (x: BingingType) = bingingType

  override def toString: String =
    s"""Book:
       |id = $id
       |bookName = $_bookName
       |authors = $_authors
       |publisher = $_publisher
       |yearOfPublishing = $_yearOfPublishing
       |numberOfPages = $_numberOfPages
       |price = $_price
       |bingingType = $_bingingType""".stripMargin  

  def addAuthor(author: Author) = _authors = _authors :+ author

  class PriceComparator extends Comparator[Book]:
    override def compare(x: Book, y: Book): Int = (x.price - y.price).toInt
   
  implicit def comparatorToOrdering[Book](comporator: Comparator[Book]): Int =
    new Ordering[Book] {
      override def compare(x: Book, y: Book): Int = comporator.compare(x, y)
    }
    
  object Book:
    private var books = List[Book]()
    def addBook(book: Book) = books = books :+ book
    def getBooks() = books