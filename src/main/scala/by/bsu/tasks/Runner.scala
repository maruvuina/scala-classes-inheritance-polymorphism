package by.bsu.tasks

import by.bsu.tasks.book.entity.{Author, BingingType, Book}
import by.bsu.tasks.book.repository.impl.BookRepository
import by.bsu.tasks.starsystem.entity.{Planet, Satellite, Star, StarSystem}

object Runner {
  @main def main =
    val star = new Star(1, "Sun", 15_700_000, 3.828e26)
    val satellite = new Satellite(11, "Moon")
    val planets = List()
    val stars = List(star)
    val solarSystem = new StarSystem(111, "SolarSystem", planets, stars)
    println(solarSystem)
    solarSystem.addPlanet(new Planet(2222, "Earth", 6371, 9.780327d, true, List(satellite)))
    println("------")

    val book1 = new Book(1, "Java from EPAM", List(new Author(11, "Блинов, И. Н."), new Author(22, "Романчик, В. С.")),
      "Четыре четверти", 2020, 560, 40, BingingType.Soft)
    val book2 = new Book(2, "Java Методы программировния", List(new Author(11, "Блинов, И. Н."), new Author(22, "Романчик, В. С.")),
      "Четыре четверти", 2013, 896, 30, BingingType.Soft)
    val book3 = new Book(3, "Java. Полное руководство", List(new Author(33, "Герберт Шилдт")),
    "Альфа-книга", 2019, 1488, 45,  BingingType.Hard)

    val bookRepository = new BookRepository()
    bookRepository.save(book1)
    bookRepository.save(book2)
    bookRepository.save(book3)

    val books = bookRepository.findAll()
    val authorName = "Блинов, И. Н."
    var booksByAuthor = List[Book]()
    for (book <- books) {
      for (author <- book.authors) {
        if (author.authorName.equals(authorName))
          booksByAuthor = booksByAuthor :+ book
      }
    }
    println(booksByAuthor)
}
