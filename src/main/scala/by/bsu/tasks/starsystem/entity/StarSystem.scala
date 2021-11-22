package by.bsu.tasks.starsystem.entity

case class StarSystem(id: Int) extends Id:
  private var _name: String = ""
  private var _planets: List[Planet] = List()
  private var _stars: List[Star] = List()

  def this(id: Int, name: String, planets: List[Planet], stars: List[Star]) =
    this(id)
    _name = name
    _planets = planets
    _stars = stars

  def planets = _planets
  def planets_= (x: List[Planet]) = planets

  override def toString: String =
    s"""StarSystem:
       |id = $id
       |name = $_name
       |planets = $_planets
       |stars = $_stars""".stripMargin

  def getPlanetCount: Int = StarSystem.getPlanetCount(_planets)
  
  def addPlanet(planet: Planet) = _planets = _planets :+ planet

object StarSystem:
  private def getPlanetCount(planets: List[Planet]): Int = planets.size