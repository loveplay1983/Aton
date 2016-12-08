package model.table

import model.{Laboratory, Room}
import slick.driver.H2Driver.api._
import slick.lifted.{ForeignKeyQuery, ProvenShape}

/**
  * Room table map with Slick
  *
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  * @param tag Table tag
  */
class RoomTable(tag: Tag) extends Table[Room](tag, "ROOM") {

  // Laboratory foreign key
  def laboratory: ForeignKeyQuery[LaboratoryTable, Laboratory] = foreignKey("LABORATORY_ID", laboratoryId,
    TableQuery[LaboratoryTable])(_.id, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Cascade)

  // All tables need the * method with the type that it was created the table with.
  override def * : ProvenShape[Room] =
    (id, name, audiovisualResources, basicTools, laboratoryId) <>(Room.tupled, Room.unapply)

  // Primary key
  def id: Rep[Long] = column[Long]("ID", O.PrimaryKey)

  // Other columns/attributes
  def name: Rep[String] = column[String]("NAME")

  def audiovisualResources: Rep[Option[String]] = column[Option[String]]("AUDIOVISUAL_RESOURCES")

  def basicTools: Rep[Option[String]] = column[Option[String]]("BASIC_TOOLS")

  def laboratoryId: Rep[Long] = column[Long]("LABORATORY_ID")
}
