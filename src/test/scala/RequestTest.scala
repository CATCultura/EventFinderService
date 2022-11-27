package cat.cultura.eventfinder

import cat.cultura.eventfinder.repository.request.EventRepositoryRequestImpl

import org.scalatest.flatspec.AnyFlatSpec

class RequestTest extends AnyFlatSpec {

  "Request" should "be ok" in {
    val repo = EventRepositoryRequestImpl()
    val res = repo.getAll
    println(res)
    assert(true)
  }

}