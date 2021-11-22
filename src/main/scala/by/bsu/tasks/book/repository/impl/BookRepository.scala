package by.bsu.tasks.book.repository.impl

import by.bsu.tasks.book.entity.Book
import by.bsu.tasks.book.repository.Repository

class BookRepository extends Repository:
  type A = Book

  private var bookRepository = List[Book]()

  override def save(item: Book) =
    var isAdded = true
    bookRepository.foreach(book => if(book.id == item.id) isAdded = false)
    if(isAdded)
      bookRepository =  bookRepository :+ item

  override def delete(item: Book) =
    remove(item,  bookRepository)

  override def update(item: Book) =
    bookRepository.foreach(book =>
      if(book.id == item.id)
        book.bookName = item.bookName
    )

  override def findAll():List[Book] = bookRepository

  override def findById(id: Int): Book =
    bookRepository.find(book => book.id == id).get