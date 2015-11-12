/**
 * Generated by apidoc - http://www.apidoc.me
 * Service version: 0.9.40-dev
 * apidoc:0.9.44 http://www.apidoc.me/bryzek/apidoc-common/0.9.40-dev/play_2_x_json
 */
package com.bryzek.apidoc.common.v0.models {

  case class Audit(
    createdAt: _root_.org.joda.time.DateTime,
    createdBy: com.bryzek.apidoc.common.v0.models.ReferenceGuid,
    updatedAt: _root_.org.joda.time.DateTime,
    updatedBy: com.bryzek.apidoc.common.v0.models.ReferenceGuid
  )

  case class Healthcheck(
    status: String
  )

  /**
   * Represents a reference to another model.
   */
  case class Reference(
    guid: _root_.java.util.UUID,
    key: String
  )

  case class ReferenceGuid(
    guid: _root_.java.util.UUID
  )

}

package com.bryzek.apidoc.common.v0.models {

  package object json {
    import play.api.libs.json.__
    import play.api.libs.json.JsString
    import play.api.libs.json.Writes
    import play.api.libs.functional.syntax._
    import com.bryzek.apidoc.common.v0.models.json._

    private[v0] implicit val jsonReadsUUID = __.read[String].map(java.util.UUID.fromString)

    private[v0] implicit val jsonWritesUUID = new Writes[java.util.UUID] {
      def writes(x: java.util.UUID) = JsString(x.toString)
    }

    private[v0] implicit val jsonReadsJodaDateTime = __.read[String].map { str =>
      import org.joda.time.format.ISODateTimeFormat.dateTimeParser
      dateTimeParser.parseDateTime(str)
    }

    private[v0] implicit val jsonWritesJodaDateTime = new Writes[org.joda.time.DateTime] {
      def writes(x: org.joda.time.DateTime) = {
        import org.joda.time.format.ISODateTimeFormat.dateTime
        val str = dateTime.print(x)
        JsString(str)
      }
    }

    implicit def jsonReadsApidoccommonAudit: play.api.libs.json.Reads[Audit] = {
      (
        (__ \ "created_at").read[_root_.org.joda.time.DateTime] and
        (__ \ "created_by").read[com.bryzek.apidoc.common.v0.models.ReferenceGuid] and
        (__ \ "updated_at").read[_root_.org.joda.time.DateTime] and
        (__ \ "updated_by").read[com.bryzek.apidoc.common.v0.models.ReferenceGuid]
      )(Audit.apply _)
    }

    implicit def jsonWritesApidoccommonAudit: play.api.libs.json.Writes[Audit] = {
      (
        (__ \ "created_at").write[_root_.org.joda.time.DateTime] and
        (__ \ "created_by").write[com.bryzek.apidoc.common.v0.models.ReferenceGuid] and
        (__ \ "updated_at").write[_root_.org.joda.time.DateTime] and
        (__ \ "updated_by").write[com.bryzek.apidoc.common.v0.models.ReferenceGuid]
      )(unlift(Audit.unapply _))
    }

    implicit def jsonReadsApidoccommonHealthcheck: play.api.libs.json.Reads[Healthcheck] = {
      (__ \ "status").read[String].map { x => new Healthcheck(status = x) }
    }

    implicit def jsonWritesApidoccommonHealthcheck: play.api.libs.json.Writes[Healthcheck] = new play.api.libs.json.Writes[Healthcheck] {
      def writes(x: Healthcheck) = play.api.libs.json.Json.obj(
        "status" -> play.api.libs.json.Json.toJson(x.status)
      )
    }

    implicit def jsonReadsApidoccommonReference: play.api.libs.json.Reads[Reference] = {
      (
        (__ \ "guid").read[_root_.java.util.UUID] and
        (__ \ "key").read[String]
      )(Reference.apply _)
    }

    implicit def jsonWritesApidoccommonReference: play.api.libs.json.Writes[Reference] = {
      (
        (__ \ "guid").write[_root_.java.util.UUID] and
        (__ \ "key").write[String]
      )(unlift(Reference.unapply _))
    }

    implicit def jsonReadsApidoccommonReferenceGuid: play.api.libs.json.Reads[ReferenceGuid] = {
      (__ \ "guid").read[_root_.java.util.UUID].map { x => new ReferenceGuid(guid = x) }
    }

    implicit def jsonWritesApidoccommonReferenceGuid: play.api.libs.json.Writes[ReferenceGuid] = new play.api.libs.json.Writes[ReferenceGuid] {
      def writes(x: ReferenceGuid) = play.api.libs.json.Json.obj(
        "guid" -> play.api.libs.json.Json.toJson(x.guid)
      )
    }
  }
}

package com.bryzek.apidoc.common.v0 {

  object Bindables {

    import play.api.mvc.{PathBindable, QueryStringBindable}
    import org.joda.time.{DateTime, LocalDate}
    import org.joda.time.format.ISODateTimeFormat
    import com.bryzek.apidoc.common.v0.models._

    // Type: date-time-iso8601
    implicit val pathBindableTypeDateTimeIso8601 = new PathBindable.Parsing[org.joda.time.DateTime](
      ISODateTimeFormat.dateTimeParser.parseDateTime(_), _.toString, (key: String, e: Exception) => s"Error parsing date time $key. Example: 2014-04-29T11:56:52Z"
    )

    implicit val queryStringBindableTypeDateTimeIso8601 = new QueryStringBindable.Parsing[org.joda.time.DateTime](
      ISODateTimeFormat.dateTimeParser.parseDateTime(_), _.toString, (key: String, e: Exception) => s"Error parsing date time $key. Example: 2014-04-29T11:56:52Z"
    )

    // Type: date-iso8601
    implicit val pathBindableTypeDateIso8601 = new PathBindable.Parsing[org.joda.time.LocalDate](
      ISODateTimeFormat.yearMonthDay.parseLocalDate(_), _.toString, (key: String, e: Exception) => s"Error parsing date $key. Example: 2014-04-29"
    )

    implicit val queryStringBindableTypeDateIso8601 = new QueryStringBindable.Parsing[org.joda.time.LocalDate](
      ISODateTimeFormat.yearMonthDay.parseLocalDate(_), _.toString, (key: String, e: Exception) => s"Error parsing date $key. Example: 2014-04-29"
    )



  }

}
