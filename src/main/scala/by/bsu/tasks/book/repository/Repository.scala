package by.bsu.tasks.book.repository

trait Repository:
  type A

  def save(item: A): Unit

  def delete(item: A): Unit

  def update(item: A): Unit

  def findAll(): List[A]

  def findById(id: Int): A

  def remove(item: A, list: List[A]) = list diff List(item)
