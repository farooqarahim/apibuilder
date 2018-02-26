/**
 * Generated by API Builder - https://www.apibuilder.io
 * Service version: 0.13.29
 * apibuilder 0.14.3 app.apibuilder.io/apicollective/apibuilder-common/0.13.29/anorm_2_6_parsers
 */
import anorm._

package io.apibuilder.common.v0.anorm.parsers {

  import io.apibuilder.common.v0.anorm.conversions.Standard._

  import io.apibuilder.common.v0.anorm.conversions.Types._

  object Audit {

    def parserWithPrefix(prefix: String, sep: String = "_"): RowParser[io.apibuilder.common.v0.models.Audit] = parser(prefixOpt = Some(s"$prefix$sep"))

    def parser(
      createdAt: String = "created_at",
      createdByPrefix: String = "created_by",
      updatedAt: String = "updated_at",
      updatedByPrefix: String = "updated_by",
      prefixOpt: Option[String] = None
    ): RowParser[io.apibuilder.common.v0.models.Audit] = {
      SqlParser.get[_root_.org.joda.time.DateTime](prefixOpt.getOrElse("") + createdAt) ~
      io.apibuilder.common.v0.anorm.parsers.ReferenceGuid.parserWithPrefix(prefixOpt.getOrElse("") + createdByPrefix) ~
      SqlParser.get[_root_.org.joda.time.DateTime](prefixOpt.getOrElse("") + updatedAt) ~
      io.apibuilder.common.v0.anorm.parsers.ReferenceGuid.parserWithPrefix(prefixOpt.getOrElse("") + updatedByPrefix) map {
        case createdAt ~ createdBy ~ updatedAt ~ updatedBy => {
          io.apibuilder.common.v0.models.Audit(
            createdAt = createdAt,
            createdBy = createdBy,
            updatedAt = updatedAt,
            updatedBy = updatedBy
          )
        }
      }
    }

  }

  object Healthcheck {

    def parserWithPrefix(prefix: String, sep: String = "_"): RowParser[io.apibuilder.common.v0.models.Healthcheck] = parser(prefixOpt = Some(s"$prefix$sep"))

    def parser(
      status: String = "status",
      prefixOpt: Option[String] = None
    ): RowParser[io.apibuilder.common.v0.models.Healthcheck] = {
      SqlParser.str(prefixOpt.getOrElse("") + status) map {
        case status => {
          io.apibuilder.common.v0.models.Healthcheck(
            status = status
          )
        }
      }
    }

  }

  object Reference {

    def parserWithPrefix(prefix: String, sep: String = "_"): RowParser[io.apibuilder.common.v0.models.Reference] = parser(prefixOpt = Some(s"$prefix$sep"))

    def parser(
      guid: String = "guid",
      key: String = "key",
      prefixOpt: Option[String] = None
    ): RowParser[io.apibuilder.common.v0.models.Reference] = {
      SqlParser.get[_root_.java.util.UUID](prefixOpt.getOrElse("") + guid) ~
      SqlParser.str(prefixOpt.getOrElse("") + key) map {
        case guid ~ key => {
          io.apibuilder.common.v0.models.Reference(
            guid = guid,
            key = key
          )
        }
      }
    }

  }

  object ReferenceGuid {

    def parserWithPrefix(prefix: String, sep: String = "_"): RowParser[io.apibuilder.common.v0.models.ReferenceGuid] = parser(prefixOpt = Some(s"$prefix$sep"))

    def parser(
      guid: String = "guid",
      prefixOpt: Option[String] = None
    ): RowParser[io.apibuilder.common.v0.models.ReferenceGuid] = {
      SqlParser.get[_root_.java.util.UUID](prefixOpt.getOrElse("") + guid) map {
        case guid => {
          io.apibuilder.common.v0.models.ReferenceGuid(
            guid = guid
          )
        }
      }
    }

  }

}