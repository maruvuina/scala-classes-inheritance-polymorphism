package by.bsu.tasks.starsystem.entity

case class Planet(id: Int) extends Id:
  private var _planetName: String = ""
  private var _averageRadius: Int = 0
  private var _gravitationalAcceleration: Double = 0
  private var _hasAtmosphere: Boolean = false
  private var _satellite: List[Satellite] = List()

  def this(id: Int, planetName: String, averageRadius: Int, gravitationalAcceleration: Double,
           hasAtmosphere: Boolean, satellite: List[Satellite]) =
    this(id)
    _planetName = planetName
    _averageRadius = averageRadius
    _gravitationalAcceleration = gravitationalAcceleration
    _hasAtmosphere = hasAtmosphere
    _satellite = satellite

  def planetName = _planetName
  def planetName_= (x: String) = _planetName = planetName

  def averageRadius = _averageRadius
  def averageRadius_= (x: Int) = _averageRadius
  
  def gravitationalAcceleration = _gravitationalAcceleration
  def gravitationalAcceleration_= (x: Double) = _gravitationalAcceleration
  
  def hasAtmosphere = _hasAtmosphere
  def hasAtmosphere_= (x: Boolean) = _hasAtmosphere
  
  def satellite = _satellite
  def satellite_= (x: Satellite) = satellite

  override def toString: String =
    s"""Planet:
       |id = $id
       |planetName = $_planetName
       |averageRadius = $_averageRadius
       |gravitationalAcceleration = $_gravitationalAcceleration
       |hasAtmosphere = $_hasAtmosphere
       |satellite = $_satellite""".stripMargin