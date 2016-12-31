package model

import play.api.libs.json.{Json, Reads, Writes}

/**
  * Created by camilosampedro on 10/12/16.
  */
package object json {
  implicit val computerJsonWrites: Writes[ComputerJson] = Json.writes[ComputerJson]
  implicit val computerJsonReads: Reads[ComputerJson] = Json.reads[ComputerJson]
  implicit val laboratoryJsonWrites: Writes[LaboratoryJson] = Json.writes[LaboratoryJson]
  implicit val laboratoryJsonReads: Reads[LaboratoryJson] = Json.reads[LaboratoryJson]
}