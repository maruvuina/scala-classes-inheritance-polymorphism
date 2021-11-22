package by.bsu.tasks.starsystem.entity

case class Star(id: Int) extends Id:
  private var _starName: String = ""
  private var _coreTemperature: Int = 0
  private var _luminosity: Double = 0

  def this(id: Int, starName: String, coreTemperature: Int, luminosity: Double) =
    this(id)
    _starName = starName
    _coreTemperature = coreTemperature
    _luminosity = luminosity

  def starName = _starName
  def starName_= (x: String) = starName
  
  def coreTemperature = _coreTemperature
  def coreTemperature_=(x: Int) = coreTemperature
  
  def luminosity = _luminosity
  def luminosity_= (x: Double) = luminosity

  override def toString: String =
    s"""Star:
       |id = $id
       |starName = $_starName
       |coreTemperature = $_coreTemperature
       |luminosity = $_luminosity""".stripMargin