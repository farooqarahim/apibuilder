/**
 * Generated by API Builder - https://www.apibuilder.io
 * Service version: 0.13.29
 * apibuilder 0.14.3 app.apibuilder.io/apicollective/apibuilder-generator/0.13.29/play_2_6_client
 */
package io.apibuilder.generator.v0.models {

  /**
   * An attribute represents a key/value pair that is optionally used to provide
   * additional instructions / data to the code generator. An example could be an
   * attribute to specify the root import path for a go client..
   */
  case class Attribute(
    name: String,
    value: String
  )

  /**
   * @param code Machine readable code for this specific error message
   * @param message Description of the error
   */
  case class Error(
    code: String,
    message: String
  )

  /**
   * Represents a source file
   * 
   * @param name The recommended name for the file.
   * @param dir The recommended directory path for the file where appropriate.
   * @param contents The actual source code.
   */
  case class File(
    name: String,
    dir: _root_.scala.Option[String] = None,
    contents: String,
    flags: _root_.scala.Option[Seq[io.apibuilder.generator.v0.models.FileFlag]] = None
  )

  /**
   * The generator metadata.
   * 
   * @param language A comma separate list of the programming language(s) that this generator
   *        produces
   * @param attributes The list of attributes that this code generator can use. You can find the full
   *        list of available attributes and their descriptions at
   *        http://apibuilder.io/doc/attributes
   */
  case class Generator(
    key: String,
    name: String,
    language: _root_.scala.Option[String] = None,
    description: _root_.scala.Option[String] = None,
    attributes: Seq[String] = Nil
  )

  case class Healthcheck(
    status: String
  )

  /**
   * The result of invoking a generator.
   * 
   * @param source The actual source code.
   * @param files A collection of source files
   */
  case class Invocation(
    @deprecated("Use files instead") source: String,
    files: Seq[io.apibuilder.generator.v0.models.File]
  )

  /**
   * The invocation form is the payload send to the code generators when requesting
   * generation of client code.
   */
  case class InvocationForm(
    service: io.apibuilder.spec.v0.models.Service,
    attributes: Seq[io.apibuilder.generator.v0.models.Attribute] = Nil,
    userAgent: _root_.scala.Option[String] = None
  )

  /**
   * Allows generator authors to flag files with special characteristics. It is up to
   * the client (i.e. the cli) to decide how to interpret them.
   */
  sealed trait FileFlag extends _root_.scala.Product with _root_.scala.Serializable

  object FileFlag {

    /**
     * Indicates files that an end user starts from but should edit. Not intended to be
     * the final product (see:
     * https://stackoverflow.com/questions/235018/what-is-scaffolding-is-it-a-term-for-a-particular-platform).
     * Consider not overwriting these files when code is re-generated.
     */
    case object Scaffolding extends FileFlag { override def toString = "scaffolding" }

    /**
     * UNDEFINED captures values that are sent either in error or
     * that were added by the server after this library was
     * generated. We want to make it easy and obvious for users of
     * this library to handle this case gracefully.
     *
     * We use all CAPS for the variable name to avoid collisions
     * with the camel cased values above.
     */
    case class UNDEFINED(override val toString: String) extends FileFlag

    /**
     * all returns a list of all the valid, known values. We use
     * lower case to avoid collisions with the camel cased values
     * above.
     */
    val all: scala.List[FileFlag] = scala.List(Scaffolding)

    private[this]
    val byName: Map[String, FileFlag] = all.map(x => x.toString.toLowerCase -> x).toMap

    def apply(value: String): FileFlag = fromString(value).getOrElse(UNDEFINED(value))

    def fromString(value: String): _root_.scala.Option[FileFlag] = byName.get(value.toLowerCase)

  }

}

package io.apibuilder.generator.v0.models {

  package object json {
    import play.api.libs.json.__
    import play.api.libs.json.JsString
    import play.api.libs.json.Writes
    import play.api.libs.functional.syntax._
    import io.apibuilder.common.v0.models.json._
    import io.apibuilder.generator.v0.models.json._
    import io.apibuilder.spec.v0.models.json._

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

    private[v0] implicit val jsonReadsJodaLocalDate = __.read[String].map { str =>
      import org.joda.time.format.ISODateTimeFormat.dateParser
      dateParser.parseLocalDate(str)
    }

    private[v0] implicit val jsonWritesJodaLocalDate = new Writes[org.joda.time.LocalDate] {
      def writes(x: org.joda.time.LocalDate) = {
        import org.joda.time.format.ISODateTimeFormat.date
        val str = date.print(x)
        JsString(str)
      }
    }

    implicit val jsonReadsApibuilderGeneratorFileFlag = new play.api.libs.json.Reads[io.apibuilder.generator.v0.models.FileFlag] {
      def reads(js: play.api.libs.json.JsValue): play.api.libs.json.JsResult[io.apibuilder.generator.v0.models.FileFlag] = {
        js match {
          case v: play.api.libs.json.JsString => play.api.libs.json.JsSuccess(io.apibuilder.generator.v0.models.FileFlag(v.value))
          case _ => {
            (js \ "value").validate[String] match {
              case play.api.libs.json.JsSuccess(v, _) => play.api.libs.json.JsSuccess(io.apibuilder.generator.v0.models.FileFlag(v))
              case err: play.api.libs.json.JsError => err
            }
          }
        }
      }
    }

    def jsonWritesApibuilderGeneratorFileFlag(obj: io.apibuilder.generator.v0.models.FileFlag) = {
      play.api.libs.json.JsString(obj.toString)
    }

    def jsObjectFileFlag(obj: io.apibuilder.generator.v0.models.FileFlag) = {
      play.api.libs.json.Json.obj("value" -> play.api.libs.json.JsString(obj.toString))
    }

    implicit def jsonWritesApibuilderGeneratorFileFlag: play.api.libs.json.Writes[FileFlag] = {
      new play.api.libs.json.Writes[io.apibuilder.generator.v0.models.FileFlag] {
        def writes(obj: io.apibuilder.generator.v0.models.FileFlag) = {
          jsonWritesApibuilderGeneratorFileFlag(obj)
        }
      }
    }

    implicit def jsonReadsApibuilderGeneratorAttribute: play.api.libs.json.Reads[Attribute] = {
      (
        (__ \ "name").read[String] and
        (__ \ "value").read[String]
      )(Attribute.apply _)
    }

    def jsObjectAttribute(obj: io.apibuilder.generator.v0.models.Attribute): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "name" -> play.api.libs.json.JsString(obj.name),
        "value" -> play.api.libs.json.JsString(obj.value)
      )
    }

    implicit def jsonWritesApibuilderGeneratorAttribute: play.api.libs.json.Writes[Attribute] = {
      new play.api.libs.json.Writes[io.apibuilder.generator.v0.models.Attribute] {
        def writes(obj: io.apibuilder.generator.v0.models.Attribute) = {
          jsObjectAttribute(obj)
        }
      }
    }

    implicit def jsonReadsApibuilderGeneratorError: play.api.libs.json.Reads[Error] = {
      (
        (__ \ "code").read[String] and
        (__ \ "message").read[String]
      )(Error.apply _)
    }

    def jsObjectError(obj: io.apibuilder.generator.v0.models.Error): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "code" -> play.api.libs.json.JsString(obj.code),
        "message" -> play.api.libs.json.JsString(obj.message)
      )
    }

    implicit def jsonWritesApibuilderGeneratorError: play.api.libs.json.Writes[Error] = {
      new play.api.libs.json.Writes[io.apibuilder.generator.v0.models.Error] {
        def writes(obj: io.apibuilder.generator.v0.models.Error) = {
          jsObjectError(obj)
        }
      }
    }

    implicit def jsonReadsApibuilderGeneratorFile: play.api.libs.json.Reads[File] = {
      (
        (__ \ "name").read[String] and
        (__ \ "dir").readNullable[String] and
        (__ \ "contents").read[String] and
        (__ \ "flags").readNullable[Seq[io.apibuilder.generator.v0.models.FileFlag]]
      )(File.apply _)
    }

    def jsObjectFile(obj: io.apibuilder.generator.v0.models.File): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "name" -> play.api.libs.json.JsString(obj.name),
        "contents" -> play.api.libs.json.JsString(obj.contents)
      ) ++ (obj.dir match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("dir" -> play.api.libs.json.JsString(x))
      }) ++
      (obj.flags match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("flags" -> play.api.libs.json.Json.toJson(x))
      })
    }

    implicit def jsonWritesApibuilderGeneratorFile: play.api.libs.json.Writes[File] = {
      new play.api.libs.json.Writes[io.apibuilder.generator.v0.models.File] {
        def writes(obj: io.apibuilder.generator.v0.models.File) = {
          jsObjectFile(obj)
        }
      }
    }

    implicit def jsonReadsApibuilderGeneratorGenerator: play.api.libs.json.Reads[Generator] = {
      (
        (__ \ "key").read[String] and
        (__ \ "name").read[String] and
        (__ \ "language").readNullable[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "attributes").read[Seq[String]]
      )(Generator.apply _)
    }

    def jsObjectGenerator(obj: io.apibuilder.generator.v0.models.Generator): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "key" -> play.api.libs.json.JsString(obj.key),
        "name" -> play.api.libs.json.JsString(obj.name),
        "attributes" -> play.api.libs.json.Json.toJson(obj.attributes)
      ) ++ (obj.language match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("language" -> play.api.libs.json.JsString(x))
      }) ++
      (obj.description match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("description" -> play.api.libs.json.JsString(x))
      })
    }

    implicit def jsonWritesApibuilderGeneratorGenerator: play.api.libs.json.Writes[Generator] = {
      new play.api.libs.json.Writes[io.apibuilder.generator.v0.models.Generator] {
        def writes(obj: io.apibuilder.generator.v0.models.Generator) = {
          jsObjectGenerator(obj)
        }
      }
    }

    implicit def jsonReadsApibuilderGeneratorHealthcheck: play.api.libs.json.Reads[Healthcheck] = {
      (__ \ "status").read[String].map { x => new Healthcheck(status = x) }
    }

    def jsObjectHealthcheck(obj: io.apibuilder.generator.v0.models.Healthcheck): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "status" -> play.api.libs.json.JsString(obj.status)
      )
    }

    implicit def jsonWritesApibuilderGeneratorHealthcheck: play.api.libs.json.Writes[Healthcheck] = {
      new play.api.libs.json.Writes[io.apibuilder.generator.v0.models.Healthcheck] {
        def writes(obj: io.apibuilder.generator.v0.models.Healthcheck) = {
          jsObjectHealthcheck(obj)
        }
      }
    }

    implicit def jsonReadsApibuilderGeneratorInvocation: play.api.libs.json.Reads[Invocation] = {
      (
        (__ \ "source").read[String] and
        (__ \ "files").read[Seq[io.apibuilder.generator.v0.models.File]]
      )(Invocation.apply _)
    }

    def jsObjectInvocation(obj: io.apibuilder.generator.v0.models.Invocation): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "source" -> play.api.libs.json.JsString(obj.source),
        "files" -> play.api.libs.json.Json.toJson(obj.files)
      )
    }

    implicit def jsonWritesApibuilderGeneratorInvocation: play.api.libs.json.Writes[Invocation] = {
      new play.api.libs.json.Writes[io.apibuilder.generator.v0.models.Invocation] {
        def writes(obj: io.apibuilder.generator.v0.models.Invocation) = {
          jsObjectInvocation(obj)
        }
      }
    }

    implicit def jsonReadsApibuilderGeneratorInvocationForm: play.api.libs.json.Reads[InvocationForm] = {
      (
        (__ \ "service").read[io.apibuilder.spec.v0.models.Service] and
        (__ \ "attributes").read[Seq[io.apibuilder.generator.v0.models.Attribute]] and
        (__ \ "user_agent").readNullable[String]
      )(InvocationForm.apply _)
    }

    def jsObjectInvocationForm(obj: io.apibuilder.generator.v0.models.InvocationForm): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "service" -> io.apibuilder.spec.v0.models.json.jsObjectService(obj.service),
        "attributes" -> play.api.libs.json.Json.toJson(obj.attributes)
      ) ++ (obj.userAgent match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("user_agent" -> play.api.libs.json.JsString(x))
      })
    }

    implicit def jsonWritesApibuilderGeneratorInvocationForm: play.api.libs.json.Writes[InvocationForm] = {
      new play.api.libs.json.Writes[io.apibuilder.generator.v0.models.InvocationForm] {
        def writes(obj: io.apibuilder.generator.v0.models.InvocationForm) = {
          jsObjectInvocationForm(obj)
        }
      }
    }
  }
}

package io.apibuilder.generator.v0 {

  object Bindables {

    import play.api.mvc.{PathBindable, QueryStringBindable}
    import org.joda.time.{DateTime, LocalDate}
    import org.joda.time.format.ISODateTimeFormat
    import io.apibuilder.generator.v0.models._

    trait ApibuilderTypeConverter[T] {

      def convert(value: String): T

      def convert(value: T): String

      def example: T

      def validValues: Seq[T] = Nil

      def errorMessage(key: String, value: String, ex: java.lang.Exception): String = {
        val base = s"Invalid value '$value' for parameter '$key'. "
        validValues.toList match {
          case Nil => base + "Ex: " + convert(example)
          case values => base + ". Valid values are: " + values.mkString("'", "', '", "'")
        }
      }
    }

    object ApibuilderTypeConverter {

      val dateTimeIso8601: ApibuilderTypeConverter[DateTime] = new ApibuilderTypeConverter[DateTime] {
        override def convert(value: String): DateTime = ISODateTimeFormat.dateTimeParser.parseDateTime(value)
        override def convert(value: DateTime): String = ISODateTimeFormat.dateTime.print(value)
        override def example: DateTime = DateTime.now
      }

      val dateIso8601: ApibuilderTypeConverter[LocalDate] = new ApibuilderTypeConverter[LocalDate] {
        override def convert(value: String): LocalDate = ISODateTimeFormat.yearMonthDay.parseLocalDate(value)
        override def convert(value: LocalDate): String = value.toString
        override def example: LocalDate = LocalDate.now
      }

    }

    case class ApibuilderQueryStringBindable[T](
      converters: ApibuilderTypeConverter[T]
    ) extends QueryStringBindable[T] {

      override def bind(key: String, params: Map[String, Seq[String]]): Option[Either[String, T]] = {
        params.getOrElse(key, Nil).headOption.map { v =>
          try {
            Right(
              converters.convert(v)
            )
          } catch {
            case ex: java.lang.Exception => Left(
              converters.errorMessage(key, v, ex)
            )
          }
        }
      }

      override def unbind(key: String, value: T): String = {
        converters.convert(value)
      }
    }

    case class ApibuilderPathBindable[T](
      converters: ApibuilderTypeConverter[T]
    ) extends PathBindable[T] {

      override def bind(key: String, value: String): Either[String, T] = {
        try {
          Right(
            converters.convert(value)
          )
        } catch {
          case ex: java.lang.Exception => Left(
            converters.errorMessage(key, value, ex)
          )
        }
      }

      override def unbind(key: String, value: T): String = {
        converters.convert(value)
      }
    }

    implicit val pathBindableDateTimeIso8601 = ApibuilderPathBindable(ApibuilderTypeConverter.dateTimeIso8601)
    implicit val queryStringBindableDateTimeIso8601 = ApibuilderQueryStringBindable(ApibuilderTypeConverter.dateTimeIso8601)

    implicit val pathBindableDateIso8601 = ApibuilderPathBindable(ApibuilderTypeConverter.dateIso8601)
    implicit val queryStringBindableDateIso8601 = ApibuilderQueryStringBindable(ApibuilderTypeConverter.dateIso8601)

    val converterFileFlag: ApibuilderTypeConverter[io.apibuilder.generator.v0.models.FileFlag] = new ApibuilderTypeConverter[io.apibuilder.generator.v0.models.FileFlag] {
      override def convert(value: String): io.apibuilder.generator.v0.models.FileFlag = io.apibuilder.generator.v0.models.FileFlag(value)
      override def convert(value: io.apibuilder.generator.v0.models.FileFlag): String = value.toString
      override def example: io.apibuilder.generator.v0.models.FileFlag = validValues.head
      override def validValues: Seq[io.apibuilder.generator.v0.models.FileFlag] = io.apibuilder.generator.v0.models.FileFlag.all
    }
    implicit val pathBindableFileFlag = ApibuilderPathBindable(converterFileFlag)
    implicit val queryStringBindableFileFlag = ApibuilderQueryStringBindable(converterFileFlag)

  }

}


package io.apibuilder.generator.v0 {

  object Constants {

    val BaseUrl = "https://api.apibuilder.io"
    val Namespace = "io.apibuilder.generator.v0"
    val UserAgent = "apibuilder 0.14.3 app.apibuilder.io/apicollective/apibuilder-generator/0.13.29/play_2_6_client"
    val Version = "0.13.29"
    val VersionMajor = 0

  }

  class Client(
    ws: play.api.libs.ws.WSClient,
    val baseUrl: String = "https://api.apibuilder.io",
    auth: scala.Option[io.apibuilder.generator.v0.Authorization] = None,
    defaultHeaders: Seq[(String, String)] = Nil
  ) extends interfaces.Client {
    import io.apibuilder.common.v0.models.json._
    import io.apibuilder.generator.v0.models.json._
    import io.apibuilder.spec.v0.models.json._

    private[this] val logger = play.api.Logger("io.apibuilder.generator.v0.Client")

    logger.info(s"Initializing io.apibuilder.generator.v0.Client for url $baseUrl")

    def generators: Generators = Generators

    def healthchecks: Healthchecks = Healthchecks

    def invocations: Invocations = Invocations

    object Generators extends Generators {
      override def get(
        key: _root_.scala.Option[String] = None,
        limit: Int = 100,
        offset: Int = 0,
        requestHeaders: Seq[(String, String)] = Nil
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[io.apibuilder.generator.v0.models.Generator]] = {
        val queryParameters = Seq(
          key.map("key" -> _),
          Some("limit" -> limit.toString),
          Some("offset" -> offset.toString)
        ).flatten

        _executeRequest("GET", s"/generators", queryParameters = queryParameters, requestHeaders = requestHeaders).map {
          case r if r.status == 200 => _root_.io.apibuilder.generator.v0.Client.parseJson("Seq[io.apibuilder.generator.v0.models.Generator]", r, _.validate[Seq[io.apibuilder.generator.v0.models.Generator]])
          case r => throw io.apibuilder.generator.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200")
        }
      }

      override def getByKey(
        key: String,
        requestHeaders: Seq[(String, String)] = Nil
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.apibuilder.generator.v0.models.Generator] = {
        _executeRequest("GET", s"/generators/${play.utils.UriEncoding.encodePathSegment(key, "UTF-8")}", requestHeaders = requestHeaders).map {
          case r if r.status == 200 => _root_.io.apibuilder.generator.v0.Client.parseJson("io.apibuilder.generator.v0.models.Generator", r, _.validate[io.apibuilder.generator.v0.models.Generator])
          case r if r.status == 404 => throw io.apibuilder.generator.v0.errors.UnitResponse(r.status)
          case r => throw io.apibuilder.generator.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200, 404")
        }
      }
    }

    object Healthchecks extends Healthchecks {
      override def get(
        requestHeaders: Seq[(String, String)] = Nil
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.apibuilder.generator.v0.models.Healthcheck] = {
        _executeRequest("GET", s"/_internal_/healthcheck", requestHeaders = requestHeaders).map {
          case r if r.status == 200 => _root_.io.apibuilder.generator.v0.Client.parseJson("io.apibuilder.generator.v0.models.Healthcheck", r, _.validate[io.apibuilder.generator.v0.models.Healthcheck])
          case r => throw io.apibuilder.generator.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200")
        }
      }
    }

    object Invocations extends Invocations {
      override def postByKey(
        key: String,
        invocationForm: io.apibuilder.generator.v0.models.InvocationForm,
        requestHeaders: Seq[(String, String)] = Nil
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.apibuilder.generator.v0.models.Invocation] = {
        val payload = play.api.libs.json.Json.toJson(invocationForm)

        _executeRequest("POST", s"/invocations/${play.utils.UriEncoding.encodePathSegment(key, "UTF-8")}", body = Some(payload), requestHeaders = requestHeaders).map {
          case r if r.status == 200 => _root_.io.apibuilder.generator.v0.Client.parseJson("io.apibuilder.generator.v0.models.Invocation", r, _.validate[io.apibuilder.generator.v0.models.Invocation])
          case r if r.status == 409 => throw io.apibuilder.generator.v0.errors.ErrorsResponse(r)
          case r => throw io.apibuilder.generator.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200, 409")
        }
      }
    }

    def _requestHolder(path: String): play.api.libs.ws.WSRequest = {

      val holder = ws.url(baseUrl + path).addHttpHeaders(
        "User-Agent" -> Constants.UserAgent,
        "X-Apidoc-Version" -> Constants.Version,
        "X-Apidoc-Version-Major" -> Constants.VersionMajor.toString
      ).addHttpHeaders(defaultHeaders : _*)
      auth.fold(holder) {
        case Authorization.Basic(username, password) => {
          holder.withAuth(username, password.getOrElse(""), play.api.libs.ws.WSAuthScheme.BASIC)
        }
        case a => sys.error("Invalid authorization scheme[" + a.getClass + "]")
      }
    }

    def _logRequest(method: String, req: play.api.libs.ws.WSRequest)(implicit ec: scala.concurrent.ExecutionContext): play.api.libs.ws.WSRequest = {
      val queryComponents = for {
        (name, values) <- req.queryString
        value <- values
      } yield s"$name=$value"
      val url = s"${req.url}${queryComponents.mkString("?", "&", "")}"
      auth.fold(logger.info(s"curl -X $method $url")) { _ =>
        logger.info(s"curl -X $method -u '[REDACTED]:' $url")
      }
      req
    }

    def _executeRequest(
      method: String,
      path: String,
      queryParameters: Seq[(String, String)] = Nil,
      requestHeaders: Seq[(String, String)] = Nil,
      body: Option[play.api.libs.json.JsValue] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[play.api.libs.ws.WSResponse] = {
      method.toUpperCase match {
        case "GET" => {
          _logRequest("GET", _requestHolder(path).addHttpHeaders(requestHeaders:_*).addQueryStringParameters(queryParameters:_*)).get()
        }
        case "POST" => {
          _logRequest("POST", _requestHolder(path).addHttpHeaders(_withJsonContentType(requestHeaders):_*).addQueryStringParameters(queryParameters:_*)).post(body.getOrElse(play.api.libs.json.Json.obj()))
        }
        case "PUT" => {
          _logRequest("PUT", _requestHolder(path).addHttpHeaders(_withJsonContentType(requestHeaders):_*).addQueryStringParameters(queryParameters:_*)).put(body.getOrElse(play.api.libs.json.Json.obj()))
        }
        case "PATCH" => {
          _logRequest("PATCH", _requestHolder(path).addHttpHeaders(requestHeaders:_*).addQueryStringParameters(queryParameters:_*)).patch(body.getOrElse(play.api.libs.json.Json.obj()))
        }
        case "DELETE" => {
          _logRequest("DELETE", _requestHolder(path).addHttpHeaders(requestHeaders:_*).addQueryStringParameters(queryParameters:_*)).delete()
        }
         case "HEAD" => {
          _logRequest("HEAD", _requestHolder(path).addHttpHeaders(requestHeaders:_*).addQueryStringParameters(queryParameters:_*)).head()
        }
         case "OPTIONS" => {
          _logRequest("OPTIONS", _requestHolder(path).addHttpHeaders(requestHeaders:_*).addQueryStringParameters(queryParameters:_*)).options()
        }
        case _ => {
          _logRequest(method, _requestHolder(path).addHttpHeaders(requestHeaders:_*).addQueryStringParameters(queryParameters:_*))
          sys.error("Unsupported method[%s]".format(method))
        }
      }
    }

    /**
     * Adds a Content-Type: application/json header unless the specified requestHeaders
     * already contain a Content-Type header
     */
    def _withJsonContentType(headers: Seq[(String, String)]): Seq[(String, String)] = {
      headers.find { _._1.toUpperCase == "CONTENT-TYPE" } match {
        case None => headers ++ Seq(("Content-Type" -> "application/json; charset=UTF-8"))
        case Some(_) => headers
      }
    }

  }

  object Client {

    def parseJson[T](
      className: String,
      r: play.api.libs.ws.WSResponse,
      f: (play.api.libs.json.JsValue => play.api.libs.json.JsResult[T])
    ): T = {
      f(play.api.libs.json.Json.parse(r.body)) match {
        case play.api.libs.json.JsSuccess(x, _) => x
        case play.api.libs.json.JsError(errors) => {
          throw io.apibuilder.generator.v0.errors.FailedRequest(r.status, s"Invalid json for class[" + className + "]: " + errors.mkString(" "))
        }
      }
    }

  }

  sealed trait Authorization extends _root_.scala.Product with _root_.scala.Serializable
  object Authorization {
    case class Basic(username: String, password: Option[String] = None) extends Authorization
  }

  package interfaces {

    trait Client {
      def baseUrl: String
      def generators: io.apibuilder.generator.v0.Generators
      def healthchecks: io.apibuilder.generator.v0.Healthchecks
      def invocations: io.apibuilder.generator.v0.Invocations
    }

  }

  trait Generators {
    /**
     * Get all available generators
     * 
     * @param key Filter generators with this key
     * @param limit The number of records to return
     * @param offset Used to paginate. First page of results is 0.
     */
    def get(
      key: _root_.scala.Option[String] = None,
      limit: Int = 100,
      offset: Int = 0,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[io.apibuilder.generator.v0.models.Generator]]

    /**
     * Get generator with this key
     */
    def getByKey(
      key: String,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.apibuilder.generator.v0.models.Generator]
  }

  trait Healthchecks {
    def get(
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.apibuilder.generator.v0.models.Healthcheck]
  }

  trait Invocations {
    /**
     * Invoke a generator
     */
    def postByKey(
      key: String,
      invocationForm: io.apibuilder.generator.v0.models.InvocationForm,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.apibuilder.generator.v0.models.Invocation]
  }

  package errors {

    import io.apibuilder.common.v0.models.json._
    import io.apibuilder.generator.v0.models.json._
    import io.apibuilder.spec.v0.models.json._

    case class ErrorsResponse(
      response: play.api.libs.ws.WSResponse,
      message: Option[String] = None
    ) extends Exception(message.getOrElse(response.status + ": " + response.body)){
      lazy val errors = _root_.io.apibuilder.generator.v0.Client.parseJson("Seq[io.apibuilder.generator.v0.models.Error]", response, _.validate[Seq[io.apibuilder.generator.v0.models.Error]])
    }

    case class UnitResponse(status: Int) extends Exception(s"HTTP $status")

    case class FailedRequest(responseCode: Int, message: String, requestUri: Option[_root_.java.net.URI] = None) extends _root_.java.lang.Exception(s"HTTP $responseCode: $message")

  }

}